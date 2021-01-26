package com.library.database.service.dataaccess.readers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.resources.model.Reader;

public class ReadersParser {
	
	/**
     * Static method that takes ResultSet as an argument which contains all readers data from database and returns Map filled with Reader objects created from data from ResultSet
     *
     * @param rs ResultSet with all readers data selected from database
     */
	public static Map<Long, Reader> parseAllReaders(ResultSet rs) {
		Map<Long, Reader> readers = new HashMap<>();
		try {
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setId(rs.getInt("readers_id"));
				reader.setName(rs.getString("readers_name"));
				reader.setSurname(rs.getString("readers_surname"));
				reader.setDateOfBirth(rs.getString("readers_date_of_birth"));
				reader.setAddress(rs.getString("readers_address"));
				reader.setJoinedLibrary(rs.getString("readers_joined"));
				reader.setIsArchived(rs.getBoolean("readers_is_archiwed"));
				reader.setCityId(rs.getInt("cities_id"));
				reader.setCity(rs.getString("cities_name"));
				reader.setPostalCode(rs.getString("cities_postal_code"));

				readers.put(reader.getId(), reader);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return readers;
	}
}
