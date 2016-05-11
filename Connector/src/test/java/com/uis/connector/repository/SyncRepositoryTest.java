package com.uis.connector.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.ConnectorSync;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class SyncRepositoryTest {

	@Autowired
	private SyncRepository syncRepository;
	
	
	@Test
	public void testGetConnectorSync(){
		Iterable<ConnectorSync> list = syncRepository.findAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.iterator().hasNext());
		
		ConnectorSync connectorSync = list.iterator().next();
		Assert.assertNotNull(connectorSync);
	}
}
