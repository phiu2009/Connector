package com.uis.connector.ws.pojo;

public class PartListingCriteria extends AbstractCriteria{

	private String supplierId;
	private String soldDelete;
	private String modifiedDateTime;
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = formatCriteria("=", supplierId);
	}
	public String getModifiedDateTime() {
		return modifiedDateTime;
	}
	public void setModifiedDateTime(String modifiedDateTime) {
		this.modifiedDateTime = formatCriteria(">=", modifiedDateTime);;
	}
	public String getSoldDelete() {
		return soldDelete;
	}
	public void setSoldDelete(String soldDelete) {
		this.soldDelete = formatCriteria("=", soldDelete);
	}
	
	
}
