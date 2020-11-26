package com.library.resources.model;

public class Book {
	private int id;
	private String title;
	private int isbn;
	private int yearPublished;
	private String author;
	private String publisher;

	public Book() {

	}

	public Book(int id, String title, int isbn, int yearPublished, String author, String publisher) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.yearPublished = yearPublished;
		this.author = author;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
