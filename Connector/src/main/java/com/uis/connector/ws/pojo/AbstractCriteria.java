package com.uis.connector.ws.pojo;

public abstract class AbstractCriteria {

	protected String formatCriteria(String operator, String value){
		return operator + "'"  + value + "'";
	}
	
	protected String formatCriteriaWithoutQuote(String operator, String value){
		return operator + value;
	}
}
