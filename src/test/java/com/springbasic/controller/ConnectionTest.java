package com.springbasic.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionTest {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ray?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String USER = "root";
	private static final String PWD = "1234";

	@Test
	public void ConnectionTest() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		
		Connection con = DriverManager.getConnection(URL, USER, PWD);
		
		if(con != null) {
			System.out.println(con.toString());
		}
		
		con.close();
	}
}
