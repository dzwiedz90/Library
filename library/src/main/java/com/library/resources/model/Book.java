package com.library.resources.model;

public class Book {
	private long id;
	private String title;
	private int isbn;
	private int yearPublished;
	private String authorName;
	private String authorSurname;
	private String publisher;

	public Book() {

	}

	public Book(int id, String title, int isbn, int yearPublished, String authorName, String authorSurname, String publisher) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.yearPublished = yearPublished;
		this.authorName = authorName;
		this.authorSurname = authorSurname;
		this.publisher = publisher;
	}

	public long getId() {
		return id;
	}

	public void setId(long bookId) {
		this.id = bookId;
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
