package com.uis.connector.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Inventory {

	@Id
	private long serial;
	
	private long stockSerial;
	private int partSerial;
	
	private int deleted;
	private int sold;
	private int returned;
	private int writeOff;
	
	private String genuinePartNo;
	
	private Integer status;
	private String condition;
	private Integer state;
	private Integer location;
	private String tagNo;
	
	private BigDecimal retailPrice;
	
	private String comment;
	
	private String nonGenuinePartNo1;
	private String nonGenuinePartNo2;
	private String nonGenuinePartNo3;
	private String nonGenuinePartNo4;
	
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	
	private LocalDateTime createdDateTime;
	private LocalDateTime modifiedDateTime;
	
	private Integer wsSync;
//	private Integer onEbay;
	
	@Transient
	private String locationDetail;
	
	public boolean isSynced(){
		return (wsSync == null || wsSync == 0) ? false : true;
	}
	
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
	public int getPartSerial() {
		return partSerial;
	}
	public void setPartSerial(int partSerial) {
		this.partSerial = partSerial;
	}
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public LocalDateTime getModifiedDateTime() {
		return modifiedDateTime;
	}
	public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int delete) {
		this.deleted = delete;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
	public int getWriteOff() {
		return writeOff;
	}
	public void setWriteOff(int writeOff) {
		this.writeOff = writeOff;
	}
	public String getGenuinePartNo() {
		return genuinePartNo;
	}
	public void setGenuinePartNo(String genuinePartNo) {
		this.genuinePartNo = genuinePartNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public Integer getWsSync() {
		return wsSync;
	}
	public void setWsSync(int wsSync) {
		this.wsSync = wsSync;
	}

	public String getLocationDetail() {
		return locationDetail;
	}

	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getNonGenuinePartNo1() {
		return nonGenuinePartNo1;
	}

	public void setNonGenuinePartNo1(String nonGenuinePartNo1) {
		this.nonGenuinePartNo1 = nonGenuinePartNo1;
	}

	public String getNonGenuinePartNo2() {
		return nonGenuinePartNo2;
	}

	public void setNonGenuinePartNo2(String nonGenuinePartNo2) {
		this.nonGenuinePartNo2 = nonGenuinePartNo2;
	}

	public String getNonGenuinePartNo3() {
		return nonGenuinePartNo3;
	}

	public void setNonGenuinePartNo3(String nonGenuinePartNo3) {
		this.nonGenuinePartNo3 = nonGenuinePartNo3;
	}

	public String getNonGenuinePartNo4() {
		return nonGenuinePartNo4;
	}

	public void setNonGenuinePartNo4(String nonGenuinePartNo4) {
		this.nonGenuinePartNo4 = nonGenuinePartNo4;
	}

	public String getTagNo() {
		return tagNo;
	}

	public void setTagNo(String tagNo) {
		this.tagNo = tagNo;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

//	public Integer getOnEbay() {
//		return onEbay;
//	}
//
//	public void setOnEbay(Integer onEbay) {
//		this.onEbay = onEbay;
//	}

	
}
