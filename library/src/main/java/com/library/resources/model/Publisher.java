package com.library.resources.model;

public class Publisher {
	private int id;
	private String name;
	private String city;
	private String postalCode;
	private int yearEstablished;

	public Publisher() {

	}

	public Publisher(int id, String name, String city, String postalCode, int yearEstablished) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.postalCode = postalCode;
		this.yearEstablished = yearEstablished;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
