package com.uis.connector.ws.client;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.Settings;
import com.uis.connector.repository.SettingRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
@IntegrationTest("server.port:8080")
public class SupplierWSClientTest {

	@Autowired
	private SupplierWSClient supplierWSClient;
	
	@Autowired
	private SettingRepository settingRepository;
	
	@Test
	public void testGetSupplier(){
		Settings settings = settingRepository.findOne(1);
		supplierWSClient.addSupplierInfo(settings);
		
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
