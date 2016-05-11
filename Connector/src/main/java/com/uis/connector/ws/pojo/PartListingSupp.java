package com.uis.connector.ws.pojo;

import java.time.format.DateTimeFormatter;

import com.uis.connector.entity.Inventory;

public class PartListingSupp {

	private long partListingId;
	private long supplierId;
	private String location;
	private String dateSold;
	private String inventoryDate;
	private String editDate;
	private int publishRight;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
	
	public PartListingSupp(Inventory inv, long supplierId){
		this.supplierId = supplierId;
		this.partListingId = inv.getSerial();
		this.location = inv.getLocationDetail();

		if (inv.getModifiedDateTime() == null){
			editDate = "0000-00-00 00:00:00";
		}else{
			editDate = inv.getModifiedDateTime().format(formatter);
		}
		
		dateSold = "0000-00-00 00:00:00";
		
		if (inv.getCreatedDateTime() == null){
			inventoryDate = "0000-00-00 00:00:00";
		}else{
			inventoryDate = inv.getCreatedDateTime().format(formatter);
		}
		this.publishRight = 1;
	}
	
	public long getPartListingId() {
		return partListingId;
	}
	public void setPartListingId(long partListingId) {
		this.partListingId = partListingId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDateSold() {
		return dateSold;
	}
	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
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
	public String getInventoryDate() {
		return inventoryDate;
	}
	public void setInventoryDate(String inventoryDate) {
		this.inventoryDate = inventoryDate;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
}
