package com.uis.connector.ws.pojo;

import org.apache.commons.lang.StringEscapeUtils;

public class StockListingComment {
	private long stockListingId;
	private long supplierId;
	private String comments;
	
	public StockListingComment(long supplierId, long stockListingId, String comment) {
		this.supplierId = supplierId;
		this.stockListingId = stockListingId;
		this.comments = StringEscapeUtils.escapeSql(comment);
	}
	
	
	public long getStockListingId() {
		return stockListingId;
	}
	public void setStockListingId(long stockListingId) {
		this.stockListingId = stockListingId;
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
