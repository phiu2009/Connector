package com.uis.connector.ws.client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.Inventory;
import com.uis.connector.repository.InventoryRepository;
import com.uis.connector.util.DateUtil;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSResponseGet;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class InventoryWSClientTest {

	@Autowired
	private InventoryWSClient inventoryWSClient;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private WSRequestBuilder reqBuilder;
	
	@Test
	@Transactional
	public void testAddInventory(){
		LocalDateTime lastUpdated = LocalDateTime.of(2016, 4, 7, 9, 20, 0);
		List<Inventory> partListings =  inventoryRepository.findByModifiedDateTimeGreaterThan(lastUpdated);
		inventoryWSClient.addPartListing(partListings);
	}
	
	@Test
	public void testSoldInventory(){
		List<Inventory> partListings = new ArrayList<Inventory>();
		partListings.add(inventoryRepository.findOne(new Long(900)));
		partListings.forEach(part -> part.setSold(1));
		
		WSRequest request = reqBuilder.initWSRequest();
		request.setPushEvent("true");
        reqBuilder.buildWSRequest(partListings);
        
        inventoryWSClient.sendWSRequest(request);
        
        try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPartListing(){
		LocalDateTime lastCheck = LocalDateTime.of(2016,4, 1, 0, 30, 0);
		WSResponseGet respondObj = inventoryWSClient.getPartListing(105628, lastCheck.format(DateUtil.formatter));
		Assert.assertNotNull(respondObj);
		Assert.assertNotNull(respondObj.getGetPartListings().getSuccess());
		Assert.assertTrue(respondObj.getGetPartListings().getSuccess().size() >0);
	}
	
//	@Test
//	public void testGetVehicles(){
//		LocalDateTime lastCheck = LocalDateTime.of(2016,4, 1, 0, 30, 0);
//		WSResponseGet respondObj = inventoryWSClient.getPartListing(105628, lastCheck.format(DateUtil.formatter));
//		Assert.assertNotNull(respondObj);
//		Assert.assertNotNull(respondObj.getGetPartListings().getSuccess());
//		Assert.assertTrue(respondObj.getGetPartListings().getSuccess().size() >0);
//	}
}
