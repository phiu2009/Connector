package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InventoryImages {

	@Id
	private long serial;
	
	private long stockSerial;
	private long inventorySerial;
	
	private int imageNo;
	private String data;
	private int wsSync;
	
//	private LocalDateTime modifiedDateTime;
	
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
	public long getStockSerial() {
		return stockSerial;
	}
	public void setStockSerial(long stockSerial) {
		this.stockSerial = stockSerial;
	}
	public long getInventorySerial() {
		return inventorySerial;
	}
	public void setInventorySerial(long inventorySerial) {
		this.inventorySerial = inventorySerial;
	}
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getWsSync() {
		return wsSync;
	}
	public void setWsSync(int wsSync) {
		this.wsSync = wsSync;
	}
//	public LocalDateTime getModifiedDateTime() {
//		return modifiedDateTime;
//	}
//	public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
//		this.modifiedDateTime = modifiedDateTime;
//	}
	
}
