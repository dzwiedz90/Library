package com.library.database.service.dataaccess.authors;

import java.util.HashMap;
import java.util.Map;

import com.library.database.service.executors.StatementExecutor;
import com.library.resources.model.Author;

public class AuthorsData {

	public Map<Long, Author> getAllAuthors() {
		Map<Long, Author> authors = new HashMap<>();

		String query = "SELECT authors_id, authors_name, authors_surname, authors_biography, authors_year_born, authors_year_died, authors_is_archiwed FROM authors;";
		StatementExecutor executor = new StatementExecutor(query, "query");
		authors = AuthorsParser.parseAllAuthors(executor.rs);
		executor.closeConnection();

		return authors;
	}

	public void addAuthor(Author author) {
		String query = "INSERT INTO authors(authors_name, authors_surname, authors_biography, authors_year_born, authors_year_died, authors_is_archiwed) VALUES('"
				+ author.getName() + "', '" + author.getSurname() + "', '" + author.getBiography() + "', "
				+ author.getYearBorn() + ", " + author.getYearDied() + ", " + author.getIsArchiwed() + ");";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void updateAuthor(Author author) {
		String query = "UPDATE authors SET authors_name='" + author.getName() + "', authors_surname='"
				+ author.getSurname() + "', authors_biography='" + author.getBiography() + "', authors_year_born="
				+ author.getYearBorn() + ", authors_year_died=" + author.getYearDied() + ", authors_is_archiwed="
				+ author.getIsArchiwed() + " WHERE authors_id=" + author.getId() + ";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void deleteAuthor(long authorId) {
		String query = "UPDATE authors SET authors_is_archiwed=1 WHERE authors_id="+authorId+"";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}
}
