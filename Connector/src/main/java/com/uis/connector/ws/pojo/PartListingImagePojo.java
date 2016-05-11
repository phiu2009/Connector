package com.uis.connector.ws.pojo;

public class PartListingImagePojo {

	private int imageId;
	private long partListingId;
	private String image;
	private long supplierId;
	private long stockListingId;
	
	public PartListingImagePojo() {
	}
	
	public PartListingImagePojo(long supplierId, int imageId, long partListingId, long stockListingId, String image) {
		this.supplierId = supplierId;
		this.imageId = imageId;
		this.partListingId = partListingId;
		this.image = image;
		this.stockListingId = stockListingId;
	}
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public long getPartListingId() {
		return partListingId;
	}
	public void setPartListingId(long partListingId) {
		this.partListingId = partListingId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public long getStockListingId() {
		return stockListingId;
	}

	public void setStockListingId(long stockListingId) {
		this.stockListingId = stockListingId;
	}
	
	
}
