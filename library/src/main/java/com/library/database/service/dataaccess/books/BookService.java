package com.library.database.service.dataaccess.books;

import com.library.resources.model.Book;

public class BookService {

	public void addBook(Book book) {
		String query = "INSERT INTO books(books_title, books_isbn, books_year_published, authors_id, publishers_id) VALUES('"
				+ book.getTitle() + "', " + book.getIsbn() + ", " + book.getYearPublished() + ", 1, 1);";
	}
}
