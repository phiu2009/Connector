package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="series")
public class Series {

	@Id
	private long serial;
	private long modelId;
	private String series;
	
	public Series() {
		// TODO Auto-generated constructor stub
	}
	
	public Series(long serial, long modelId, String series){
		this.serial = serial;
		this.modelId = modelId;
		this.series = series;
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

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
	
	
	
}
