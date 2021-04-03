package model;

import java.sql.Connection;

public class MSSQLConnection {
	private java.sql.Connection con = null;
	private final String url = "jdbc:sqlserver://";
	private final String serverName = "localhost;instance=sqlexpress";
	private final String portNumber = "1433";
	private final String userName = "sa";
	private final String password = "820332Mk";
	String database = "SENG315Project";

	public MSSQLConnection() {

	}

	public Connection getConnection() {
		try {
			String connectionURL = url + serverName + ":" + portNumber + ";sendStringParametersAsUnicode=false";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = java.sql.DriverManager.getConnection(connectionURL, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : " + e.getMessage());
		}
		return con;
	}

	
	
	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}
	
	
}
