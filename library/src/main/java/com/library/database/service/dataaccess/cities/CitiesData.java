package com.library.database.service.dataaccess.cities;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.library.database.service.wrappers.StatementExecutor;
import com.library.resources.model.City;

public class CitiesData {

	private Connection connection;
	private Statement statement = null;

	public Map getAllCities() {
		Map<Long, City> cities = new HashMap<>();

		String query = "SELECT * FROM cities;";
		StatementExecutor wrapper = new StatementExecutor(query, "query");
		cities = CitiesParser.parseAllCities(wrapper.rs);
		wrapper.closeConnection();

		return cities;
	}
}
