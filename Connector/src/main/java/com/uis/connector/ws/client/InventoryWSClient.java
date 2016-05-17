package com.uis.connector.ws.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.entity.Inventory;
import com.uis.connector.repository.InventoryRepository;
import com.uis.connector.util.PartStatus;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.PartListingCriteria;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSRequestGetPartListing;
import com.uis.connector.ws.pojo.WSResponse;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class InventoryWSClient extends AbstractWSClient{

	private static final Log logger = LogFactory.getLog(InventoryWSClient.class);
	
	@Autowired 
	private WSRequestBuilder reqBuilder;
	@Autowired 
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private ImageWSClient inventoryImageWSClient;
	
	private boolean forcedResync = false;
	
	public WSResponse addPartListing(List<Inventory> partListings){
        WSRequest request = reqBuilder.initWSRequest();
        if (forcedResync){
        	reqBuilder.buildWSRequestResync(partListings);
        }else{
        	reqBuilder.buildWSRequest(partListings);
        }
        
        // Send inventory add/update request
        WSResponse responseObj = sendWSRequest(request);
         
        List<Long> partListingSerials = new ArrayList<Long>();
        partListings.forEach(partListing -> {
        	partListingSerials.add(partListing.getSerial());
        	// Add images
        	if (!partListing.isSynced() || forcedResync){
        		inventoryImageWSClient.setForcedResync(forcedResync);
        		inventoryImageWSClient.addInventoryImages(partListing.getSerial());
        	}else{
        		inventoryImageWSClient.updateInventoryImages(partListing.getSerial());
        	}
        });
        
        if (responseObj != null && partListingSerials.size() > 0){
        	logger.info("Update parts wsSync status: " + partListingSerials.toString());
        	inventoryRepository.updateWSSyncStatus(partListingSerials);
        }
        
        return responseObj;
	}

	public WSResponseGet getPartListing(long supplierId, String lastCheckTime){
		WSRequestGetPartListing requestGetPartListing = new WSRequestGetPartListing();
		PartListingCriteria partCriteria = new PartListingCriteria();
		partCriteria.setSupplierId(String.valueOf(supplierId));
		partCriteria.setSoldDelete(String.valueOf(PartStatus.SOLD.getValue()));
		partCriteria.setModifiedDateTime(lastCheckTime);
		requestGetPartListing.getGetPartListings().add(partCriteria);
		
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
