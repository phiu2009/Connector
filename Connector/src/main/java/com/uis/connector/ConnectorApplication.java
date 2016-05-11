package com.uis.connector;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.uis.connector.repository.SyncRepository;

@EntityScan(basePackageClasses = { ConnectorApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
@EnableScheduling
public class ConnectorApplication {

	@Autowired
	private SyncRepository syncRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConnectorApplication.class, args);
	}
	
//	@PreDestroy
//	public void shutDownHook(){
//		syncRepository.updateLastCheck();
//	}
}
