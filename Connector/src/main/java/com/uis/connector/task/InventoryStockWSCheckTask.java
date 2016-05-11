package com.uis.connector.task;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.InventoryImages;
import com.uis.connector.repository.InventoryImageRepository;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.util.DateUtil;
import com.uis.connector.util.ImageUtil;
import com.uis.connector.ws.client.ImageWSClient;
import com.uis.connector.ws.pojo.StockListingImagePojo;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class InventoryStockWSCheckTask {

	@Autowired
	private ImageWSClient stockImageWSClient;
	@Autowired
	private InventoryImageRepository inventoryImageRepository;
	@Autowired
	private StockRepository stockRepository;
	
	private LocalDateTime lastCheck;
	private ApplicationState appState;
	private static final Log logger = LogFactory.getLog(InventoryStockWSCheckTask.class);

//	@Scheduled(fixedRate=20000)
	public void checkForPartImageUpdateInWebServer(){
		WSResponseGet respondObj = stockImageWSClient.getStockImage(getLastCheck().format(DateUtil.formatter));
		
		if (respondObj != null && respondObj.getGetPartImages()!= null 
				&& respondObj.getGetPartImages().getSuccess().size() > 0){
			List<StockListingImagePojo> updatePartImageFromServer = respondObj.getGetStockListingImages().getSuccess();
			logger.info("The number of updated stock images since lastCheck: " + updatePartImageFromServer.size());
			
			for (StockListingImagePojo partImage : updatePartImageFromServer){
				StringBuffer imgUrl = new StringBuffer(partImage.getImage());
				imgUrl.replace(0, 13, appState.getServerURL());
				
				// Delete old image and update with the updated one from server
				inventoryImageRepository.deleteByStockSerialAndImgNo(partImage.getStockListingId(), partImage.getImageId());
				List<String> encodedData = ImageUtil.encodeImage(imgUrl.toString());
				for (String imgData : encodedData){
					InventoryImages img = new InventoryImages();
					img.setData(imgData);
					img.setImageNo(partImage.getImageId());
					img.setStockSerial(partImage.getStockListingId());
					img.setWsSync(1);
					inventoryImageRepository.save(img);
					
					logger.info("Updated image "+ partImage.getImageId() + " from server for stockListing: " + partImage.getStockListingId());
				}
				
				// Save snapshot image into inventory
				String snapshotImage = ImageUtil.resizeImageForThumbNail(imgUrl.toString());
				if (partImage.getImageId() == 1){
					stockRepository.updateImage1(partImage.getStockListingId(), snapshotImage);
				}else if (partImage.getImageId() == 2){
					stockRepository.updateImage2(partImage.getStockListingId(), snapshotImage);
				}else if (partImage.getImageId() == 3){
					stockRepository.updateImage3(partImage.getStockListingId(), snapshotImage);
				}else if (partImage.getImageId() == 4){
					stockRepository.updateImage4(partImage.getStockListingId(), snapshotImage);
				}
//				inventoryRepository.save(inv);
				
			}
		}
		
		LocalDateTime currentTime = LocalDateTime.now();
		lastCheck = currentTime;
		
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
