package com.library.database.dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;

import com.library.database.connector.MySQLConnector;
import com.library.resources.model.Book;

public class BooksData {
	private Connection connection;
	private Statement statement = null;

	public Map getAllBooks() {
		ResultSet rs = null;
		Map<Long, Book> books = new HashMap<>();
		
		try {
			connection = MySQLConnector.connectMySQLDatabase();
			statement = connection.createStatement();
			statement.execute("SELECT b.books_id, b.books_title, b.books_isbn, b.books_year_published, a.authors_name, a.authors_surname, p.publishers_name FROM books AS b INNER JOIN authors AS a ON b.authors_id=a.authors_id INNER JOIN publishers AS p ON b.publishers_id=p.publishers_id;");
			rs = statement.getResultSet();
			
			Long i = 1L;
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("books_id"));; 
				book.setTitle(rs.getString("books_title"));
				book.setIsbn(rs.getInt("books_isbn"));
				book.setYearPublished(rs.getInt("books_year_published"));
				book.setAuthorName(rs.getString("authors_name"));
				book.setAuthorSurname(rs.getString("authors_surname"));
				book.setPublisher(rs.getString("publishers_name"));
				
				books.put(i, book);
				i++;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return books;
	}
}
