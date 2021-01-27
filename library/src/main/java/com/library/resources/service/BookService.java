package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.books.BooksData;
import com.library.database.service.dataaccess.borrows.BorrowsData;
import com.library.resources.model.Book;

/**
 * Book service for handling book data between REST API and database
 */
public class BookService {
	// Object that will run queries to database
	BooksData booksData = new BooksData();
	// Map with Book objects created using data from database
	private Map<Long, Book> books;

	// Gets all books from database and saves them as Map into memory for further
	// usage
	public BookService() {
		refreshBooksData();
	}

	private void refreshBooksData() {
		books = booksData.getAllBooks();
	}

	/**
	 * Gets all books from Map
	 * 
	 * @return Returns ArrayList of all Books
	 */
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(books.values());
	}

	/**
	 * Gets all books from Map
	 * 
	 * @param id ID of a book go get
	 * @return Returns a book for a specified id
	 */
	public Book getBook(long id) {
		Book book = books.get(id);
		return book;
	}

	/**
	 * Uses booksData object to add a new book into database
	 * 
	 * @param book Book object from user used to create entry in database
	 * @return Returns a book object added to database
	 */
	public Book addBook(Book book) {
		booksData.addBook(book);
		refreshBooksData();
		return book;
	}

	/**
	 * Uses booksData object to modify existing book entry in database
	 * 
	 * @param book Book object from user used to make changes in entry in database
	 *             related to this object
	 * @return Returns a book object with changes made
	 */
	public Book updateBook(Book book) {
		if (book.getId() <= 0) {
			return null;
		}
		booksData.updateBook(book);
		refreshBooksData();
		return book;
	}

	/**
	 * Uses booksData object to archive book if it is not borrowed or already
	 * archived
	 * 
	 * @param bookId id of a book that will be archived
	 * @return Returns a book object that was archived or null if failed to meet
	 *         conditions
	 */
	public Book deleteBook(long bookId) {
		BorrowsData borrowsData = new BorrowsData();
		if (books.get(bookId).getIsArchived() == false && borrowsData.checkIfBorrowed(bookId) == false) {
			booksData.deleteBook(bookId);
			refreshBooksData();
			return books.remove(bookId);
		} else
			return null;
	}
}
