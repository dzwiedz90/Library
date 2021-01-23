package com.library.database.service.dataaccess.cities;

import java.util.HashMap;
import java.util.Map;

import com.library.database.service.executors.StatementExecutor;
import com.library.resources.model.City;

public class CitiesData {

	public Map<Long, City> getAllCities() {
		Map<Long, City> cities = new HashMap<>();

		String query = "SELECT cities_id, cities_name, cities_postal_code FROM cities;";
		StatementExecutor executor = new StatementExecutor(query, "query");
		cities = CitiesParser.parseAllCities(executor.rs);
		executor.closeConnection();

		return cities;
	}

	public void addCity(City city) {
		String query = "INSERT INTO cities(cities_name, cities_postal_code) VALUES('" + city.getName() + "', '"
				+ city.getPostalCode() + "');";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void updateCity(City city) {
		String query = "UPDATE cities SET cities_name='" + city.getName() + "', cities_postal_code='"
				+ city.getPostalCode() + "' WHERE cities_id=" + city.getCityId() + ";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}
}
