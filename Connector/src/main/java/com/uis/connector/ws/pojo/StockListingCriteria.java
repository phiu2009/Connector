package com.uis.connector.ws.pojo;

public class StockListingCriteria extends AbstractCriteria{

	private String supplierId;
	private String soldDelete;
	private String modifiedDateTime;
	private Integer pageSize;
	private Integer pageNo;
	
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
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
