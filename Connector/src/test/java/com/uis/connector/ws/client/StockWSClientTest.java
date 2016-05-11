package com.uis.connector.ws.client;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.Stock;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.ws.pojo.WSResponseGet;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class StockWSClientTest {

	@Autowired
	private StockWSClient stockWSClient;
	@Autowired
	private StockRepository stockRepository;
	
	@Test
	public void testAddStock(){
		LocalDateTime lastUpdated = LocalDateTime.of(2016, 4, 21, 11, 30, 0);
		List<Stock> stockListings =  stockRepository.findByModifiedDateTimeGreaterThan(lastUpdated);
		stockWSClient.addStockListing(stockListings);
	}
	
	@Test
	public void testGetStockListing(){
		WSResponseGet respondObj = stockWSClient.getStockListing(105628, "");
		Assert.assertNotNull(respondObj);
		Assert.assertNotNull(respondObj.getGetPartListings().getSuccess());
		Assert.assertTrue(respondObj.getGetStockListings().getSuccess().size() >0);
	}
}
