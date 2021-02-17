package com.library.database.service.dataaccess.publishers;

import java.util.HashMap;
import java.util.Map;

import com.library.database.service.executors.StatementExecutor;
import com.library.resources.model.Publisher;

public class PublishersData {

	public Map<Long, Publisher> getAllPublishers() {
		Map<Long, Publisher> publishers = new HashMap<>();

		String query = "SELECT p.publishers_id, p.publishers_name, p.publishers_year_established, c.cities_id, c.cities_name, c.cities_postal_code, p.publishers_is_archiwed FROM publishers AS p INNER JOIN cities AS c ON p.cities_id=c.cities_id;";
		StatementExecutor wrapper = new StatementExecutor(query, "query");
		publishers = PublishersParser.parseAllPublishers(wrapper.rs);
		wrapper.closeConnection();

		return publishers;
	}

	public void addPublisher(Publisher publisher) {
		String query = "INSERT INTO publishers(publishers_name, publishers_year_established, publishers_is_archiwed, cities_id) VALUES('"
				+ publisher.getName() + "', " + publisher.getYearEstablished() + ", " + publisher.getIsArchiwed() + ", "
				+ publisher.getCityId() + ");";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void updatePublisher(Publisher publisher) {
		String query = "UPDATE publishers SET publishers_name='" + publisher.getName()
				+ "', publishers_year_established=" + publisher.getYearEstablished() + ", publishers_is_archiwed="
				+ publisher.getIsArchiwed() + ", cities_id=" + publisher.getCityId() + " WHERE publishers_id="
				+ publisher.getId() + ";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void deletePublisher(long publisherId) {
		String query = "UPDATE publishers SET publishers_is_archiwed=1 WHERE publishers_id="+publisherId+";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}
}
