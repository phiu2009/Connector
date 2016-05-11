package com.uis.connector.ws.pojo;

public class PartImageCriteria extends AbstractCriteria{

	private String supplierId;
	private String partListingId;
	private String imageId;
	private String modifiedDateTime;
	
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

	public String getModifiedDateTime() {
		return modifiedDateTime;
	}
	public void setModifiedDateTime(String modifiedDateTime) {
		this.modifiedDateTime = formatCriteria(">=", modifiedDateTime);
	}
	
}
