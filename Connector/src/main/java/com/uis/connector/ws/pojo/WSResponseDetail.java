package com.uis.connector.ws.pojo;

import java.util.List;

public class WSResponseDetail {

	private int success;
	private List<WSResponseError> errors;
	
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public List<WSResponseError> getErrors() {
		return errors;
	}
	public void setErrors(List<WSResponseError> errors) {
		this.errors = errors;
	}
}
