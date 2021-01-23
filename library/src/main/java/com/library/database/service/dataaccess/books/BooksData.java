package com.library.database.service.dataaccess.books;


import java.util.HashMap;
import java.util.Map;

import com.library.database.service.executors.StatementExecutor;
import com.library.resources.model.Book;

public class BooksData {

	public Map<Long, Book> getAllBooks() {
		Map<Long, Book> books = new HashMap<>();

		String query = "SELECT b.books_id, b.books_title, b.books_isbn, b.books_year_published, b.books_is_archiwed, a.authors_id, a.authors_name, a.authors_surname, p.publishers_id, p.publishers_name FROM books AS b INNER JOIN authors AS a ON b.authors_id=a.authors_id INNER JOIN publishers AS p ON b.publishers_id=p.publishers_id;";
		StatementExecutor executor = new StatementExecutor(query, "query");
		books = BooksParser.parseAllBooks(executor.rs);
		executor.closeConnection();

		return books;
	}

	public void addBook(Book book) {
		String query = "INSERT INTO books(books_title, books_isbn, books_year_published, authors_id, publishers_id) VALUES('"
				+ book.getTitle() + "', " + book.getIsbn() + ", " + book.getYearPublished() + ", " + book.getAuthorId()
				+ ", " + book.getPublisherId() + ");";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void updateBook(Book book) {
		String query = "UPDATE books SET books_title='" + book.getTitle() + "', books_isbn=" + book.getIsbn()
				+ ", books_year_published=" + book.getYearPublished() + ", authors_id=" + book.getAuthorId()
				+ ", publishers_id=" + book.getPublisherId() + " WHERE books_id=" + book.getId() + ";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void deleteBook(long bookId) {
		String query = "UPDATE books SET books_is_archiwed=1 WHERE books_id=" + bookId + ";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}
}
