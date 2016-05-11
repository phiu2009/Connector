package com.uis.connector.task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.Inventory;
import com.uis.connector.repository.InventoryRepository;
import com.uis.connector.util.DateUtil;
import com.uis.connector.util.PartStatus;
import com.uis.connector.ws.client.InventoryWSClient;
import com.uis.connector.ws.pojo.PartListing;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class InventoryWSCheckTask {

	@Autowired
	private InventoryWSClient inventoryWSClient;
	@Autowired
	private InventoryRepository inventoryRepository;
	
	private LocalDateTime lastCheck;
	private ApplicationState appState;
	private static final Log logger = LogFactory.getLog(InventoryWSCheckTask.class);

//	@Scheduled(fixedRate=20000)
	public void checkForPartUpdateInWebServer(){
		WSResponseGet respondObj = inventoryWSClient.getPartListing(appState.getPLSupplierId(), 
				getLastCheck().format(DateUtil.formatter));
		
		if (respondObj != null && respondObj.getGetPartListings()!= null 
				&& respondObj.getGetPartListings().getSuccess().size() > 0){
			List<Long> updateSerials = new ArrayList<Long>();
			List<PartListing> updatePartFromServer = respondObj.getGetPartListings().getSuccess();
			for (PartListing partListing : updatePartFromServer){
				Inventory inv = inventoryRepository.findOne(partListing.getPartListingId());
				if (inv != null && partListing.getSoldDelete() == PartStatus.SOLD.getValue()){
					LocalDateTime partListingModifiedDateTime = LocalDateTime.parse(partListing.getModifiedDateTime(), DateUtil.formatter);
					if (partListingModifiedDateTime != null && 
							partListingModifiedDateTime.compareTo(inv.getModifiedDateTime()) > 0){
						updateSerials.add(inv.getSerial());
					}
				}
			}
			logger.info("The number of sold parts since lastCheck: " + updatePartFromServer.size());
			
			if (updateSerials.size() > 0){
				inventoryRepository.updateSoldStatus(updateSerials);
			}
			logger.info("Updated sold parts from server since lastCheck: " + updateSerials);
		}
		
		LocalDateTime currentTime = LocalDateTime.now();
		lastCheck = currentTime;
		
	}
	
	public LocalDateTime getLastCheck() {
		if (lastCheck == null){
			lastCheck = appState.getLastInventoryWSSync();
		}
		if (lastCheck == null){
			lastCheck = LocalDateTime.now();
		}
		return lastCheck;
	}
	
	@Autowired
	public void setAppState(ApplicationState appState) {
		this.appState = appState;
	}
}
