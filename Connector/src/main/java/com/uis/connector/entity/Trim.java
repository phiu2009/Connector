package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="trim")
public class Trim {

	@Id
	private long serial;
	private long modelId;
	private String trim;
	private String abbreviation;
	
	public Trim() {
		// TODO Auto-generated constructor stub
	}
	
	public Trim(long serial, long modelId, String trim){
		this.serial = serial;
		this.modelId = modelId;
		this.trim = trim;
	}

	public long getSerial() {
		return serial;
	}

	public void setSerial(long serial) {
		this.serial = serial;
	}

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
}
