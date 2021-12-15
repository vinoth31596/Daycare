package edu.neu.csye6200Backend;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	private Connection connect;
	private static String JDBCURL = "jdbc:postgresql://localhost:5433/csye6200.group6.daycareproject";
	private static String USERNAME = "postgres";
	private static String PASSWORD = "admin";
	public Connection makeConnection() {
		try {
			connect = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
			if (connect!=null) {
				System.out.println("Connection Successful");
			}
			else{
				System.out.println("Connection unsuccessful");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connect;
		
}
}
