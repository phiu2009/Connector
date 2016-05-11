package com.uis.connector.repository;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.Settings;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class SettingRepositoryTest {

	@Autowired
	private SettingRepository settingRepository;
	
	@Test
	@Transactional
	public void testGetSetting(){
		Settings setting = settingRepository.findOne(new Integer(1));
		
		Assert.assertNotNull(setting);
		Assert.assertNotNull(setting.getCompanyState());
		Assert.assertEquals(setting.getCompanyState().getState(), "Victoria");
	}
	
}
