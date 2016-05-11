package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="makes")
public class Make {

	@Id
	private long serial;
	private String make;
	
	public Make() {
		// TODO Auto-generated constructor stub
	}
	
	public Make(long serial, String make){
		this.serial = serial;
		this.make = make;
	}
	
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	
}
