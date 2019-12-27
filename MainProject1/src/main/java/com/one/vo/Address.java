package com.one.vo;

public class Address {

	
	private long pincode;
	private String city;
	private String area;
	private String state;
	private LocationCordinates locationCordinates;
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocationCordinates getLocationCordinates() {
		return locationCordinates;
	}
	public void setLocationCordinates(LocationCordinates locationCordinates) {
		this.locationCordinates = locationCordinates;
	} 
	
}
