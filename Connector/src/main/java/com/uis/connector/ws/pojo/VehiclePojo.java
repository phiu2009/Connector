package com.uis.connector.ws.pojo;

import com.uis.connector.entity.Vehicle;

public class VehiclePojo {

	private long serial;
	private long makeId;
	private long modelId;
	private long seriesId;
	private long trimId;
	private long engineId;
	private long gearboxId;
	private long bodyId;
	private int year;
	
	public VehiclePojo(Vehicle vehicle) {
		this.serial = vehicle.getSerial();
		this.makeId = vehicle.getMakeId();
		this.modelId = vehicle.getModelId();
		this.seriesId = vehicle.getSeriesId();
		this.trimId = vehicle.getTrimId();
		this.engineId = vehicle.getEngineTypeId();
		this.gearboxId = vehicle.getGearBoxId();
		this.bodyId = vehicle.getBodyTypeId();
		this.year = vehicle.getCarYear();
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
	public long getEngineId() {
		return engineId;
	}
	public void setEngineId(long engineId) {
		this.engineId = engineId;
	}
	public long getGearboxId() {
		return gearboxId;
	}
	public void setGearboxId(long gearboxId) {
		this.gearboxId = gearboxId;
	}
	public long getBodyId() {
		return bodyId;
	}
	public void setBodyId(long bodyId) {
		this.bodyId = bodyId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public long getSerial() {
		return serial;
	}

	public void setSerial(long serial) {
		this.serial = serial;
	}
	
	
}
