package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

public class MakePojo {

	private long makeId;
	private String displayName;
	
	public MakePojo(com.uis.connector.entity.Make make){
		this.makeId = make.getSerial();
		this.displayName = StringEscapeUtils.escapeSql(make.getMake());
	}
	
	public long getMakeId() {
		return makeId;
	}
	public void setMakeId(long makeId) {
		this.makeId = makeId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
