package com.uis.connector.task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.Inventory;
import com.uis.connector.entity.InventoryImages;
import com.uis.connector.repository.InventoryImageRepository;
import com.uis.connector.repository.InventoryRepository;
import com.uis.connector.util.DateUtil;
import com.uis.connector.util.ImageUtil;
import com.uis.connector.ws.client.ImageWSClient;
import com.uis.connector.ws.pojo.PartListingImagePojo;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class InventoryImageWSCheckTask {

	@Autowired
	private ImageWSClient inventoryImageWSClient;
	@Autowired
	private InventoryImageRepository inventoryImageRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	
	private LocalDateTime lastCheck;
	private ApplicationState appState;
	private static final Log logger = LogFactory.getLog(InventoryImageWSCheckTask.class);

//	@Scheduled(fixedRate=20000)
	public void checkForPartImageUpdateInWebServer(){
		WSResponseGet respondObj = inventoryImageWSClient.getPartImage(getLastCheck().format(DateUtil.formatter));
		processRepsonse(respondObj);
		
		LocalDateTime currentTime = LocalDateTime.now();
		lastCheck = currentTime;
	}
	
	public void checkForPartImageUpdateInWebServer(String stockListingId, String partListingId, String imageId){
		WSResponseGet respondObj = inventoryImageWSClient.getPartImageByPartListingId(stockListingId, partListingId, imageId);
		processRepsonse(respondObj);
		
	}

	private void processRepsonse(WSResponseGet respondObj) {
		if (respondObj != null && respondObj.getGetPartImages()!= null 
				&& respondObj.getGetPartImages().getSuccess().size() > 0){
			List<PartListingImagePojo> updatePartImageFromServer = respondObj.getGetPartImages().getSuccess();
			logger.info("The number of updated images from server: " + updatePartImageFromServer.size());
			
			for (PartListingImagePojo partImage : updatePartImageFromServer){
				StringBuffer imgUrl = new StringBuffer(partImage.getImage());
				imgUrl.replace(0, 13, appState.getServerURL());
				
				// Delete old image and update with the updated one from server
				inventoryImageRepository.deleteByInvSerialAndImgNo(partImage.getPartListingId(), partImage.getImageId());
				List<String> encodedData = ImageUtil.encodeImage(imgUrl.toString());
				for (String imgData : encodedData){
					InventoryImages img = new InventoryImages();
					img.setData(imgData);
					img.setImageNo(partImage.getImageId());
					img.setInventorySerial(partImage.getPartListingId());
					img.setStockSerial(partImage.getStockListingId());
					img.setWsSync(1);
					inventoryImageRepository.save(img);
					
					logger.info("Updated image "+ partImage.getImageId() + " from server for partListing: " + partImage.getPartListingId());
				}
				
				// Save snapshot image into inventory
				String snapshotImage = ImageUtil.resizeImageForThumbNail(imgUrl.toString());
				if (partImage.getImageId() == 1){
					inventoryRepository.updateInvImage1(partImage.getPartListingId(), snapshotImage);
				}else if (partImage.getImageId() == 2){
					inventoryRepository.updateInvImage2(partImage.getPartListingId(), snapshotImage);
				}else if (partImage.getImageId() == 3){
					inventoryRepository.updateInvImage3(partImage.getPartListingId(), snapshotImage);
				}else if (partImage.getImageId() == 4){
					inventoryRepository.updateInvImage4(partImage.getPartListingId(), snapshotImage);
				}
			}
		}
	}
	
	public LocalDateTime getLastCheck() {
		if (lastCheck == null){
			lastCheck = appState.getLastPartImageWSSync();
		}
		if (lastCheck == null){
			lastCheck = LocalDateTime.now();
		}
		return lastCheck;
	}
	
	@Autowired
	public void setAppState(ApplicationState appState) {
		this.appState = appState;
	}
}
