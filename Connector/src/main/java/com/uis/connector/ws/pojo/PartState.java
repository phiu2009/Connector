package com.uis.connector.ws.pojo;

public class PartState {
	private int partStateId;
	private String partStateType;
	
	public PartState(String partStateType){
		this.partStateType = partStateType;
	}
	
	public int getPartStateId() {
		return partStateId;
	}
	public void setPartStateId(int partStateId) {
		this.partStateId = partStateId;
	}
	public String getPartStateType() {
		return partStateType;
	}
	public void setPartStateType(String partStateType) {
		this.partStateType = partStateType;
	}
	
	
}
