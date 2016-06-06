package com.uis.connector.ws.client;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.Stock;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.StockListing;
import com.uis.connector.ws.pojo.StockListingCriteria;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSRequestGetStockListing;
import com.uis.connector.ws.pojo.WSResponseGet;

import jersey.repackaged.com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
@IntegrationTest("server.port:8080")
public class StockWSClientTest {

	@Autowired 
	private WSRequestBuilder reqBuilder;
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
	public void testAddStock1(){
		Stock stock =  stockRepository.findOne(new Long(133));
		stockWSClient.addStockListing(Lists.newArrayList(stock));
	}
	
	@Test
	public void testGetStockListing(){
		WSResponseGet respondObj = stockWSClient.getStockListing(105628, "");
		Assert.assertNotNull(respondObj);
		Assert.assertNotNull(respondObj.getGetPartListings().getSuccess());
		Assert.assertTrue(respondObj.getGetStockListings().getSuccess().size() >0);
	}
	
	@Test
	public void testGetStockListingPagination(){
		WSRequestGetStockListing requestGetStockListing = new WSRequestGetStockListing();
		StockListingCriteria stockCriteria = new StockListingCriteria();
		stockCriteria.setSupplierId(String.valueOf(105628));
		stockCriteria.setPageNo(2);
		stockCriteria.setPageSize(10);
		requestGetStockListing.getGetStockListings().add(stockCriteria);
		
		WSRequestGet getSupplierRequest = reqBuilder.initWSRequestGet(requestGetStockListing);
		WSResponseGet responseObj = stockWSClient.sendWSGetRequest(getSupplierRequest);
		Assert.assertNotNull(responseObj);
		Assert.assertTrue(responseObj.getGetStockListings().getSuccess().size()==10);
	}
}
