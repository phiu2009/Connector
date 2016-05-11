package com.uis.connector.ws.pojo;

public class WSRequest {
	private String supplierId;
	
	private WSRequestAddDetail adds = null;
	private WSRequestUpdateDetail updates = null;
	
	private String pushEvent;
	
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public WSRequestAddDetail getAdds() {
		if (adds == null){
			adds = new WSRequestAddDetail();
		}
		return adds;
	}

	public void setAdds(WSRequestAddDetail adds) {
		this.adds = adds;
	}

	public WSRequestUpdateDetail getUpdates() {
		if (updates == null){
			updates = new WSRequestUpdateDetail();
		}
		return updates;
	}

	public void setUpdates(WSRequestUpdateDetail updates) {
		this.updates = updates;
	}

	public String getPushEvent() {
		return pushEvent;
	}

	public void setPushEvent(String pushEvent) {
		this.pushEvent = pushEvent;
	}

	
}
