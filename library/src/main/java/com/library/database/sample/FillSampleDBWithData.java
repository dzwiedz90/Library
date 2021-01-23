package com.library.database.sample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.library.database.service.connector.MySQLConnector;

public class FillSampleDBWithData {
	private Connection connection;
	private Statement statement = null;
	
	public FillSampleDBWithData() throws SQLException {
		try {
			connection = MySQLConnector.connectMySQLDatabase();
			fillCitiesTable();
			fillPublishersTable();
			fillAuthorsTable();
			fillReadersTable();
			fillBooksTable();
			fillBorrowsTable();
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
	
	private void fillCitiesTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO cities(cities_name, cities_postal_code) VALUES('Gorzow Wielkopolski', '66-400');");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO cities(cities_name, cities_postal_code) VALUES('Poznan', '61-435');");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO cities(cities_name, cities_postal_code) VALUES('Warszawa', '00-014');");
	}

	private void fillPublishersTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO publishers(publishers_name, publishers_year_established, publishers_is_archiwed, cities_id) VALUES('Wydawnictwo Znak', 1959, 0, 3);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO publishers(publishers_name, publishers_year_established, publishers_is_archiwed, cities_id) VALUES('Wydawnictwo Zysk i Ska', 1987, 0, 2);");
	}

	private void fillAuthorsTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO authors(authors_name, authors_surname, authors_biography, authors_year_born, authors_year_died, authors_is_archiwed) VALUES('John Ronald Reuel', 'Tolkien', 'Brytyjski pisarz oraz profesor filologii klasycznej i literatury staroangielskiej na University of Oxford. Jako autor powiesci Wladca Pierscieni, ktorej akcja rozgrywa sie w mitycznym swiecie Srodziemia, spopularyzowal literature fantasy. Jest autorem wielu dziel rozgrywajacych sie w Srodziemiu, powiesci Hobbit, czyli tam i z powrotem, Wladca Pierscieni, Silmarillion oraz kilku krotkich form, opowiadan niezwiazanych lub luzno zwiazanych z wielka mitologia, tzw. Legendarium Srodziemia (zawartej w 12-tomowej History of the Middle-earth, opracowanej i wydanej przez Christophera Tolkiena).', 1892, 1973, 0);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO authors(authors_name, authors_surname, authors_biography, authors_year_born, authors_year_died, authors_is_archiwed) VALUES('Thomas Stearns', 'Eliot', 'Amerykansko-brytyjski poeta, przedstawiciel modernizmu, dramaturg i eseista, od 1914 mieszkal w Anglii; laureat Nagrody Nobla w dziedzinie literatury (1948)', 1888, 1965, 0);");
	}
	
	private void fillReadersTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO readers(readers_name, readers_surname, readers_date_of_birth, readers_address, readers_joined, readers_is_archiwed, cities_id) VALUES('Andrzej', 'Duppa', '22.10.1987', 'Jaworowa 32/1', '22.11.2012', 0, 2);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO readers(readers_name, readers_surname, readers_date_of_birth, readers_address, readers_joined, readers_is_archiwed, cities_id) VALUES('Stefan', 'Jaroselsky', '06.06.1986', 'Aleje Jerozolimskie 12', '08.09.2019', 0, 3);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO readers(readers_name, readers_surname, readers_date_of_birth, readers_address, readers_joined, readers_is_archiwed, cities_id) VALUES('Miroslaw', 'Szymczak', '12.05.1997', 'Grunwaldzka 12/41', '25.06.2018', 0, 2);");
	}

	private void fillBooksTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO books(books_title, books_isbn, books_year_published, books_is_archiwed, authors_id, publishers_id) VALUES('Wladca Pierscieni - Druzyna Pierscienia', 1234, 1984, 0, 1, 1);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO books(books_title, books_isbn, books_year_published, books_is_archiwed, authors_id, publishers_id) VALUES('Wladca Pierscieni - Dwie Wieze', 1234, 1985, 0, 1, 1);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO books(books_title, books_isbn, books_year_published, books_is_archiwed, authors_id, publishers_id) VALUES('Wladca Pierscieni - Powrot Krola', 1234, 1986, 0, 1, 1);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO books(books_title, books_isbn, books_year_published, books_is_archiwed, authors_id, publishers_id) VALUES('Hobbit', 1234, 1980, 0, 1, 1);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO books(books_title, books_isbn, books_year_published, books_is_archiwed, authors_id, publishers_id) VALUES('Ziemia jalowa', 1234, 1922, 0, 2, 2);");
	}
	
	private void fillBorrowsTable() throws SQLException {
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO borrows(books_id, readers_id, borrows_date_borrowed, borrows_return_date, borrows_is_returned) VALUES(1, 1, '09.11.2020', '22.11.2020', 1);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO borrows(books_id, readers_id, borrows_date_borrowed, borrows_return_date, borrows_is_returned) VALUES(1, 2, '23.11.2020', '06.12.2020', 0);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO borrows(books_id, readers_id, borrows_date_borrowed, borrows_return_date, borrows_is_returned) VALUES(2, 3, '09.11.2020', '22.11.2020', 0);");
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO borrows(books_id, readers_id, borrows_date_borrowed, borrows_return_date, borrows_is_returned) VALUES(3, 3, '09.11.2020', '22.11.2020', 1);");
	}
}
