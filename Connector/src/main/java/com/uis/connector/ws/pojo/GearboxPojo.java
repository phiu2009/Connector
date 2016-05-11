package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

import com.uis.connector.entity.Gearbox;

public class GearboxPojo {

	private long gearboxId;
	private String description;
	private String abbreviation;
	
	public GearboxPojo(Gearbox body){
		this.gearboxId = body.getSerial();
		this.description = StringEscapeUtils.escapeSql(body.getDescription());
		this.abbreviation = StringEscapeUtils.escapeSql(body.getAbbreviation());
	}

	public long getGearboxId() {
		return gearboxId;
	}

	public void setGearboxId(long gearboxId) {
		this.gearboxId = gearboxId;
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
