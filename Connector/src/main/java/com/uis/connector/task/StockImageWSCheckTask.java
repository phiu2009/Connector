package com.uis.connector.task;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.InventoryImages;
import com.uis.connector.repository.InventoryImageRepository;
import com.uis.connector.repository.StockRepository;
import com.uis.connector.util.ImageUtil;
import com.uis.connector.ws.client.ImageWSClient;
import com.uis.connector.ws.pojo.StockListingImagePojo;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class StockImageWSCheckTask {

	@Autowired
	private ImageWSClient inventoryImageWSClient;
	@Autowired
	private InventoryImageRepository inventoryImageRepository;
	@Autowired
	private StockRepository stockRepository;
	
	private LocalDateTime lastCheck;
	private ApplicationState appState;
	private static final Log logger = LogFactory.getLog(StockImageWSCheckTask.class);

	public void checkForStockImageUpdateInWebServer(String stockListingId, String imageId){
		WSResponseGet respondObj = inventoryImageWSClient.getStockImageByStockListingId(stockListingId, imageId);
		processRepsonse(respondObj);
		
	}

	private void processRepsonse(WSResponseGet respondObj) {
		if (respondObj != null && respondObj.getGetStockListingImages()!= null 
				&& respondObj.getGetStockListingImages().getSuccess().size() > 0){
			List<StockListingImagePojo> updateStockImageFromServer = respondObj.getGetStockListingImages().getSuccess();
			logger.info("The number of updated images from server: " + updateStockImageFromServer.size());
			
			for (StockListingImagePojo stockImage : updateStockImageFromServer){
				StringBuffer imgUrl = new StringBuffer(stockImage.getImage());
				imgUrl.replace(0, 13, appState.getServerURL());
				
				// Delete old image and update with the updated one from server
				inventoryImageRepository.deleteByStockSerialAndImgNo(stockImage.getStockListingId(), stockImage.getImageId());
				List<String> encodedData = ImageUtil.encodeImage(imgUrl.toString());
				for (String imgData : encodedData){
					InventoryImages img = new InventoryImages();
					img.setData(imgData);
					img.setImageNo(stockImage.getImageId());
					img.setStockSerial(stockImage.getStockListingId());
					img.setWsSync(1);
					inventoryImageRepository.save(img);
				}
				
				// Save snapshot image into inventory
				String snapshotImage = ImageUtil.resizeImageForThumbNail(imgUrl.toString());
				if (stockImage.getImageId() == 1){
					stockRepository.updateImage1(stockImage.getStockListingId(), snapshotImage);
				}else if (stockImage.getImageId() == 2){
					stockRepository.updateImage2(stockImage.getStockListingId(), snapshotImage);
				}else if (stockImage.getImageId() == 3){
					stockRepository.updateImage3(stockImage.getStockListingId(), snapshotImage);
				}else if (stockImage.getImageId() == 4){
					stockRepository.updateImage4(stockImage.getStockListingId(), snapshotImage);
				}
				logger.info("Updated image "+ stockImage.getImageId() + " from server for stockListing: " + stockImage.getStockListingId());
			}
		}
	}
	
	public LocalDateTime getLastCheck() {
		if (lastCheck == null){
			lastCheck = appState.getLastStockImageWSSync();
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
