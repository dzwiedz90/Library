package com.library.database.service.dataaccess.publishers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.resources.model.Publisher;

public class PublishersParser {
	
	public static Map<Long, Publisher> parseAllPublishers(ResultSet rs) {
		Map<Long, Publisher> publishers = new HashMap<>();
		try {
			while (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setId(rs.getInt("publishers_id"));
				publisher.setName(rs.getString("publishers_name"));
				publisher.setYearEstablished(rs.getInt("publishers_year_established"));
				publisher.setCityId(rs.getInt("cities_id"));
				publisher.setCity(rs.getString("cities_name"));
				publisher.setPostalCode(rs.getString("cities_postal_code"));
				publisher.setIsArchiwed(rs.getBoolean("publishers_is_archiwed"));

				publishers.put(publisher.getId(), publisher);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return publishers;
	}
}
