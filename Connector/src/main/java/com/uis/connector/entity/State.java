package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="states")
public class State {

	@Id
	private int serial;
	private String state;
	private String stateShort;
	
	
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStateShort() {
		return stateShort;
	}
	public void setStateShort(String stateShort) {
		this.stateShort = stateShort;
	}
	
	
}
