package com.uis.connector.ws.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.uis.connector.entity.DataShareSetting;
import com.uis.connector.entity.Settings;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class SupplierPojo {

	private long supplierId;
	private String supplierCode;
	private String companyName;
	private String companyAddress;
	private String companySuburb;
	private String companyState;
	private String companyPostcode;
	private String companyPhoneNo;
	private String companyFax;
	private String companyEmail;
	private String companyABN;
	private String companyLicense;
	private String bankName;
	private String bankBSB;
	private String bankAccount;
	private Integer publishRight;
	private Integer datashareEnabled;
	private Integer datashareRetail;
	private Integer datashareLimit;
	private Integer forceResync;
	
	public SupplierPojo() {
	}
	
	public SupplierPojo(Settings setting) {
		this.supplierId = setting.getPlSupplierId();
		this.supplierCode = setting.getPlSupplierCode();
		this.companyName = setting.getCompanyName();
		this.companyAddress = setting.getCompanyAddress();
		this.companySuburb = setting.getCompanySuburb();
		if (setting.getCompanyState() != null){
			this.companyState = setting.getCompanyState().getStateShort();
		}
		this.companyPostcode = setting.getCompanyPostCode();
		this.companyPhoneNo = setting.getCompanyPhone();
		this.companyFax = setting.getCompanyFax();
		this.companyEmail = setting.getCompanyEmail();
		this.companyABN = setting.getCompanyABN();
		this.companyLicense = setting.getLicenceNo();
		this.bankName = setting.getBankName();
		this.bankAccount = setting.getBankAccount();
		this.bankBSB = setting.getBankBSB();
		this.publishRight = 1;
	}
	
	public void copyFrom(DataShareSetting dataShare){
		this.datashareEnabled = dataShare.getDataShareEnabled();
		this.datashareRetail = dataShare.getRetail();
		this.datashareLimit = dataShare.getLimitToOne();
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanySuburb() {
		return companySuburb;
	}
	public void setCompanySuburb(String companySuburb) {
		this.companySuburb = companySuburb;
	}
	public String getCompanyState() {
		return companyState;
	}
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}
	public String getCompanyPostcode() {
		return companyPostcode;
	}
	public void setCompanyPostcode(String companyPostcode) {
		this.companyPostcode = companyPostcode;
	}
	public String getCompanyPhoneNo() {
		return companyPhoneNo;
	}
	public void setCompanyPhoneNo(String companyPhoneNo) {
		this.companyPhoneNo = companyPhoneNo;
	}
	public String getCompanyFax() {
		return companyFax;
	}
	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyABN() {
		return companyABN;
	}
	public void setCompanyABN(String companyABN) {
		this.companyABN = companyABN;
	}
	public String getCompanyLicense() {
		return companyLicense;
	}
	public void setCompanyLicense(String companyLicense) {
		this.companyLicense = companyLicense;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBSB() {
		return bankBSB;
	}
	public void setBankBSB(String bankBSB) {
		this.bankBSB = bankBSB;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Integer getPublishRight() {
		return publishRight;
	}
	public void setPublishRight(Integer publishRight) {
		this.publishRight = publishRight;
	}

	public Integer getDatashareEnabled() {
		return datashareEnabled;
	}

	public void setDatashareEnabled(Integer datashareEnabled) {
		this.datashareEnabled = datashareEnabled;
	}

	public Integer getDatashareRetail() {
		return datashareRetail;
	}

	public void setDatashareRetail(Integer datashareRetail) {
		this.datashareRetail = datashareRetail;
	}

	public Integer getDatashareLimit() {
		return datashareLimit;
	}

	public void setDatashareLimit(Integer datashareLimit) {
		this.datashareLimit = datashareLimit;
	}

	public Integer getForceResync() {
		return forceResync;
	}

	public void setForceResync(Integer forceResync) {
		this.forceResync = forceResync;
	}
	
	
}
