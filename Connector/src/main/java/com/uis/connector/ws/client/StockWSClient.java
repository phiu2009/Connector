package com.uis.connector.ws.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.entity.Stock;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.StockListingCriteria;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSRequestGetStockListing;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class StockWSClient extends AbstractWSClient{

	@Autowired 
	private WSRequestBuilder reqBuilder;
	@Autowired
	private ImageWSClient inventoryImageWSClient;
	@Autowired
	private StockRepository stockRepository;
	
	private boolean forcedResync = false;
	
	public void addStockListing(List<Stock> stockListings){
         WSRequest request = reqBuilder.initWSRequest();
         if (forcedResync){
        	 reqBuilder.buildWSStockRequestResync(stockListings);
         }else{
        	 reqBuilder.buildWSStockRequest(stockListings);
         }
         
         sendWSRequest(request);
         
         List<Long> stockListingSerials = new ArrayList<Long>();
         stockListings.forEach(stockListing -> {
         	stockListingSerials.add(stockListing.getSerial());
         	// Add images
         	if (!stockListing.isSynced() || forcedResync){
         		inventoryImageWSClient.addStockImages(stockListing.getSerial());
         	}else{
         		inventoryImageWSClient.updateStockImages(stockListing.getSerial());
         	}
         });
         
         if (stockListingSerials.size() > 0){
        	 logger.info("Update stock wsSync status: " + stockListingSerials.toString());
         	stockRepository.updateWSSyncStatus(stockListingSerials);
         }
         forcedResync = false;
	}
	
	public WSResponseGet getStockListing(long supplierId, String lastCheck){
		WSRequestGetStockListing requestGetStockListing = new WSRequestGetStockListing();
		StockListingCriteria stockCriteria = new StockListingCriteria();
		stockCriteria.setSupplierId(String.valueOf(supplierId));
		requestGetStockListing.getGetStockListings().add(stockCriteria);
		
		WSRequestGet getSupplierRequest = reqBuilder.initWSRequestGet(requestGetStockListing);
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
