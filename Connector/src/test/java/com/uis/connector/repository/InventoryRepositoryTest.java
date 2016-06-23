package com.uis.connector.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void testUpdateSentToEbay(){
		inventoryRepository.updateSentToEbay(920l);
		Inventory inv = inventoryRepository.findOne(920l);
		Assert.assertNotNull(inv);
		Assert.assertEquals(1, inv.getOnEbay().intValue());
	}
}
