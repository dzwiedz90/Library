package com.library.database.service.dataaccess.cities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.resources.model.City;


public class CitiesParser {
	
	public static Map<Long, City> parseAllCities(ResultSet rs) {
		Map<Long, City> cities = new HashMap<>();
		try {
			Long i = 1L;
			while (rs.next()) {
				City city = new City();
				city.setCityId(rs.getInt("cities_id"));
				city.setName(rs.getString("cities_name"));
				city.setPostalCode(rs.getString("cities_postal_code"));
				
				cities.put(i, city);
				i++;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return cities;
	}
}
