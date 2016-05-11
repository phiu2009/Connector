package com.uis.connector.ws.client;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uis.connector.ApplicationState;
import com.uis.connector.ConnectorApplication;
import com.uis.connector.entity.InventoryImages;
import com.uis.connector.repository.InventoryImageRepository;
import com.uis.connector.util.DateUtil;
import com.uis.connector.util.ImageUtil;
import com.uis.connector.util.WSRequestBuilder;
import com.uis.connector.ws.pojo.PartListingImagePojo;
import com.uis.connector.ws.pojo.StockListingImagePojo;
import com.uis.connector.ws.pojo.WSRequest;
import com.uis.connector.ws.pojo.WSResponse;
import com.uis.connector.ws.pojo.WSResponseGet;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConnectorApplication.class)
public class InventoryImageWSClientTest {

	@Autowired 
	private ImageWSClient imageWSClient;
	@Autowired
	private WSRequestBuilder reqBuilder;
	@Autowired
	private InventoryImageRepository inventoryImagesRepository;
	@Autowired
	private ApplicationState appState;
	
	@Test
	public void testGetPartImage(){
		LocalDateTime lastUpdated = LocalDateTime.of(2016, 4, 8, 11, 20, 0);
		WSResponseGet reponse = imageWSClient.getPartImage(lastUpdated.format(DateUtil.formatter));
		Assert.assertNotNull(reponse);
		
		List<PartListingImagePojo> imageList = reponse.getGetPartImages().getSuccess();
		for (PartListingImagePojo img : imageList){
			StringBuffer imgUrl = new StringBuffer(img.getImage());
			imgUrl.replace(0, 13, appState.getServerURL());
			ImageUtil.getImageFromURL(imgUrl.toString());
		}
	}
	
	@Test
	public void testAddPartImage(){
		List<InventoryImages> imageList = inventoryImagesRepository.findByInventorySerialAndImageNo(900, 3);
		StringBuffer imageData = new StringBuffer();
		for (int i=0; i<imageList.size(); i++) {
			InventoryImages img = imageList.get(i);
			imageData.append(img.getData());
		}
		
		WSRequest request = reqBuilder.initWSRequest();
		request.setPushEvent("true");
		PartListingImagePojo partImage = new PartListingImagePojo(105628, 2, 900, 28, imageData.toString());
//		request.getAdds().addData(partImage);
		request.getUpdates().addData(partImage);
		WSResponse response = imageWSClient.sendWSRequest(request);
		Assert.assertNotNull(response);
		
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddStockImage(){
		List<InventoryImages> imageList = inventoryImagesRepository.findByStockSerialAndImageNo(138, 3);
		StringBuffer imageData = new StringBuffer();
		for (int i=0; i<imageList.size(); i++) {
			InventoryImages img = imageList.get(i);
			imageData.append(img.getData());
		}
		
		WSRequest request = reqBuilder.initWSRequest();
		request.setPushEvent("true");
		StockListingImagePojo stockImage = new StockListingImagePojo(105628, 4, 138, imageData.toString());
//		request.getAdds().addData(partImage);
		request.getUpdates().addData(stockImage);
		imageWSClient.sendWSRequest(request);
		
		
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
