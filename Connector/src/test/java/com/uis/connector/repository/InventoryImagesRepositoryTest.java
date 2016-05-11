package com.uis.connector.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.InventoryImages;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class InventoryImagesRepositoryTest {

	@Autowired
	private InventoryImageRepository inventoryImagesRepository;
	
	@Test
	public void testFindByInventorySerial(){
		List<InventoryImages> list = inventoryImagesRepository.findByInventorySerialOrderByImageNo(876);
		Assert.notNull(list);
		Assert.isTrue(list.size() == 10);
	}
	
	@Test
	public void testFindByStockSerial(){
		List<InventoryImages> list = inventoryImagesRepository.findByStockSerial(130);
		Assert.notNull(list);
		Assert.isTrue(list.size() == 10);
	}
	
	@Test
	public void testFindByInventorySerialAndImageNo(){
		List<InventoryImages> list = inventoryImagesRepository.findByInventorySerialAndImageNo(876, 1);
		Assert.notNull(list);
		Assert.isTrue(list.size() == 1);
	}
}
