package com.uis.connector.ws.client;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void addSupplierInfo(Settings setting, BigDecimal connectorVersion){
		WSRequestGetSupplier requestGetSupplier = new WSRequestGetSupplier();
		SupplierCriteria supllierCriteria = new SupplierCriteria();
		supllierCriteria.setSupplierId(String.valueOf(appState.getPLSupplierId()));
		requestGetSupplier.getGetSuppliers().add(supllierCriteria);
		
		WSRequestGet getSupplierRequest = reqBuilder.initWSRequestGet(requestGetSupplier);
		WSResponseGet responseObj = sendWSGetRequest(getSupplierRequest);
		
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
				supplierPojo.setConnectorVersion(connectorVersion);
				
				if (responseObj.getGetSuppliers() != null && responseObj.getGetSuppliers().getSuccess() != null 
						&& responseObj.getGetSuppliers().getSuccess().size() > 0){
					request.getUpdates().addData(supplierPojo);
				}else{
					request.getAdds().addData(supplierPojo);
					
					if (responseObj.getGetSuppliers().getSuccess().get(0).getForceResync() != null &&
							responseObj.getGetSuppliers().getSuccess().get(0).getForceResync() == 1){
						
					}
				}
			}
		}
				
		sendWSRequest(request);
	}
}
