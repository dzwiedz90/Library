package com.library.resources.model;

public class Book {
	private long id;
	private String title;
	private int isbn;
	private int yearPublished;
	private int authorId;
	private String authorName;
	private String authorSurname;
	private boolean isArichwed;
	private int publisherId;
	private String publisher;

	public Book() {

	}

	public Book(int id, String title, int isbn, int yearPublished, int authorId, String authorName,
			String authorSurname, boolean isArchiwed, int publisherId, String publisher) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.yearPublished = yearPublished;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorSurname = authorSurname;
		this.isArichwed = isArchiwed;
		this.publisherId = publisherId;
		this.publisher = publisher;
	}

	public boolean getIsArichwed() {
		return isArichwed;
	}

	public void setIsArichwed(boolean isArichwed) {
		this.isArichwed = isArichwed;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
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
