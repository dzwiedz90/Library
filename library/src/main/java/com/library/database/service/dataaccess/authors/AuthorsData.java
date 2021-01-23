package com.library.database.service.dataaccess.authors;

import java.util.HashMap;
import java.util.Map;

import com.library.database.service.dataaccess.books.BooksParser;
import com.library.database.service.executors.StatementExecutor;
import com.library.resources.model.Book;

public class AuthorsData {

	public Map getAllAuthors() {
		Map<Long, Book> authors = new HashMap<>();

		String query = "SELECT authors_id, authors_name, authors_surname, authors_biography, authors_year_born, authors_year_died FROM authors;";
		StatementExecutor wrapper = new StatementExecutor(query, "query");
		authors = BooksParser.parseAllBooks(wrapper.rs);
		wrapper.closeConnection();

		return authors;
	}
}
