package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestGetPushEvent implements WSRequestGetDetail{
	
	private ArrayList<SupplierCriteria> getPushEvent = new ArrayList<SupplierCriteria>();

	public ArrayList<SupplierCriteria> getGetPushEvent() {
		return getPushEvent;
	}

	public void setGetPushEvent(ArrayList<SupplierCriteria> getPushEvent) {
		this.getPushEvent = getPushEvent;
	}

}
