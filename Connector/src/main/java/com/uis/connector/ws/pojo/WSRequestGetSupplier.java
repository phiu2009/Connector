package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestGetSupplier implements WSRequestGetDetail{
	
//	private ArrayList<SupplierPojo> getSuppliers = new ArrayList<SupplierPojo>();
//
//	public ArrayList<SupplierPojo> getGetSuppliers() {
//		return getSuppliers;
//	}
//
//	public void setGetSuppliers(ArrayList<SupplierPojo> getSuppliers) {
//		this.getSuppliers = getSuppliers;
//	}
	
	private ArrayList<SupplierCriteria> getSuppliers = new ArrayList<SupplierCriteria>();

	public ArrayList<SupplierCriteria> getGetSuppliers() {
		return getSuppliers;
	}

	public void setGetSuppliers(ArrayList<SupplierCriteria> getSuppliers) {
		this.getSuppliers = getSuppliers;
	}
	
}
