package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Settings {
	@Id
	private int serial;
	
	private String plSupplierCode;
	private long plSupplierId;

	private String companyName;
	private String companyAddress;
	private String companySuburb;
//	private String companyState;
	private String companyPostCode;
	private String companyPhone;
	private String companyFax;
	private String companyEmail;
	private String companyABN;
	private String licenceNo;
	private String bankName;
	private String bankBSB;
	private String bankAccount;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="companyState", nullable=true)
	private State companyState ;
	
	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getPlSupplierCode() {
		return plSupplierCode;
	}

	public void setPlSupplierCode(String plSupplierCode) {
		this.plSupplierCode = plSupplierCode;
	}

	public long getPlSupplierId() {
		return plSupplierId;
	}

	public void setPlSupplierId(long plSupplierId) {
		this.plSupplierId = plSupplierId;
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

	public State getCompanyState() {
		return companyState;
	}

	public void setCompanyState(State companyState) {
		this.companyState = companyState;
	}

	public String getCompanyPostCode() {
		return companyPostCode;
	}

	public void setCompanyPostCode(String companyPostCode) {
		this.companyPostCode = companyPostCode;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
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

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
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
	
}
