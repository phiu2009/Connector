package com.uis.connector.ws.pojo;

import java.util.ArrayList;

public class WSRequestGetPartImage implements WSRequestGetDetail{

	private ArrayList<PartImageCriteria> getPartImages = new ArrayList<PartImageCriteria>();

	public ArrayList<PartImageCriteria> getGetPartImages() {
		return getPartImages;
	}

	public void setGetPartImages(ArrayList<PartImageCriteria> getPartImages) {
		this.getPartImages = getPartImages;
	}




}
