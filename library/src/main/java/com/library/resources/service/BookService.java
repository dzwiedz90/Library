package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.books.BooksData;
import com.library.resources.model.Book;

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
//		message.setId(messages.size() + 1);
//		messages.put(message.getId(), message);
//		database action
		return book;
	}
	
	public Book updateBook(Book book) {
//		if (message.getId() <= 0) {
//			return null;
//		}
//		messages.put(message.getId(), message);
//		database action
		return book;
	}
	
	public Book deleteBook(long id) {
//		database action
		return books.remove(id);
	}
}
