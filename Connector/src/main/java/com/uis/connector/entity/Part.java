package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="parts")
public class Part {

	@Id
	private long serial;
	
	private String abbreviation;
	private String description;
	private int category;
	
	private int nswPrescribed;
	private int saPrescribed;
	
	public Part() {
		// TODO Auto-generated constructor stub
	}
	
	public Part(long serial, String description, String abbreviation, int category, int nswPrescribed, int saPrescribed) {
		this.serial = serial;
		this.description = description;
		this.abbreviation = abbreviation;
		this.category = category;
		this.nswPrescribed = nswPrescribed;
		this.saPrescribed = saPrescribed;
	}
	
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getNswPrescribed() {
		return nswPrescribed;
	}
	public void setNswPrescribed(int nswPrescribed) {
		this.nswPrescribed = nswPrescribed;
	}
	public int getSaPrescribed() {
		return saPrescribed;
	}
	public void setSaPrescribed(int saPrescribed) {
		this.saPrescribed = saPrescribed;
	}
	
	
}
