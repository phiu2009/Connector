package com.uis.connector.ws.pojo;

import java.math.BigDecimal;

import com.uis.connector.entity.Inventory;
import com.uis.connector.util.DateUtil;
import com.uis.connector.util.PartStatus;

public class PartListing {
	
	private Long partListingId;
	private Integer soldDelete;
	private Long supplierId ;
	private Integer partId ;
	
	private String genuinePartNumber;
  	private String aftermarketPartNo1;
  	private String aftermarketPartNo2;
  	private String aftermarketPartNo3;
  	private String aftermarketPartNo4;
  	
  	private BigDecimal retailPrice;
  	
  	private Integer partConditionId ;
  	private String partCondition ;
  	private Integer partStateId ;
  	private Long stockListingId ;
  	private String tagNo;
  	private int writeOff;
  	private String partStatus;
  	private String modifiedDateTime;
  	
  	private Integer wheresoldDelete;
  	
  	public PartListing(){
  	}
  	
  	public PartListing(Inventory inv){
  		this.partListingId = inv.getSerial();
  		this.partId = inv.getPartSerial();
  		this.retailPrice = inv.getRetailPrice();
  		this.stockListingId = inv.getStockSerial();
  		this.partStateId = inv.getState();
  		
  		if (inv.getDeleted() == 1){
  			this.soldDelete = PartStatus.DELETED.getValue();
  		}else if (inv.getSold() == 1){
  			this.soldDelete = PartStatus.SOLD.getValue();
  		}
  		else{
  			this.soldDelete = 0;
  		}
  		this.writeOff = inv.getWriteOff();
  		
  		switch (inv.getCondition()){
  			case "A" : this.partConditionId = 1; break;
  			case "B" : this.partConditionId = 2; break;
  			case "C" : this.partConditionId = 3; break;
  			default : break;
  		}
  		this.partCondition = inv.getCondition();
  		
  		this.genuinePartNumber = inv.getGenuinePartNo();
  		this.aftermarketPartNo1 = inv.getNonGenuinePartNo1();
  		this.aftermarketPartNo2 = inv.getNonGenuinePartNo2();
  		this.aftermarketPartNo3 = inv.getNonGenuinePartNo3();
  		this.aftermarketPartNo4 = inv.getNonGenuinePartNo4();
  		
  		this.tagNo = inv.getTagNo();
  		
  		if (inv.getStatus() != null){
  			switch (inv.getStatus()){
  			case 0 : this.partStatus = "On Vehicle"; break;
  			case 1 : this.partStatus = "In Stock"; break;
  			default : break;
  		}
  		}
  		if (inv.getModifiedDateTime() != null){
  			this.modifiedDateTime = inv.getModifiedDateTime().format(DateUtil.formatter);
  		}else{
  			this.modifiedDateTime = "0000-00-00 00:00:00";
  		}
  	}
  	
	public Long getPartListingId() {
		return partListingId;
	}
	public void setPartListingId(Long partListingId) {
		this.partListingId = partListingId;
	}
	public Integer getSoldDelete() {
		return soldDelete;
	}
	public void setSoldDelete(Integer soldDelete) {
		this.soldDelete = soldDelete;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	public Integer getPartConditionId() {
		return partConditionId;
	}
	public void setPartConditionId(Integer partConditionId) {
		this.partConditionId = partConditionId;
	}
	public Integer getPartStateId() {
		return partStateId;
	}
	public void setPartStateId(Integer partStateId) {
		this.partStateId = partStateId;
	}
	public Long getStockListingId() {
		return stockListingId;
	}
	public void setStockListingId(Long stockListingId) {
		this.stockListingId = stockListingId;
	}

	public String getGenuinePartNumber() {
		return genuinePartNumber;
	}

	public void setGenuinePartNumber(String genuinePartNumber) {
		this.genuinePartNumber = genuinePartNumber;
	}

	public String getAftermarketPartNo1() {
		return aftermarketPartNo1;
	}

	public void setAftermarketPartNo1(String aftermarketPartNo1) {
		this.aftermarketPartNo1 = aftermarketPartNo1;
	}

	public String getAftermarketPartNo2() {
		return aftermarketPartNo2;
	}

	public void setAftermarketPartNo2(String aftermarketPartNo2) {
		this.aftermarketPartNo2 = aftermarketPartNo2;
	}

	public String getAftermarketPartNo3() {
		return aftermarketPartNo3;
	}

	public void setAftermarketPartNo3(String aftermarketPartNo3) {
		this.aftermarketPartNo3 = aftermarketPartNo3;
	}

	public String getAftermarketPartNo4() {
		return aftermarketPartNo4;
	}

	public void setAftermarketPartNo4(String aftermarketPartNo4) {
		this.aftermarketPartNo4 = aftermarketPartNo4;
	}

	public String getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(String modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public String getTagNo() {
		return tagNo;
	}

	public void setTagNo(String tagNo) {
		this.tagNo = tagNo;
	}

	public int getWriteOff() {
		return writeOff;
	}

	public void setWriteOff(int writeOff) {
		this.writeOff = writeOff;
	}

	public Integer getWheresoldDelete() {
		return wheresoldDelete;
	}

	public void setWheresoldDelete(Integer wheresoldDelete) {
		this.wheresoldDelete = wheresoldDelete;
	}

	public String getPartCondition() {
		return partCondition;
	}

	public void setPartCondition(String partCondition) {
		this.partCondition = partCondition;
	}

	public String getPartStatus() {
		return partStatus;
	}

	public void setPartStatus(String partStatus) {
		this.partStatus = partStatus;
	}

  	
}
