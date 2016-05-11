package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestGetStockImage implements WSRequestGetDetail{

	private ArrayList<StockImageCriteria> getStockListingImages = new ArrayList<StockImageCriteria>();

	public ArrayList<StockImageCriteria> getGetStockListingImages() {
		return getStockListingImages;
	}

	public void setGetStockListingImages(ArrayList<StockImageCriteria> getStockListingImages) {
		this.getStockListingImages = getStockListingImages;
	}

}
