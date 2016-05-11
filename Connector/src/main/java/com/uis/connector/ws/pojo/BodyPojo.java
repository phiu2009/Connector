package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

import com.uis.connector.entity.Body;

public class BodyPojo {

	private long bodyId;
	private String description;
	private String abbreviation;
	
	public BodyPojo(Body body){
		this.bodyId = body.getSerial();
		this.description = StringEscapeUtils.escapeSql(body.getDescription());
		this.abbreviation = StringEscapeUtils.escapeSql(body.getAbbreviation());
	}

	public long getBodyId() {
		return bodyId;
	}

	public void setBodyId(long bodyId) {
		this.bodyId = bodyId;
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
