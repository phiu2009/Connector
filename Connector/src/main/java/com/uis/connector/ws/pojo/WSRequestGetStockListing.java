package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestGetStockListing implements WSRequestGetDetail{
	
	private ArrayList<StockListingCriteria> getStockListings = new ArrayList<StockListingCriteria>();

	public ArrayList<StockListingCriteria> getGetStockListings() {
		return getStockListings;
	}

	public void setGetStockListings(ArrayList<StockListingCriteria> getStockListings) {
		this.getStockListings = getStockListings;
	}

//	private ArrayList<StockListing> getStockListings = new ArrayList<StockListing>();
//
//	public ArrayList<StockListing> getGetStockListings() {
//		return getStockListings;
//	}
//
//	public void setGetStockListings(ArrayList<StockListing> getStockListings) {
//		this.getStockListings = getStockListings;
//	}
	
}
