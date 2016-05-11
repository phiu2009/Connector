package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestGetPartListing implements WSRequestGetDetail{
	
	private ArrayList<PartListingCriteria> getPartListings = new ArrayList<PartListingCriteria>();

	public ArrayList<PartListingCriteria> getGetPartListings() {
		return getPartListings;
	}

	public void setGetPartListings(ArrayList<PartListingCriteria> getPartListings) {
		this.getPartListings = getPartListings;
	}

//	private ArrayList<PartListing> getPartListings = new ArrayList<PartListing>();
//
//	public ArrayList<PartListing> getGetPartListings() {
//		return getPartListings;
//	}
//
//	public void setGetPartListings(ArrayList<PartListing> getPartListings) {
//		this.getPartListings = getPartListings;
//	}
	
}
