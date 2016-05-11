package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

public class PartListingComment {
	private long partListingId;
	private long supplierId;
	private String comments;
	
	public PartListingComment(long supplierId, long partListingId, String comment) {
		this.supplierId = supplierId;
		this.partListingId = partListingId;
		this.comments = StringEscapeUtils.escapeSql(comment);
	}
	
	public long getPartListingId() {
		return partListingId;
	}
	public void setPartListingId(long partListingId) {
		this.partListingId = partListingId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
}
