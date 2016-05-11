package com.uis.connector.ws.pojo;

public class WSRequestGet {
	private String supplierId;
	
	private WSRequestGetDetail gets;
	
	public WSRequestGet(WSRequestGetDetail requestDetail) {
		gets = requestDetail;
	}
	
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public WSRequestGetDetail getGets() {
		return gets;
	}

	public void setGets(WSRequestGetDetail gets) {
		this.gets = gets;
	}


	
}
