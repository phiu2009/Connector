package com.uis.connector.ws.pojo;

public class PartImageCriteria extends AbstractCriteria{

	private String supplierId;
	private String partListingId;
	private String stockListingId;
	private String imageId;
	
	public PartImageCriteria() {
	}
	
	public PartImageCriteria(long supplierId, long partListingId, long imageId) {
		setSupplierId(String.valueOf(supplierId));
		setPartListingId(String.valueOf(partListingId));
		setImageId(String.valueOf(imageId));
	}
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = formatCriteriaWithoutQuote("=", supplierId);
	}
	public String getPartListingId() {
		return partListingId;
	}
	public void setPartListingId(String partListingId) {
		this.partListingId = formatCriteriaWithoutQuote("=", partListingId);;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = formatCriteriaWithoutQuote("=", imageId);
	}

	public String getStockListingId() {
		return stockListingId;
	}

	public void setStockListingId(String stockListingId) {
		this.stockListingId = formatCriteriaWithoutQuote("=",stockListingId);
	}

	
}
