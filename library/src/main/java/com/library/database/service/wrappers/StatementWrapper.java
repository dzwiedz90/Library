package com.library.database.service.wrappers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.library.database.service.connector.MySQLConnector;

public class StatementWrapper {
	public ResultSet rs = null;
	private Connection connection;
	private Statement statement = null;

	public StatementWrapper(String query, String queryType) {
		if (queryType.equals("query")) {
			executeQuery(query);
		} else if (queryType.equals("update")) {
			executeUpdate(query);
		}
	}

	public void executeUpdate(String query) {

	}

	public void executeQuery(String query) {
		try {
			connection = MySQLConnector.connectMySQLDatabase();
			statement = connection.createStatement();
			statement.execute(query);
			rs = statement.getResultSet();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
