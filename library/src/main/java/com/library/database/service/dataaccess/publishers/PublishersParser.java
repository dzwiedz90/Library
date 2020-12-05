package com.library.database.service.dataaccess.publishers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.resources.model.Publisher;

public class PublishersParser {
	
	public static Map parseAllPublishers(ResultSet rs) {
		Map<Long, Publisher> publishers = new HashMap<>();
		try {
			Long i = 1L;
			while (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setId(rs.getInt("publishers_id"));
				publisher.setName(rs.getString("publishers_name"));
				publisher.setYearEstablished(rs.getInt("publishers_year_established"));
				publisher.setCity(rs.getString("cities_name"));
				publisher.setPostalCode(rs.getString("cities_postal_code"));

				publishers.put(i, publisher);
				i++;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return publishers;
	}
}
