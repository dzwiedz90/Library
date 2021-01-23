package com.library.resources.model;

public class City {
	private long cityId;
	private String name;
	private String postalCode;

	public City() {

	}

	public City(long id, String name, String postalCode) {
		this.cityId = id;
		this.name = name;
		this.postalCode = postalCode;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long id) {
		this.cityId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
