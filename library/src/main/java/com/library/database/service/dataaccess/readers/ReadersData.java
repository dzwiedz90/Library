package com.library.database.service.dataaccess.readers;

import java.util.HashMap;
import java.util.Map;

import com.library.database.service.executors.StatementExecutor;
import com.library.resources.model.Reader;

public class ReadersData {

	public Map<Long, Reader> getAllReaders() {
		Map<Long, Reader> readers = new HashMap<>();

		String query = "SELECT r.readers_id, r.readers_name, r.readers_surname, r.readers_date_of_birth, r.readers_address, r.readers_joined, r.readers_is_archiwed, c.cities_id, c.cities_name, c.cities_postal_code FROM readers AS r INNER JOIN cities AS c ON r.cities_id=c.cities_id;";
		StatementExecutor executor = new StatementExecutor(query, "query");
		readers = ReadersParser.parseAllReaders(executor.rs);
		executor.closeConnection();

		return readers;
	}

	public void addReader(Reader reader) {
		String query = "INSERT INTO readers(readers_name, readers_surname, readers_date_of_birth, readers_address, readers_joined, readers_is_archiwed, cities_id) VALUES('"
				+ reader.getName() + "', '" + reader.getSurname() + "', '" + reader.getDateOfBirth() + "', '"
				+ reader.getAddress() + "', '" + reader.getJoinedLibrary() + "', " + reader.getIsArchived() + ", "
				+ reader.getCityId() + ");";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void updateReader(Reader reader) {
		String query = "UPDATE readers SET readers_name='" + reader.getName() + "', readers_surname='"
				+ reader.getSurname() + "', readers_date_of_birth='" + reader.getDateOfBirth() + "', readers_address='"
				+ reader.getAddress() + "', readers_joined='" + reader.getJoinedLibrary() + "', readers_is_archiwed="
				+ reader.getIsArchived() + ", cities_id=" + reader.getCityId() + " WHERE readers_id=" + reader.getId()
				+ ";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void deleteReader(long readerId) {
		String query = "UPDATE readers SET readers_is_archiwed=1 WHERE readers_id=" + readerId + ";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}
}
