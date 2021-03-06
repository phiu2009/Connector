package com.uis.connector.ws.client;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.AutoUpdater;
import com.uis.connector.repository.InventoryRepository;
import com.uis.connector.task.ForcedResyncTask;
import com.uis.connector.task.InventoryImageWSCheckTask;
import com.uis.connector.task.StockImageWSCheckTask;
import com.uis.connector.ws.pojo.PushEventPojo;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSResponseGet;


@Component
public class ConnectorSSEClient {

	private EventSource eventSource;
	private static final Log logger = LogFactory.getLog(ConnectorSSEClient.class);
	
	@Autowired
	private ApplicationState appState;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private InventoryImageWSCheckTask inventoryImageWSCheckTask;
	@Autowired 
	private StockImageWSCheckTask stockImageWSCheckTask;
	@Autowired
	private ForcedResyncTask forcedResyncTask;
	@Autowired
	private AutoUpdater autoUpdater;
	@Autowired
	private SupplierWSClient supplierWSClient;
	
	@PostConstruct
	public void init(){
		Client client = ClientBuilder.newBuilder().register(SseFeature.class).build();
		String URI = appState.getWebServerAddress() + "/UISws/rest/events/" + appState.getPLSupplierId();
		WebTarget target = client.target(URI);
//		eventSource = EventSource.target(target).reconnectingEvery(3, TimeUnit.MINUTES).build();
		eventSource = EventSource.target(target).build();
		EventListener listener = new EventListener() {
			@Override
			public void onEvent(InboundEvent inboundEvent) {
				String msg = inboundEvent.readData(String.class);
			    logger.info("Received message : " + msg);
			    processMessage(msg);
			}
			};
		eventSource.register(listener, "message-to-client");
		try{
			eventSource.open();
		}
		catch(Exception ex){
			logger.info("Web Server Send Event Connection Failed");
		}
		if (eventSource.isOpen()){
			logger.info("Web Server Send Event Connected");
		}else{
			logger.info("Web Server Send Event Connection Failed");
		}
	}
	
	public void reInit(){
		logger.info("Web Server Send Event Re-Init Connection");
		eventSource.close(1, TimeUnit.MINUTES);
		init();
	}
	
	@Scheduled(fixedRate=600000)
//	@Scheduled(fixedRate=120000)
	public void checkSSEConnetion(){
		if (!eventSource.isOpen()){
			eventSource.close();
			logger.info("Web Server Send Event Re-Init Connection");
			init();
		}else{
			logger.info("Web Server Send Event Check For Unsent Message");
			WSResponseGet response = supplierWSClient.getPushEvent();
			if (response != null && response.getGetPushEvent() != null && response.getGetPushEvent().getSuccess() != null &&
					response.getGetPushEvent().getSuccess().size() > 0){
				for (PushEventPojo eventObj : response.getGetPushEvent().getSuccess()){
					processMessage(eventObj.getEventMessage());
				}
			}
		}
	}
	
	private void processMessage(String msg){
		try {
			JSONObject msgObj = new JSONObject(msg);
			if (msgObj.getLong("supplierId") == appState.getPLSupplierId()){
				// Get common message data
				long partListingId = 0;
				long stockListingId = 0;
				if (msgObj.opt("partListingId") != null){
					partListingId = msgObj.getLong("partListingId");
				}
				if (msgObj.opt("stockListingId") != null){
					stockListingId = msgObj.getLong("stockListingId");
				}
				boolean sseReInit = false;
				// Process each event
				if ("testConnection".equals(msgObj.get("eventType"))){
					
				} else if ("sseReInit".equals(msgObj.get("eventType"))){
					sseReInit = true;
				}
				else if ("partSold".equals(msgObj.get("eventType"))){
					inventoryRepository.updateSoldStatus(partListingId);
					logger.info("Part Sold status udpated: " + partListingId);
				}else if("imageUpdated".equals(msgObj.get("eventType")) || "imageAdded".equals(msgObj.get("eventType"))){
					int imageId = 0;
					if (msgObj.opt("imageId") != null){
						imageId = msgObj.getInt("imageId");
					}
					if (partListingId > 0 && stockListingId >0){
						inventoryImageWSCheckTask.checkForPartImageUpdateInWebServer(String.valueOf(stockListingId),
								String.valueOf(partListingId), String.valueOf(imageId));
					}else if (stockListingId > 0){
						stockImageWSCheckTask.checkForStockImageUpdateInWebServer(String.valueOf(stockListingId), 
								String.valueOf(imageId));
					}
				}else if ("forceResync".equals(msgObj.get("eventType"))){
					forcedResyncTask.resync();
				}else if ("forceUpdate".equals(msgObj.get("eventType"))){
					autoUpdater.checkForUpdate();
				}else if ("updatePartLocation".equals(msgObj.get("eventType"))){
					String newLocation = msgObj.getString("location");
					inventoryRepository.updateInvLocation(partListingId, newLocation);
				}else if ("partSentToEbay".equals(msgObj.get("eventType"))){
					inventoryRepository.updateSentToEbay(partListingId);
					logger.info("Part sent to ebay: " + partListingId);
				}
				// Acknowledge SSE Message received
				supplierWSClient.sendSimplifyRequest(msgObj);
				// Re initialize SSE Connection
				if (sseReInit){
					reInit();
				}
			}
		}catch(JSONException je){
			je.printStackTrace();
			logger.error(je.getMessage());
		}
	}
	
	@PreDestroy
	public void closeConnection(){
		eventSource.close();
		logger.info("Web Server Send Event Closed");
	}
}
