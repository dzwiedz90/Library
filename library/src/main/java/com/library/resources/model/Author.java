package com.library.resources.model;

public class Author {
	private int id;
	private String name;
	private String surname;
	private String biography;
	private int yearBorn;
	private int yearDied;

	public Author() {

	}

	public Author(int id, String name, String surname, String biography, int yearBorn, int yearDied) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.biography = biography;
		this.yearBorn = yearBorn;
		this.yearDied = yearDied;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public int getYearDied() {
		return yearDied;
	}

	public void setYearDied(int yearDied) {
		this.yearDied = yearDied;
	}
}
