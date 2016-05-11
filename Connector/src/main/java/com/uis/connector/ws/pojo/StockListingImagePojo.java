package com.uis.connector.ws.pojo;

public class StockListingImagePojo {

	private int imageId;
	private long stockListingId;
	private long supplierId;
	private String image;
	
	public StockListingImagePojo() {
	}
	
	public StockListingImagePojo(long supplierId, int imageId, long stockListingId, String image) {
		this.supplierId = supplierId;
		this.imageId = imageId;
		this.stockListingId = stockListingId;
		this.image = image;
	}
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public long getStockListingId() {
		return stockListingId;
	}

	public void setStockListingId(long stockListingId) {
		this.stockListingId = stockListingId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
}
