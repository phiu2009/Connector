package com.uis.connector.ws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.DataShareSetting;
import com.uis.connector.entity.Settings;
import com.uis.connector.repository.DataShareSettingRepository;
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
	
	public void addSupplierInfo(Settings setting){
		WSRequestGetSupplier requestGetSupplier = new WSRequestGetSupplier();
		SupplierCriteria supllierCriteria = new SupplierCriteria();
		supllierCriteria.setSupplierId(String.valueOf(appState.getPLSupplierId()));
		requestGetSupplier.getGetSuppliers().add(supllierCriteria);
		
		WSRequestGet getSupplierRequest = reqBuilder.initWSRequestGet(requestGetSupplier);
		WSResponseGet responseObj = sendWSGetRequest(getSupplierRequest);
		
		WSRequest request = reqBuilder.initWSRequest();
		SupplierPojo supplierPojo = new SupplierPojo(setting);
		// Get DataShareSetting
		DataShareSetting datashare = dataShareSettingRepository.findOne(1);
		if (datashare != null){
			supplierPojo.copyFrom(datashare);
		}
		if (responseObj != null && responseObj.getGetSuppliers() != null 
				&& responseObj.getGetSuppliers().getSuccess() != null 
				&& responseObj.getGetSuppliers().getSuccess().size() > 0){
			request.getUpdates().addData(supplierPojo);
		}else{
			request.getAdds().addData(supplierPojo);
			
			if (responseObj.getGetSuppliers().getSuccess().get(0).getForceResync() != null &&
					responseObj.getGetSuppliers().getSuccess().get(0).getForceResync() == 1){
				
			}
		}
		sendWSRequest(request);
	}
}
