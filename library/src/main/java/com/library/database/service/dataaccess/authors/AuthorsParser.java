package com.library.database.service.dataaccess.authors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.resources.model.Author;

public class AuthorsParser {
	
	public static Map<Long, Author> parseAllAuthors(ResultSet rs) {
		Map<Long, Author> authors = new HashMap<>();
		try {
			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt("authors_id"));
				author.setName(rs.getString("authors_name"));
				author.setSurname(rs.getString("authors_surname"));
				author.setBiography(rs.getString("authors_biography"));
				author.setYearBorn(rs.getInt("authors_year_born"));
				author.setYearDied(rs.getInt("authors_year_died"));
				author.setIsArchiwed(rs.getBoolean("authors_is_archiwed"));
			
				authors.put(author.getId(), author);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return authors;
	}
}
