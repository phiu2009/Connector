package com.uis.connector.ws.pojo;

public class WSRequestDelete {

	private String supplierId;
	private WSRequestDeleteDetail deletes = new WSRequestDeleteDetail();
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public WSRequestDeleteDetail getDeletes() {
		return deletes;
	}
	public void setDeletes(WSRequestDeleteDetail deletes) {
		this.deletes = deletes;
	}
	
	
}
