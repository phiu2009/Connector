package com.uis.connector.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DatabaseVersion {

	@Id
	private Integer versionId;
	private String version;
	private String versionType;
	
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersionType() {
		return versionType;
	}
	public void setVersionType(String versionType) {
		this.versionType = versionType;
	}
	
	
}
