package com.one.vo;

public class Response {
	int statusCode;
	long empId;
	String statusMessage;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public long getEmpid() {
		return empId;
	}
	public void setEmpid(long empId) {
		this.empId = empId;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String ststusMessage) {
		this.statusMessage = ststusMessage;
	}

}
