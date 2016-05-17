package com.uis.connector.ws.pojo;

import com.uis.connector.entity.Stock;

public class StockListing {

	private long stockListingId;
	private int deleteSold;
	private long supplierId;
//	private long UISStockId;
	private long vehicleId;
	
	private String regoNo;
	private String engineNo;
	private String vinNo;
	
	private long makeId;
	private long modelId;
	private long seriesId;
	private long trimId;
	
	private long bodyId;
	private long engineId;
	private long gearboxId;
	private int year;
	private String stockNo;
	
	private int writeOff;
	
	private String status;
	
	private Integer wheredeleteSold;
	
	public StockListing() {
		// TODO Auto-generated constructor stub
	}

	public StockListing(Stock stock) {
		this.stockListingId = stock.getSerial();
		this.deleteSold = stock.getDeleted();
		this.supplierId = 0;
		
		this.engineNo = stock.getEngineNo();
		this.vinNo = stock.getVinNo();
		this.regoNo = stock.getRegNo();
		
		this.makeId = stock.getMakeId();
		this.modelId = stock.getModelId();
		this.seriesId = stock.getSeriesId();
		this.trimId = stock.getTrimId();
		
		this.engineId = stock.getEngineId();
		this.gearboxId = stock.getGearboxId();
		this.bodyId = stock.getBodyId();
		this.year = stock.getYear();
		
		this.writeOff = stock.getWriteOff();
		if(stock.getStockNo() != null){
			this.stockNo = stock.getStockNo().getStockNumber();
		}
		
		switch(stock.getStatus()){
			case 0: {this.status = "New"; break;}
			case 1: {this.status = "Data Entered"; break;}
			case 2: {this.status = "Profile Selected"; break;}
			case 3: {this.status = "Inspection Sheet Printed"; break;}
			case 4: {this.status = "Dismantling Sheet Printed"; break;}
			case 5: {this.status = "Parts Inventoried"; break;}
			case 6: {this.status = "Written Off"; break;}
			default: break;
		}
	}
	
	public long getStockListingId() {
		return stockListingId;
	}

	public void setStockListingId(long stockListingId) {
		this.stockListingId = stockListingId;
	}

	public int getDeleteSold() {
		return deleteSold;
	}

	public void setDeleteSold(int deleteSold) {
		this.deleteSold = deleteSold;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

//	public long getUisStockId() {
//		return UISStockId;
//	}
//
//	public void setUisStockId(long uISStockId) {
//		UISStockId = uISStockId;
//	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getRegoNo() {
		return regoNo;
	}

	public void setRegoNo(String regoNo) {
		this.regoNo = regoNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
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

	public long getBodyId() {
		return bodyId;
	}

	public void setBodyId(long bodyId) {
		this.bodyId = bodyId;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStockNo() {
		return stockNo;
	}

	public int getWriteOff() {
		return writeOff;
	}

	public void setWriteOff(int writeOff) {
		this.writeOff = writeOff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getWheredeleteSold() {
		return wheredeleteSold;
	}

	public void setWheredeleteSold(Integer wheredeleteSold) {
		this.wheredeleteSold = wheredeleteSold;
	}

	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}

}