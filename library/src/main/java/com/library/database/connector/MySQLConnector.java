package com.library.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

	public static Connection connectMySQLDatabase() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/library?";
		Connection conn = null;
		try {
			String unicode = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8&allowMultiQueries=true";
			conn = DriverManager.getConnection(url + unicode, "root", "password");
		} catch (SQLException e) {
			System.out.println("error");
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static Connection connectMySQLServer() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/?";
		Connection conn = null;
		try {
			String unicode = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url + unicode, "root", "password");
		} catch (SQLException e) {
			System.out.println("error");
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
