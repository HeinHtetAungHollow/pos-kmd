package db_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Config {

	private final String CONNECTION = "jdbc:mysql://localhost:3306/pos_2022?";
	private final String PASSWORD = "root";
	private static Connection con = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {

		if (null == con) {
			con = (Connection) DriverManager.getConnection(this.CONNECTION, "root", this.PASSWORD);
		}
		return con;
	}
}