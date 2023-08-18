package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	private static String DRIVER = "";
	private static String URL = "";
	private static String USERNAME = "";
	private static String PWD = "";

	static {
		ResourceBundle res = ResourceBundle.getBundle("database");
		DRIVER = res.getString("DRIVER");
		URL = res.getString("URL");
		USERNAME = res.getString("USERNAME");
		PWD = res.getString("PWD");

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PWD);
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
