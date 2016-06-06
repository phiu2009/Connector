package com.uis.connector.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Cacheable
public class Locations {

	@Id
	private int serial;
	
	private String location;
	private String locationDetail;
	private int deleted;
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	
}
