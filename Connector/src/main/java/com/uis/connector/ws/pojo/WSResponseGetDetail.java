package com.uis.connector.ws.pojo;

import java.util.List;

public class WSResponseGetDetail<T> {

	private List<T> success;
	private List<WSResponseError> errors;
	
	public List<T> getSuccess() {
		return success;
	}
	public void setSuccess(List<T> success) {
		this.success = success;
	}
	public List<WSResponseError> getErrors() {
		return errors;
	}
	public void setErrors(List<WSResponseError> errors) {
		this.errors = errors;
	}
	
	
}
