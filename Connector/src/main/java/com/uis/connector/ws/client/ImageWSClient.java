package com.uis.connector.ws.client;

import java.awt.Image;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.connector.ApplicationState;
import com.uis.connector.entity.InventoryImages;
import com.uis.connector.repository.InventoryImageRepository;
import com.uis.connector.util.ImageUtil;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.PartImageCriteria;
import com.uis.connector.ws.pojo.PartListingImagePojo;
import com.uis.connector.ws.pojo.StockImageCriteria;
import com.uis.connector.ws.pojo.StockListingImageCriteria;
import com.uis.connector.ws.pojo.StockListingImagePojo;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSRequestDelete;
import com.uis.connector.ws.pojo.WSRequestGet;
import com.uis.connector.ws.pojo.WSRequestGetPartImage;
import com.uis.connector.ws.pojo.WSRequestGetStockImage;
import com.uis.connector.ws.pojo.WSResponse;
import com.uis.connector.ws.pojo.WSResponseGet;

@Component
public class ImageWSClient extends AbstractWSClient {

	private static final Log logger = LogFactory.getLog(ImageWSClient.class);
	private final int TOTAL_IMAGES_NO = 4;
	@Autowired
	private ApplicationState appState;
	@Autowired 
	private WSRequestBuilder reqBuilder;
	@Autowired 
	private InventoryImageRepository inventoryImagesRepository;
	
	
	public void addInventoryImages(long partListingId){
		for (int i=1; i<=4; i++){
			List<InventoryImages> imageList = inventoryImagesRepository.findByInventorySerialAndImageNo(partListingId, i);
			processImages(imageList, partListingId, 0, i, true);
		}
	}
	
	public void updateInventoryImages(long partListingId){
		Set<Integer> existingImageNo = new HashSet<Integer>();
		for (int i=1; i<=4; i++){
			List<InventoryImages> imageList = inventoryImagesRepository.findByInventorySerialAndImageNo(partListingId, i);
			if (processImages(imageList, partListingId, 0, i, false)){
				existingImageNo.add(i);
			}
		}
		deleteImages(existingImageNo, partListingId, 0);
	}
	
	public void addStockImages(long stockId){
		for (int i=1; i<=4; i++){
			List<InventoryImages> imageList = inventoryImagesRepository.findByStockSerialAndImageNo(stockId, i);
			processImages(imageList, 0, stockId, i, true);
		}
	}
	
	public void updateStockImages(long stockId){
		for (int i=1; i<=4; i++){
			List<InventoryImages> imageList = inventoryImagesRepository.findByStockSerialAndImageNo(stockId, i);
			processImages(imageList, 0, stockId, i, false);
		}
	}
	
	private boolean processImages(List<InventoryImages> imageList, long partListingId, long stockListingId, int imgNo, boolean add){
		StringBuffer imageData = new StringBuffer();
		int wsSync = 0;
		long stockListing = 0;
		for (int i=0; i<imageList.size(); i++) {
			InventoryImages img = imageList.get(i);
			imageData.append(img.getData());
			wsSync = img.getWsSync();
			stockListing = img.getStockSerial();
		}
		
		if (imageData.length() > 0){
			WSRequest request = reqBuilder.initWSRequest();
//			String resizedImageData = ImageUtil.resizeImageForWeb(imageData.toString());
			if (partListingId > 0){ // build partListing image
				PartListingImagePojo partImage = new PartListingImagePojo(appState.getPLSupplierId(), imgNo, 
						partListingId, stockListing, imageData.toString());
				if (wsSync == 0){
					request.getAdds().addData(partImage);
					logger.info("Add image " + imgNo + " for partListing serial: " + partListingId);
				}else{
					request.getUpdates().addData(partImage);
					logger.info("Update image " + imgNo + " for partListing serial: " + partListingId);
				}
			}else if (stockListingId > 0){ // build stockListing image
				StockListingImagePojo stockImage = new StockListingImagePojo(appState.getPLSupplierId(), imgNo, 
						stockListingId, imageData.toString());
				if (wsSync == 0){
					request.getAdds().addData(stockImage);
					logger.info("Add image " + imgNo + " for stockListing serial: " + stockListingId);
				}else{
					request.getUpdates().addData(stockImage);
					logger.info("Update image " + imgNo + " for stockListing serial: " + stockListingId);
				}
			}
			WSResponse response = sendWSRequest(request);
			if (response != null){
				if (partListingId > 0){
					inventoryImagesRepository.updateWSSyncStatusByInvSerial(new Long(partListingId), imgNo);
				}else if (stockListingId > 0){
					inventoryImagesRepository.updateWSSyncStatusByStockSerial(new Long(stockListingId), imgNo);
				}
				return true;
			}
		}
		return false;
	}
	
	
	private void deleteImages(Set<Integer> existingImageNo, long partListingId, long stockListingId){
		
		String deletedImages = "";
		// check for deleted images
		for (int i=1; i<=TOTAL_IMAGES_NO; i++) {
			if (!existingImageNo.contains(i)){
				WSRequestDelete requestDelete = reqBuilder.initWSDeleteRequest();
				if (partListingId > 0){ // build partListing image
					PartImageCriteria partImageCriteria = new PartImageCriteria(
							appState.getPLSupplierId(), partListingId, i);
					requestDelete.getDeletes().addData(partImageCriteria);
					logger.info("Send delete request for image:" + deletedImages + " - partListing:" + partListingId);
				}else if (stockListingId > 0){
					StockListingImageCriteria stockImageCriteria = new StockListingImageCriteria(
							appState.getPLSupplierId(), stockListingId, i);
					requestDelete.getDeletes().addData(stockImageCriteria);
					logger.info("Send delete request for image:" + deletedImages + " - stockListing:" + stockListingId);
				}
				if ((requestDelete.getDeletes().getDeletePartImages() != null && requestDelete.getDeletes().getDeletePartImages().size()>0) ||
						(requestDelete.getDeletes().getDeleteStockListingImages() != null && requestDelete.getDeletes().getDeleteStockListingImages().size() > 0)){
					sendWSRequest(requestDelete);
				}
				deletedImages+=i+",";
			}
		}
		
		
	}
	/*private void processImages(List<InventoryImages> imageList, long partListingId, long stockListingId, boolean add){
		StringBuffer imageData = new StringBuffer();
		int imgNo = 1;
		int wsSync = 0;
		Set<Integer> existingImageNo = new HashSet<Integer>();
		for (int i=0; i<imageList.size(); i++) {
			InventoryImages img = imageList.get(i);
			if ((imgNo != img.getImageNo() || i == imageList.size()-1)){
				if (i == imageList.size()-1){
					imageData.append(img.getData());
					imgNo=img.getImageNo(); 
				}
				
				if (imageData.length() > 0){
					WSRequest request = reqBuilder.initWSRequest();
					if (partListingId > 0){ // build partListing image
						PartListingImagePojo partImage = new PartListingImagePojo(appState.getPLSupplierId(), imgNo, 
								partListingId, stockListingId, imageData.toString());
						if (wsSync == 0){
							request.getAdds().addData(partImage);
							logger.info("Add image " + imgNo + " for partListing serial: " + partListingId);
						}else{
							request.getUpdates().addData(partImage);
							logger.info("Update image " + imgNo + " for partListing serial: " + partListingId);
						}
					}else if (stockListingId > 0){ // build stockListing image
						StockListingImagePojo stockImage = new StockListingImagePojo(appState.getPLSupplierId(), imgNo, 
								stockListingId, imageData.toString());
						if (wsSync == 0){
							request.getAdds().addData(stockImage);
							logger.info("Add image " + imgNo + " for stockListing serial: " + stockListingId);
						}else{
							request.getUpdates().addData(stockImage);
							logger.info("Update image " + imgNo + " for stockListing serial: " + stockListingId);
						}
					}
					WSResponse response = sendWSRequest(request);
					if (response != null){
						if (partListingId > 0){
							inventoryImagesRepository.updateWSSyncStatusByInvSerial(new Long(partListingId), imgNo);
						}else if (stockListingId > 0){
							
						}
					}
					existingImageNo.add(imgNo);
					imageData = new StringBuffer();
				}
				imgNo=img.getImageNo(); 
				wsSync = img.getWsSync();
			}
			imageData.append(img.getData());
		}
		
		if (!add){
			WSRequestDelete requestDelete = reqBuilder.initWSDeleteRequest();
			String deletedImages = "";
			// check for deleted images
			for (int i=1; i<=TOTAL_IMAGES_NO; i++) {
				if (!existingImageNo.contains(i)){
					if (partListingId > 0){ // build partListing image
						PartImageCriteria partImageCriteria = new PartImageCriteria(
								appState.getPLSupplierId(), partListingId, i);
						requestDelete.getDeletes().addData(partImageCriteria);
						logger.info("Send delete request for image:" + deletedImages + " - partListing:" + partListingId);
					}else if (stockListingId > 0){
						StockListingImageCriteria stockImageCriteria = new StockListingImageCriteria(
								appState.getPLSupplierId(), stockListingId, i);
						requestDelete.getDeletes().addData(stockImageCriteria);
						logger.info("Send delete request for image:" + deletedImages + " - stockListing:" + stockListingId);
					}
					deletedImages+=i+",";
				}
			}
			
			if ((requestDelete.getDeletes().getDeletePartImages() != null && requestDelete.getDeletes().getDeletePartImages().size()>0) ||
					(requestDelete.getDeletes().getDeleteStockListingImages() != null && requestDelete.getDeletes().getDeleteStockListingImages().size() > 0)){
				sendWSRequest(requestDelete);
			}
		}
	}*/
	
	public WSResponseGet getPartImage(String lastCheckTime){
		WSRequestGetPartImage requestGetPartImage = new WSRequestGetPartImage();
		PartImageCriteria partImageCriteria = new PartImageCriteria();
		partImageCriteria.setModifiedDateTime(lastCheckTime);
		requestGetPartImage.getGetPartImages().add(partImageCriteria);
		
		WSRequestGet getPartImageRequest = reqBuilder.initWSRequestGet(requestGetPartImage);
		WSResponseGet responseObj = sendWSGetRequest(getPartImageRequest);
		return responseObj;
	}
	
	public WSResponseGet getPartImageByPartListingId(String stockLising, String partListingId, String imageId){
		WSRequestGetPartImage requestGetPartImage = new WSRequestGetPartImage();
		PartImageCriteria partImageCriteria = new PartImageCriteria();
		partImageCriteria.setSupplierId(String.valueOf(appState.getPLSupplierId()));
		partImageCriteria.setPartListingId(partListingId);
		partImageCriteria.setSupplierId(stockLising);
		partImageCriteria.setImageId(imageId);
		requestGetPartImage.getGetPartImages().add(partImageCriteria);
		
		WSRequestGet getPartImageRequest = reqBuilder.initWSRequestGet(requestGetPartImage);
		WSResponseGet responseObj = sendWSGetRequest(getPartImageRequest);
		return responseObj;
	}
	
	public WSResponseGet getStockImage(String lastCheckTime){
		WSRequestGetStockImage requestGetStockImage = new WSRequestGetStockImage();
		StockImageCriteria stockImageCriteria = new StockImageCriteria();
		stockImageCriteria.setModifiedDateTime(lastCheckTime);
		requestGetStockImage.getGetStockListingImages().add(stockImageCriteria);
		
		WSRequestGet getStockImageRequest = reqBuilder.initWSRequestGet(requestGetStockImage);
		WSResponseGet responseObj = sendWSGetRequest(getStockImageRequest);
		return responseObj;
	}
	
	public WSResponseGet getStockImageByStockListingId(String stockListingId, String imageId){
		WSRequestGetStockImage requestGetStockImage = new WSRequestGetStockImage();
		StockImageCriteria stockImageCriteria = new StockImageCriteria();
		stockImageCriteria.setSupplierId(String.valueOf(appState.getPLSupplierId()));
		stockImageCriteria.setStockListingId(stockListingId);
		stockImageCriteria.setImageId(imageId);
		requestGetStockImage.getGetStockListingImages().add(stockImageCriteria);
		
		WSRequestGet getStockImageRequest = reqBuilder.initWSRequestGet(requestGetStockImage);
		WSResponseGet responseObj = sendWSGetRequest(getStockImageRequest);
		return responseObj;
	}
}
