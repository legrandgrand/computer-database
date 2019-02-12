package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	
	String url = "jdbc:mysql://localhost:3306/computer-database-db";
	String user = "admincdb";
	String password = "qwerty1234";

	
	public Connection connectDB(Connection connection) throws SQLException {
		   return connection = DriverManager.getConnection( url, user, password );
	}
	
	public void closeDB(Connection connection) throws SQLException {
		connection.close();
		
	}
}
