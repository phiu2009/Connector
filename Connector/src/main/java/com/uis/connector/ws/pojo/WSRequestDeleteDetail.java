package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestDeleteDetail {

	private ArrayList<PartImageCriteria> deletePartImages;
	private ArrayList<StockListingImageCriteria> deleteStockListingImages;
	
	public void addData(Object data){
		switch (data.getClass().getSimpleName()){
			case "PartImageCriteria": {initDeletePartImages(); getDeletePartImages().add((PartImageCriteria)data); break;}
			case "StockListingImageCriteria": {initDeleteStockListingImages(); getDeleteStockListingImages().add((StockListingImageCriteria)data); break;}
			default: break;
		}
	}
	
	private void initDeletePartImages(){
		if (deletePartImages == null){
			deletePartImages = new ArrayList<PartImageCriteria>();
		}
	}
	private void initDeleteStockListingImages(){
		if (deleteStockListingImages == null){
			deleteStockListingImages = new ArrayList<StockListingImageCriteria>();
		}
	}
	
	public ArrayList<PartImageCriteria> getDeletePartImages() {
		return deletePartImages;
	}

	public void setDeletePartImages(ArrayList<PartImageCriteria> deletePartImages) {
		this.deletePartImages = deletePartImages;
	}

	public ArrayList<StockListingImageCriteria> getDeleteStockListingImages() {
		return deleteStockListingImages;
	}

	public void setDeleteStockListingImages(ArrayList<StockListingImageCriteria> deleteStockListingImages) {
		this.deleteStockListingImages = deleteStockListingImages;
	}
	
	
}
