package com.covid.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_connect {

	public static void add(String email, String passw) {

		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/covid";
			String username = "root";
			String password = "debona";

			// Step 1
			Class.forName(driver);

			// Step 2
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connction Success");
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `covid`.`patient` (`email`,`password`) VALUES ('" + email + "','" + passw + "');");

			int status = ps.executeUpdate();

			if (status != 0) {
				System.out.println("Database is Connected");
				System.out.println("Record was inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
