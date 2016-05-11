package com.uis.connector.ws.pojo;

public class StockListingImageCriteria extends AbstractCriteria{

	private String supplierId;
	private String stockListingId;
	private String imageId;
	
	public StockListingImageCriteria() {
	}
	
	public StockListingImageCriteria(long supplierId, long stockListingId, long imageId) {
		setSupplierId(String.valueOf(supplierId));
		setStockListingId(String.valueOf(stockListingId));
		setImageId(String.valueOf(imageId));
	}
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = formatCriteriaWithoutQuote("=", supplierId);
	}
	public String getStockListingId() {
		return stockListingId;
	}
	public void setStockListingId(String stockListingId) {
		this.stockListingId = formatCriteriaWithoutQuote("=",stockListingId);
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = formatCriteriaWithoutQuote("=", imageId);
	}

}
