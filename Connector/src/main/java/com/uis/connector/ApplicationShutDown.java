package com.uis.connector;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import com.uis.connector.entity.ConnectorSync;
import com.uis.connector.repository.SyncRepository;

@Component
public class ApplicationShutDown implements ApplicationListener<ContextClosedEvent>{

	@Autowired
	private SyncRepository syncRepository;
	
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		// TODO Auto-generated method stub
		ConnectorSync syncState = syncRepository.findOne(new Integer(1));
		syncState.setSerial(1);
		
		LocalDateTime currentTime = LocalDateTime.now();
		syncState.setLastInventorySync(currentTime);
		syncState.setLastStockSync(currentTime);
		syncState.setLastInventoryWSSync(currentTime);
		syncState.setLastPartImageWSSync(currentTime);
		syncState.setLastStockImageWSSync(currentTime);
		
//		syncRepository.save(syncState);
		syncRepository.updateLastCheck();
	}
}
