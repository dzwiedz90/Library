package com.library.resources.model;

public class City {
	private int id;
	private String name;
	private String postalCode;

	public City() {

	}

	public City(int id, String name, String postalCode) {
		this.id = id;
		this.name = name;
		this.postalCode = postalCode;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
