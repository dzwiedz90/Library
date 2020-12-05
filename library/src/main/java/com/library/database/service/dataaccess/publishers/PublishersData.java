package com.library.database.service.dataaccess.publishers;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.library.database.service.wrappers.StatementExecutor;
import com.library.resources.model.Publisher;

public class PublishersData {
	private Connection connection;
	private Statement statement = null;

	public Map getAllPublishers() {
		Map<Long, Publisher> publishers = new HashMap<>();

		String query = "SELECT p.publishers_id, p.publishers_name, p.publishers_year_established, c.cities_name, c.cities_postal_code FROM publishers AS p INNER JOIN cities AS c ON p.cities_id=c.cities_id;";
		StatementExecutor wrapper = new StatementExecutor(query, "query");
		publishers = PublishersParser.parseAllPublishers(wrapper.rs);
		wrapper.closeConnection();

		return publishers;
	}
}
