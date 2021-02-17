package com.library.resources.model;

public class Publisher {
	private long id;
	private String name;
	private int cityId;
	private String city;
	private String postalCode;
	private int yearEstablished;
	private boolean isArchiwed; 

	public Publisher() {

	}

	public Publisher(long id, String name, int cityId, String city, String postalCode, int yearEstablished, boolean isArchiwed) {
		this.id = id;
		this.name = name;
		this.cityId = cityId;
		this.city = city;
		this.postalCode = postalCode;
		this.yearEstablished = yearEstablished;
		this.isArchiwed = isArchiwed;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCityId() {
		return this.cityId;
	}
	
	public void setCityId(int cityId) {
		this.cityId= cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(int yearEstablished) {
		this.yearEstablished = yearEstablished;
	}
	
	public void setIsArchiwed(boolean isArchiwed) {
		this.isArchiwed = isArchiwed;
	}
	
	public boolean getIsArchiwed() {
		return this.isArchiwed;
	}
}
