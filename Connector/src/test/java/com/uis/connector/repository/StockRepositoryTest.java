package com.uis.connector.repository;

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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class StockRepositoryTest {

	@Autowired
	private StockRepository stockRepository;
	
	@Test
	public void testFindByModfiedDateTime(){
		LocalDateTime lastUpdate = LocalDateTime.of(2016, 3, 22, 12, 30, 0);
		List<Stock> list = stockRepository.findByModifiedDateTimeGreaterThan(lastUpdate);
		Assert.assertNotNull(list);
	}
}
