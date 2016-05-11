package com.uis.connector.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Stock {

	@Id
	private Long serial;
	private Integer status;
	
	private Long makeId;
	private Long modelId;
	private Long seriesId;
	private Long trimId;
	private Long gearboxId;
	private Long engineId;
	private Long bodyId;
	private Integer year;
	
	private String regNo;
	private String vinNo;
	private String engineNo;

	private String bodyColour;
	private Integer odometer;
	private Long location;
	
	private Integer writeOff;
	private Integer deleted;
	private Integer buyInStock;
	private LocalDateTime createdDateTime;
	private LocalDateTime modifiedDateTime;
	private Integer wsSync;
	private String notes;
	
	@OneToOne(mappedBy="stock", fetch=FetchType.EAGER)
	private StockNumber stockNo;
	
	@Transient
	private String locationDetail;
	
	protected Stock(){}
	
	public Stock(Long serial, Integer status){
		this.serial = serial;
		this.status = status;
	}
	
	public boolean isSynced(){
		return (wsSync == null || wsSync == 0) ? false : true;
	}
	
	public Long getSerial() {
		return serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getMakeId() {
		return makeId;
	}

	public void setMakeId(Long makeId) {
		this.makeId = makeId;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public Long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}

	public Long getTrimId() {
		return trimId;
	}

	public void setTrimId(Long trimId) {
		this.trimId = trimId;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Long getGearboxId() {
		return gearboxId;
	}

	public void setGearboxId(Long gearboxId) {
		this.gearboxId = gearboxId;
	}

	public Long getEngineId() {
		return engineId;
	}

	public void setEngineId(Long engineId) {
		this.engineId = engineId;
	}

	public Long getBodyId() {
		return bodyId;
	}

	public void setBodyId(Long bodyId) {
		this.bodyId = bodyId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getBodyColour() {
		return bodyColour;
	}

	public void setBodyColour(String bodyColour) {
		this.bodyColour = bodyColour;
	}

	public Integer getOdometer() {
		return odometer;
	}

	public void setOdometer(Integer odometer) {
		this.odometer = odometer;
	}

	public Long getLocation() {
		return location;
	}

	public void setLocation(Long location) {
		this.location = location;
	}

	public Integer getBuyInStock() {
		return buyInStock;
	}

	public void setBuyInStock(Integer buyInStock) {
		this.buyInStock = buyInStock;
	}

	public Integer getWriteOff() {
		return writeOff;
	}

	public void setWriteOff(Integer writeOff) {
		this.writeOff = writeOff;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public Integer getWsSync() {
		return wsSync;
	}

	public void setWsSync(Integer wsSync) {
		this.wsSync = wsSync;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getLocationDetail() {
		return locationDetail;
	}

	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public StockNumber getStockNo() {
		return stockNo;
	}

	public void setStockNo(StockNumber stockNo) {
		this.stockNo = stockNo;
	}
	
	
}
