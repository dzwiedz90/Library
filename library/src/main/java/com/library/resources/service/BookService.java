package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.dataaccess.BooksData;
import com.library.resources.model.Book;

public class BookService {
	BooksData booksData = new BooksData();
	private Map<Long, Book> books;

	@SuppressWarnings("unchecked")
	public BookService() {
		books = booksData.getAllBooks();
	}

	public List<Book> getAllBooks() {
		return new ArrayList<Book>(books.values());
	}
}
