package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="datasharesettings")
public class DataShareSetting {

	@Id
	private Integer serial;
	private Integer dataShareEnabled;
	private Integer retail;
	private Integer limitToOne;
	
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public Integer getDataShareEnabled() {
		return dataShareEnabled;
	}
	public void setDataShareEnabled(Integer dataShareEnabled) {
		this.dataShareEnabled = dataShareEnabled;
	}
	public Integer getRetail() {
		return retail;
	}
	public void setRetail(Integer retail) {
		this.retail = retail;
	}
	public Integer getLimitToOne() {
		return limitToOne;
	}
	public void setLimitToOne(Integer limitToOne) {
		this.limitToOne = limitToOne;
	}
	
	
}
