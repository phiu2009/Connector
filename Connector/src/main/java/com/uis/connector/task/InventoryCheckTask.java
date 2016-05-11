package com.uis.connector.task;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.Inventory;
import com.uis.connector.repository.InventoryRepository;
import com.uis.connector.repository.SyncRepository;
import com.uis.connector.ws.client.InventoryWSClient;

@Component
public class InventoryCheckTask {

	private LocalDateTime lastCheck;
	private ApplicationState appState;
	private static final Log logger = LogFactory.getLog(InventoryCheckTask.class);
	
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private InventoryWSClient inventoryWSClient;
	@Autowired
	private SyncRepository syncRepository;
	
	private final int MAX_LISTING_PER_REQUEST = 5000;
	
	@Scheduled(fixedRate=60000)
	public void checkForPartUpdate(){
		List<Inventory> partList = null;
		if (getLastCheck() == null){
			partList = inventoryRepository.findAllActiveInventory();
			logger.info("The number of active parts: " + partList.size());
		}
		else{
			partList = inventoryRepository.findByModifiedDateTimeGreaterThan(getLastCheck());
			logger.info("The number of updated parts since lastCheck: " + partList.size());
		}
		
		if (partList != null){
			if (partList.size() > 0 && partList.size() < MAX_LISTING_PER_REQUEST){
				inventoryWSClient.addPartListing(partList);
			}else{
				while (partList.size() > 0){
					if (partList.size() > MAX_LISTING_PER_REQUEST){
						inventoryWSClient.addPartListing(partList.subList(0, MAX_LISTING_PER_REQUEST));
						partList.subList(0, MAX_LISTING_PER_REQUEST).clear();
					}else{
						inventoryWSClient.addPartListing(partList.subList(0, partList.size()));
						partList.subList(0, partList.size()).clear();
					}
				}
			}
		}

		LocalDateTime currentTime = LocalDateTime.now();
		lastCheck = currentTime;
		syncRepository.updateLastInventoryCheck();
	}
	
	public LocalDateTime getLastCheck() {
		if (lastCheck == null){
			lastCheck = appState.getLastInventorySync();
		}
		return lastCheck;
	}
	
	@Autowired
	public void setAppState(ApplicationState appState) {
		this.appState = appState;
	}
}
