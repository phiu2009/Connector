package com.uis.connector.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.entity.Inventory;
import com.uis.connector.entity.Stock;
import com.uis.connector.repository.InventoryRepository;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.ws.client.InventoryWSClient;
import com.uis.connector.ws.client.StockWSClient;

@Component
public class ForcedResyncTask {

	private static final Log logger = LogFactory.getLog(VehicleCheckTask.class);
	
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private StockWSClient stockWSClient;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private InventoryWSClient inventoryWSClient;
	private final int MAX_LISTING_PER_REQUEST = 5000;
	
	public void resync(){
		logger.info("Resync stock listings started");
		List<Stock> vehicleList = null;
		vehicleList = stockRepository.findAllActiveStock();
		if (vehicleList != null && vehicleList.size() > 0){
			logger.info("The number of stock listings to resync: " + vehicleList.size());
			stockWSClient.setForcedResync(true);
			stockWSClient.addStockListing(vehicleList);
		}
		logger.info("Resync stock listings completed");
		
		logger.info("Resync part listings started");
		List<Inventory> partList = inventoryRepository.findAllActiveInventory();
		if (partList != null){
			logger.info("The number of part listings to resync : " + partList.size());
			inventoryWSClient.setForcedResync(true);
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
			inventoryWSClient.setForcedResync(false);
		}
		logger.info("Resync part listings completed");
	}
}
