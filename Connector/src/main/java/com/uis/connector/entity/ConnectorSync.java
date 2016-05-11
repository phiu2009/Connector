package com.uis.connector.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="connector_sync")
public class ConnectorSync {

	@Id
	private int serial;
	private LocalDateTime lastInventorySync;
	private LocalDateTime lastStockSync;
	private LocalDateTime lastInventoryWSSync;
	private LocalDateTime lastPartImageWSSync;
	private LocalDateTime lastStockImageWSSync;
	private BigDecimal version;
	
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public LocalDateTime getLastInventorySync() {
		return lastInventorySync;
	}
	public void setLastInventorySync(LocalDateTime lastInventorySync) {
		this.lastInventorySync = lastInventorySync;
	}
	public LocalDateTime getLastStockSync() {
		return lastStockSync;
	}
	public void setLastStockSync(LocalDateTime lastVehicleSync) {
		this.lastStockSync = lastVehicleSync;
	}
	public LocalDateTime getLastInventoryWSSync() {
		return lastInventoryWSSync;
	}
	public void setLastInventoryWSSync(LocalDateTime lastInventoryWSSync) {
		this.lastInventoryWSSync = lastInventoryWSSync;
	}
	public LocalDateTime getLastPartImageWSSync() {
		return lastPartImageWSSync;
	}
	public void setLastPartImageWSSync(LocalDateTime lastPartImageWSSync) {
		this.lastPartImageWSSync = lastPartImageWSSync;
	}
	public LocalDateTime getLastStockImageWSSync() {
		return lastStockImageWSSync;
	}
	public void setLastStockImageWSSync(LocalDateTime lastStockImageWSSync) {
		this.lastStockImageWSSync = lastStockImageWSSync;
	}
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	
}
