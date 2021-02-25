package com.library.resources.model;

public class Borrow {
	private int id;
	private String dateBorrowed;
	private String returnDate;
	private String dateReturned;
	private Boolean isReturned;
	private int bookId;
	private String bookTitle;
	private int readerId;
	private String readerName;
	private String readerSurname;

	public Borrow() {

	}

	public Borrow(int id, String dateBorrowed, String returnDate, String dateReturned, Boolean isReturned, int bookId, String bookTitle,
			int readerId, String readerName, String readerSurname) {
		this.id = id;
		this.dateBorrowed = dateBorrowed;
		this.returnDate = returnDate;
		this.dateReturned = dateReturned;
		this.isReturned = isReturned;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.readerId = readerId;
		this.readerName = readerName;
		this.readerSurname = readerSurname;
	}

	public String getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(String dateReturned) {
		this.dateReturned = dateReturned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(String dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Boolean getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(Boolean isReturned) {
		this.isReturned = isReturned;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderSurname() {
		return readerSurname;
	}

	public void setReaderSurname(String readerSurname) {
		this.readerSurname = readerSurname;
	}
}
