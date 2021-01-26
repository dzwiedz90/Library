package com.library.resources.model;

public class Reader {

	private long id;
	private String name;
	private String surname;
	private String dateOfBirth;
	private String address;
	private String joinedLibrary;
	private boolean isArchived;
	private long cityId;
	private String city;
	private String postalCode;

	public Reader() {

	}

	public Reader(long id, String name, String surname, String dateOfBirth, String address, String joinedLibrary, boolean isArchived, long cityId, String city, String postalCode) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.joinedLibrary = joinedLibrary;
		this.isArchived = isArchived;
		this.cityId = cityId;
		this.city = city;
		this.postalCode = postalCode;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public boolean getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(boolean isArchived) {
		this.isArchived = isArchived;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoinedLibrary() {
		return joinedLibrary;
	}

	public void setJoinedLibrary(String joinedLibrary) {
		this.joinedLibrary = joinedLibrary;
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
}
