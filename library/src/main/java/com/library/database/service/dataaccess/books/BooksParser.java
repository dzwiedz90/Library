package com.library.database.service.dataaccess.books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.database.service.wrappers.StatementExecutor;
import com.library.resources.model.Book;

public class BooksParser {
	
	public static Map parseAllBooks(ResultSet rs) {
		Map<Long, Book> books = new HashMap<>();
		try {
			Long i = 1L;
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("books_id"));
				book.setTitle(rs.getString("books_title"));
				book.setIsbn(rs.getInt("books_isbn"));
				book.setYearPublished(rs.getInt("books_year_published"));
				book.setAuthorId(rs.getInt("authors_id"));
				book.setAuthorName(rs.getString("authors_name"));
				book.setAuthorSurname(rs.getString("authors_surname"));
				book.setPublisherId(rs.getInt("publishers_id"));
				book.setPublisher(rs.getString("publishers_name"));

				books.put(i, book);
				i++;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return books;
	}
}
