package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

import com.uis.connector.entity.Engine;

public class EnginePojo {

	private long engineId;
	private String description;
	private String abbreviation;
	
	public EnginePojo(Engine engine){
		this.engineId = engine.getSerial();
		this.description = StringEscapeUtils.escapeSql(engine.getDescription());
		this.abbreviation = StringEscapeUtils.escapeSql(engine.getAbbreviation());
	}

	public long getEngineId() {
		return engineId;
	}

	public void setEngineId(long engineId) {
		this.engineId = engineId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
	
	
}
