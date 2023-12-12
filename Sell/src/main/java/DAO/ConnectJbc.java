package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

public class ConnectJbc {
	private final static String serverName = "localhost";
	private final static String dbName = "BanHang";
	private final static String portNumber = "1433";
	private final static String instance = "";// MSSQLSERVER LEAVE THIS ONE
	// EMPTY IF YOUR SQL IS A SINGLE INSTANC

	public Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ";integratedSecurity=true;databaseName="
				+ dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName="
					+ dbName;
		// DriverManager.registerDriver(new
		// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) {
		try {

			Connection c = new ConnectJbc().getConnectionW();

			if (c == null) {

				System.out.println("Something wrong");

			} else {

				System.out.println("Connected");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		// truy vấn bảng Product

		try {

			Connection conn = new ConnectJbc().getConnectionW();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Product");

			while (rs.next()) {

				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getInt(4)+ " " + rs.getString(5)+ " " + rs.getInt(6)+ " " + rs.getInt(7)+ " " + rs.getInt(8)+ " " + rs.getInt(9));

			}

			conn.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

}
