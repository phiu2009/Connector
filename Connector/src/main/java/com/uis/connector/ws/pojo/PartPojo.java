package com.uis.connector.ws.pojo;

import com.uis.connector.entity.Part;

public class PartPojo {

	private long partId;
	private String description;
	private String abbreviation;
	private long categoryId;
	private int nswPrescribed;
	private int saPrescribed;
	
	public PartPojo(Part part) {
		this.partId = part.getSerial();
		this.description = part.getDescription();
		this.abbreviation = part.getAbbreviation();
		this.categoryId = part.getCategory();
		this.nswPrescribed = part.getNswPrescribed();
		this.saPrescribed = part.getSaPrescribed();
	}
	
	
	public long getPartId() {
		return partId;
	}
	public void setPartId(long partId) {
		this.partId = partId;
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
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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
