package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.books.BooksData;
import com.library.database.service.dataaccess.borrows.BorrowsData;
import com.library.resources.model.Book;
import com.library.resources.model.Borrow;

public class BookService {
	BooksData booksData = new BooksData();
	private Map<Long, Book> books;

	public BookService() {
		books = booksData.getAllBooks();
	}

	public List<Book> getAllBooks() {
		return new ArrayList<Book>(books.values());
	}

	public Book getBook(long id) {
		Book book = books.get(id);
		return book;
	}

	public Book addBook(Book book) {
		book.setId(books.size() + 1);
		books.put(book.getId(), book);
		booksData.addBook(book);
		return book;
	}

	public Book updateBook(Book book) {
		if (book.getId() <= 0) {
			return null;
		}
		booksData.updateBook(book);
		return book;
	}

	public Book deleteBook(long bookId) {
		BorrowsData borrowsData = new BorrowsData();
		if (books.get(bookId).getIsArichwed() == false && borrowsData.checkIfBorrowed(bookId) == false) {
			booksData.deleteBook(bookId);
			return books.remove(bookId);
		} else
			return null;
	}
}
