package com.uis.connector.ws.pojo;

import java.time.format.DateTimeFormatter;

import com.uis.connector.entity.Stock;

public class StockListingSupp {

	private long stockListingId;
	private long supplierId;
	private String bodyColor;
	private int odometer;
	private String vehicleLocation;
	private String inventoryDate;
	private String editDate;
	private int publishRight;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
	
	public StockListingSupp(Stock stock, long supplierId){
		this.supplierId = supplierId;
		this.stockListingId = stock.getSerial();
		this.vehicleLocation = stock.getLocationDetail();

		if (stock.getModifiedDateTime() == null){
			editDate = "0000-00-00 00:00:00";
		}else{
			editDate = stock.getModifiedDateTime().format(formatter);
		}
		
		inventoryDate = "0000-00-00 00:00:00";
		this.publishRight = 1;
	}
	
	public long getStockListingId() {
		return stockListingId;
	}
	public void setStockListingId(long stockListingId) {
		this.stockListingId = stockListingId;
	}
	public String getBodyColor() {
		return bodyColor;
	}
	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}
	public int getOdometer() {
		return odometer;
	}
	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}
	public String getVehicleLocation() {
		return vehicleLocation;
	}
	public void setVehicleLocation(String vehicleLocation) {
		this.vehicleLocation = vehicleLocation;
	}
	public String getInventoryDate() {
		return inventoryDate;
	}
	public void setInventoryDate(String inventoryDate) {
		this.inventoryDate = inventoryDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public int getPublishRight() {
		return publishRight;
	}
	public void setPublishRight(int publishRight) {
		this.publishRight = publishRight;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	
}
