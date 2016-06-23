package com.uis.connector.ws.client;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.DataShareSetting;
import com.uis.connector.entity.DatabaseVersion;
import com.uis.connector.entity.Settings;
import com.uis.connector.repository.DataShareSettingRepository;
import com.uis.connector.repository.DatabaseVersionRepository;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.SupplierCriteria;
import com.uis.connector.ws.pojo.SupplierPojo;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSRequestGetSupplier;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class SupplierWSClient extends AbstractWSClient{

	@Autowired 
	private WSRequestBuilder reqBuilder;
	
	@Autowired 
	private ApplicationState appState;
	@Autowired
	private DataShareSettingRepository dataShareSettingRepository;
	@Autowired
	private DatabaseVersionRepository databaseVersionRepository;
	
	@Scheduled(fixedRate=3600000)
	public void addSupplierInfo(Settings setting){
		WSResponseGet responseObj = getSupplier();
		
		WSRequest request = null;
		if (responseObj != null){
			// Send DataShareSetting to server
			request = reqBuilder.initWSRequest();
			SupplierPojo supplierPojo = new SupplierPojo(setting);
			DataShareSetting datashare = dataShareSettingRepository.findOne(1);
			DatabaseVersion databaseVersion = databaseVersionRepository.findOne(1);
			if (datashare != null && databaseVersion != null){
				supplierPojo.copyFrom(datashare);
				supplierPojo.setUisVersion(databaseVersion.getVersion());
				supplierPojo.setConnectorVersion(new BigDecimal(appState.getCurrentVersion()));
				
				if (responseObj.getGetSuppliers() != null && responseObj.getGetSuppliers().getSuccess() != null 
						&& responseObj.getGetSuppliers().getSuccess().size() > 0){
					request.update().addData(supplierPojo);
				}else{
					request.add().addData(supplierPojo);					
				}
			}
		}
				
		sendWSRequest(request);
	}

	public WSResponseGet getSupplier() {
		WSRequestGetSupplier requestGetSupplier = new WSRequestGetSupplier();
		SupplierCriteria supllierCriteria = new SupplierCriteria();
		supllierCriteria.setSupplierId(String.valueOf(appState.getPLSupplierId()));
		requestGetSupplier.getGetSuppliers().add(supllierCriteria);
		
		WSRequestGet getSupplierRequest = reqBuilder.initWSRequestGet(requestGetSupplier);
		WSResponseGet responseObj = sendWSGetRequest(getSupplierRequest);
		return responseObj;
	}
}
