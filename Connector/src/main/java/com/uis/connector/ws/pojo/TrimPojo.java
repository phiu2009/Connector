package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

import com.uis.connector.entity.Trim;

public class TrimPojo {

	private long trimId;
	private long modelId;
	private String trimName;
	private String trimAbbr;
	
	public TrimPojo(Trim trim){
		this.trimId = trim.getSerial();
		this.modelId = trim.getModelId();
		this.trimName = StringEscapeUtils.escapeSql(trim.getTrim());
		this.trimAbbr = StringEscapeUtils.escapeSql(trim.getAbbreviation());
	}

	public long getTrimId() {
		return trimId;
	}

	public void setTrimId(long trimId) {
		this.trimId = trimId;
	}

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public String getTrimName() {
		return trimName;
	}

	public void setTrimName(String trimName) {
		this.trimName = trimName;
	}

	public String getTrimAbbr() {
		return trimAbbr;
	}

	public void setTrimAbbr(String trimAbbr) {
		this.trimAbbr = trimAbbr;
	}

	
}
