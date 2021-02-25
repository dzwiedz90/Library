package com.library.database.sample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.library.database.service.connector.MySQLConnector;

public class CreateSampleDatabaseAndTables {
	private Connection connection;
	private Statement statement = null;

	public CreateSampleDatabaseAndTables() throws SQLException {
		try {
			createDatabase();
			connection = MySQLConnector.connectMySQLDatabase();
			createCitiesTable();
			createPublishersTable();
			createAuthorsTable();
			createReadersTable();
			createBooksTable();
			createBorrowsTable();
		} catch (ClassNotFoundException e) {
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
	}

	private void createDatabase() throws SQLException {
		Connection conn = null;
		try {
			conn = MySQLConnector.connectMySQLServer();
			statement = conn.createStatement();
			statement.executeUpdate("DROP DATABASE IF EXISTS library;");
			statement = conn.createStatement();
			statement.executeUpdate("CREATE DATABASE library;");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	private void createCitiesTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE cities(cities_id INT AUTO_INCREMENT PRIMARY key, cities_name VARCHAR(40) NOT NULL, cities_postal_code VARCHAR(6) NOT NULL);");
	}

	private void createPublishersTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE publishers(publishers_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, publishers_name VARCHAR(64) NOT NULL, publishers_year_established INT(4), publishers_is_archiwed BOOLEAN NOT NULL, cities_id INT NOT NULL, FOREIGN KEY (cities_id) REFERENCES cities(cities_id));");
	}

	private void createAuthorsTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE authors(authors_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, authors_name VARCHAR(32) NOT NULL, authors_surname VARCHAR(20) NOT NULL, authors_biography TEXT NOT NULL, authors_year_born INT(4) NOT NULL, authors_year_died INT(4), authors_is_archiwed BOOLEAN NOT NULL);");
	}
	
	private void createReadersTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE readers(readers_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, readers_name VARCHAR(32) NOT NULL, readers_surname VARCHAR(20) NOT NULL, readers_date_of_birth VARCHAR(10) NOT NULL, readers_address VARCHAR(32) NOT NULL, readers_joined VARCHAR(10) NOT NULL, readers_is_archiwed BOOLEAN NOT NULL, cities_id INT NOT NULL, FOREIGN KEY (cities_id) REFERENCES cities(cities_id));");
	}

	private void createBooksTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE books(books_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, books_title VARCHAR(64) NOT NULL, books_isbn INT(13) NOT NULL, books_year_published INT(4) NOT NULL, books_is_archiwed BOOLEAN NOT NULL, authors_id INT NOT NULL, publishers_id INT NOT NULL, FOREIGN KEY (authors_id) REFERENCES authors(authors_id), FOREIGN KEY (publishers_id) REFERENCES publishers(publishers_id));");
	}
	
	private void createBorrowsTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("CREATE TABLE borrows(borrows_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, books_id INT NOT NULL, readers_id INT NOT NULL, borrows_date_borrowed VARCHAR(10) NOT NULL, borrows_return_date VARCHAR(10) NOT NULL, borrows_is_returned BOOLEAN NOT NULL, borrows_date_returned VARCHAR(10), FOREIGN KEY (books_id) REFERENCES books(books_id), FOREIGN KEY (readers_id) REFERENCES readers(readers_id));");
	}
}
