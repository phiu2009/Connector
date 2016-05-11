package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="stocknumbers")
public class StockNumber {

	@Id
	private long serial;
//	private long stockSerial;
	private String stockNumber;
	
	@OneToOne
	@JoinColumn(name="stockSerial")
	private Stock stock;
	
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
//	public long getStockSerial() {
//		return stockSerial;
//	}
//	public void setStockSerial(long stockSerial) {
//		this.stockSerial = stockSerial;
//	}
	public String getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
}
