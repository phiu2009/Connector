package com.uis.connector.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.Inventory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class InventoryRepositoryTest {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Test
	public void testFindAllInventory(){
		List<Inventory> list = inventoryRepository.findAllActiveInventory();
		Assert.notNull(list);
		Assert.isTrue(list.size() > 0);
	}
	
	@Test
	public void testUpdateWSSyncStatus(){
		
	}
}
