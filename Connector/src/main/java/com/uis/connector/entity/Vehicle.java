package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="vehicles")
public class Vehicle {

	@Id
	private long serial;
	private long makeId;
	private long modelId;
	private long seriesId;
	private long trimId;
	private long bodyTypeId;
	private long gearBoxId;
	private long engineTypeId;
	private int carYear;
	
	
	public long getSerial() {
		return serial;
	}
	public void setSerial(long serial) {
		this.serial = serial;
	}
	public long getMakeId() {
		return makeId;
	}
	public void setMakeId(long makeId) {
		this.makeId = makeId;
	}
	public long getModelId() {
		return modelId;
	}
	public void setModelId(long modelId) {
		this.modelId = modelId;
	}
	public long getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(long seriesId) {
		this.seriesId = seriesId;
	}
	public long getTrimId() {
		return trimId;
	}
	public void setTrimId(long trimId) {
		this.trimId = trimId;
	}
	public long getBodyTypeId() {
		return bodyTypeId;
	}
	public void setBodyTypeId(long bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
	}
	public long getGearBoxId() {
		return gearBoxId;
	}
	public void setGearBoxId(long gearBoxId) {
		this.gearBoxId = gearBoxId;
	}
	public long getEngineTypeId() {
		return engineTypeId;
	}
	public void setEngineTypeId(long engineTypeId) {
		this.engineTypeId = engineTypeId;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	
	
}
