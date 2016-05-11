package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

import com.uis.connector.entity.Model;

public class ModelPojo {

	private long modelId;
	private long makeId;
	private String displayName;
	
	public ModelPojo(Model model){
		this.modelId = model.getSerial();
		this.makeId = model.getMakeId();
		this.displayName = StringEscapeUtils.escapeSql(model.getModel());
	}
	
	public long getModelId() {
		return modelId;
	}
	public void setModelId(long modelId) {
		this.modelId = modelId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public long getMakeId() {
		return makeId;
	}

	public void setMakeId(long makeId) {
		this.makeId = makeId;
	}
	
	
}
