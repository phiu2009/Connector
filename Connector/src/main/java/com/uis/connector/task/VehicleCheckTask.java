package com.uis.connector.task;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.Stock;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.repository.SyncRepository;
import com.uis.connector.ws.client.StockWSClient;

@Component
public class VehicleCheckTask {

	private static final Log logger = LogFactory.getLog(VehicleCheckTask.class);
	private LocalDateTime lastCheck;
	private ApplicationState appState;
	
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private StockWSClient stockWSClient;
	@Autowired
	private SyncRepository syncRepository;
	
	@Scheduled(fixedRate=300000)
	public void checkForVehicleUpdate(){
		LocalDateTime currentTime = LocalDateTime.now();
		
		List<Stock> vehicleList = null;
		if (getLastCheck() == null){
			vehicleList = stockRepository.findAllActiveStock();
			logger.info("The number of updated stocks since lastCheck: " + vehicleList.size());
		}
		else{
			vehicleList = stockRepository.findByModifiedDateTimeGreaterThan(getLastCheck());
			logger.info("The number of updated stocks since lastCheck: " + vehicleList.size());
		}
		
		if (vehicleList != null && vehicleList.size() > 0){
			stockWSClient.addStockListing(vehicleList);
		}
		
		lastCheck = currentTime;
		syncRepository.updateLastStockCheck();
	}
	
	public LocalDateTime getLastCheck() {
		if (lastCheck == null){
			lastCheck = appState.getLastStockSync();
		}
		return lastCheck;
	}
	
	private int getTimeInteval(){
		return appState.getTimeInteval();
	}
	
	@Autowired
	public void setAppState(ApplicationState appState) {
		this.appState = appState;
	}
}
