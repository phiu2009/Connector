package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="models")
public class Model {

	@Id
	private long serial;
	private long makeId;
	private String model;
	
	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	public Model(long serial, long makeId, String model){
		this.serial = serial;
		this.makeId = makeId;
		this.model = model;
	}
	
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public long getMakeId() {
		return makeId;
	}

	public void setMakeId(long makeId) {
		this.makeId = makeId;
	}
	
	
}
