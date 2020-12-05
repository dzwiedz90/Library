package com.library.database.service.dataaccess.books;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;

import com.library.database.service.connector.MySQLConnector;
import com.library.database.service.wrappers.StatementExecutor;
import com.library.resources.model.Book;

public class BooksData {
	private Connection connection;
	private Statement statement = null;

	public Map getAllBooks() {
		Map<Long, Book> books = new HashMap<>();

		String query = "SELECT b.books_id, b.books_title, b.books_isbn, b.books_year_published, a.authors_id, a.authors_name, a.authors_surname, p.publishers_id, p.publishers_name FROM books AS b INNER JOIN authors AS a ON b.authors_id=a.authors_id INNER JOIN publishers AS p ON b.publishers_id=p.publishers_id;";
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
}
