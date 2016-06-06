package com.uis.connector;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.uis.connector.entity.ConnectorSync;
import com.uis.connector.entity.Locations;
import com.uis.connector.entity.Settings;
import com.uis.connector.repository.LocationRepository;
import com.uis.connector.repository.SettingRepository;
import com.uis.connector.repository.SyncRepository;
import com.uis.connector.ws.client.SupplierWSClient;

@Component
//@PropertySource("classpath:application.properties")
public class ApplicationState {

	private ConnectorSync syncState;
	private Settings setting;
	private double currentVersion = -1;
	private final int DEFAULT_INTEVAL = 20000;
	private static final Log logger = LogFactory.getLog(ApplicationState.class);
	
	@Value(value = "${connector.timeInterval}")
	private String timeInteval;
	@Value(value= "${uiswebserver.url}")
	private String serverURL;
	@Value(value= "${uiswebserver.port}")
	private String serverPort;
	@Value(value= "${connector.plSupplierId}")
	private String plSupplierId;
	
	private Map<Integer, String> locationMap = new HashMap<Integer, String>();
	
	@Autowired
	private SyncRepository syncRepository;
	@Autowired
	private SettingRepository settingRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private SupplierWSClient supplierWSClient;
	@Autowired
	private AutoUpdater autoUpdater;
	
	
	@PostConstruct
	public void initialize(){
		syncState = syncRepository.findOne(new Integer(1));
		setting = settingRepository.findOne(new Integer(1));
		
		if (syncState == null || setting == null){
			throw new RuntimeException("Cannot initialize application state or settings.");
		}
		
		// check for update
//		double currentVersion = 0.0;
		if (syncState.getVersion() != null){
			currentVersion = syncState.getVersion().doubleValue();
		}
		autoUpdater.checkForUpdate();
		
		// Send suppliers info
		supplierWSClient.addSupplierInfo(setting);
		
		// Init locations 
		Iterable<Locations> locationIterator = locationRepository.findAll();
		locationIterator.forEach(location -> locationMap.put(location.getSerial(), location.getLocationDetail()));
		
		logger.info("Initiated setting: supplierCode:" + getPLSupplierCode() 
				+ " LastInventorySync:" + getLastInventorySync()
				+ " LastStockSync: " + getLastStockSync()
				+ " TimeInteval: " + getTimeInteval());
	}

	public String getPLSupplierCode(){
		return setting.getPlSupplierCode();
	}
	
	public long getPLSupplierId(){
		Long supplierId = Long.parseLong(plSupplierId);
		if (supplierId != null && supplierId.longValue() > 0){
			return supplierId.longValue();
		}
		if (setting != null && setting.getPlSupplierId() > 0){
			return setting.getPlSupplierId();
		}
		return 0;
	}
	
	public LocalDateTime getLastInventorySync() {
		return syncState.getLastInventorySync();
	}

	public LocalDateTime getLastStockSync() {
		return syncState.getLastStockSync();
	}

	public LocalDateTime getLastInventoryWSSync() {
		return syncState.getLastInventoryWSSync();
	}
	
	public LocalDateTime getLastPartImageWSSync() {
		return syncState.getLastPartImageWSSync();
	}
	
	public LocalDateTime getLastStockImageWSSync() {
		return syncState.getLastStockImageWSSync();
	}
	
	public int getTimeInteval() {
		if (timeInteval != null && !"".equals(timeInteval)){
			try{
				int inteval = Integer.parseInt(timeInteval);
				return inteval;
			}catch(NumberFormatException ex){
				logger.error(ex.getMessage());
			}
		}
		return DEFAULT_INTEVAL;
	}
	
	public String getServerURL() {
		return serverURL;
	}
	
	public String getWebServerAddress() {
		return serverURL+":"+serverPort;
	}
	
	public Map<Integer, String> getLocationMap() {
		return locationMap;
	}
	
	public double getCurrentVersion() {
		return currentVersion;
	}
}


