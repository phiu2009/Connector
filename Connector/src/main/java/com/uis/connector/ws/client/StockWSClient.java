package com.uis.connector.ws.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.entity.Stock;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.StockListingCriteria;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSRequestGetStockListing;
import com.uis.connector.ws.pojo.WSResponse;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class StockWSClient extends AbstractWSClient{

	private static final Log logger = LogFactory.getLog(StockWSClient.class);
	
	@Autowired 
	private WSRequestBuilder reqBuilder;
	@Autowired 
	private StockRepository stockRepository;
	
	@Autowired
	private ImageWSClient stockImageWSClient;
	
	private boolean forcedResync = false;
	
	public WSResponse addStockListing(List<Stock> stockListings){
        WSRequest request = reqBuilder.initWSRequest();
        if (forcedResync){
        	reqBuilder.buildWSStockRequestResync(stockListings);
        }else{
        	reqBuilder.buildWSStockRequest(stockListings);
        }
        
        // Send Stock add/update request
        WSResponse responseObj = sendWSRequest(request);
         
        List<Long> stockListingSerials = new ArrayList<Long>();
        stockListings.forEach(stockListing -> {
        	stockListingSerials.add(stockListing.getSerial());
        	// Add images
        	if (!stockListing.isSynced() || forcedResync){
        		stockImageWSClient.setForcedResync(forcedResync);
        		stockImageWSClient.addStockImages(stockListing.getSerial());
        	}else{
        		stockImageWSClient.updateStockImages(stockListing.getSerial());
        	}
        });
        
        if (responseObj != null && stockListingSerials.size() > 0){
        	logger.info("Update parts wsSync status: " + stockListingSerials.toString());
        	stockRepository.updateWSSyncStatus(stockListingSerials);
        }
        
        return responseObj;
	}

	public WSResponseGet getStockListing(long supplierId, String lastCheckTime){
		WSRequestGetStockListing requestGetPartListing = new WSRequestGetStockListing();
		StockListingCriteria stockCriteria = new StockListingCriteria();
		stockCriteria.setSupplierId(String.valueOf(supplierId));
		requestGetPartListing.getGetStockListings().add(stockCriteria);
		
		WSRequestGet getSupplierRequest = reqBuilder.initWSRequestGet(requestGetPartListing);
		WSResponseGet responseObj = sendWSGetRequest(getSupplierRequest);
		return responseObj;
	}

	public boolean isForcedResync() {
		return forcedResync;
	}

	public void setForcedResync(boolean forcedResync) {
		this.forcedResync = forcedResync;
	}
	
	
}
