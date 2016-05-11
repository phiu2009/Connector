package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="engines")
public class Engine {

	@Id
	private long serial;
	private String description;
	private String abbreviation;
	
	public Engine() {
		// TODO Auto-generated constructor stub
	}
	
	public Engine(long serial, String description, String abbreviation) {
		this.serial = serial;
		this.description = description;
		this.abbreviation = abbreviation;
	}
	
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
}
