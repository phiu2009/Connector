package com.uis.connector.util;

public enum PartStatus {

	SOLD(1), DELETED(2), WRITTENOFF(3), RETURNED(0);
	
	private int value;
	 
	private PartStatus(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
