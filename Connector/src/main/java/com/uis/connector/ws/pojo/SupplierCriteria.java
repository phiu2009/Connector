package com.uis.connector.ws.pojo;

public class SupplierCriteria extends AbstractCriteria{

	private String supplierId;
	
	public void setSupplierId(String supplierId) {
		this.supplierId = formatCriteria("=", supplierId);
	}
	
	public String getSupplierId() {
		return supplierId;
	}
}
