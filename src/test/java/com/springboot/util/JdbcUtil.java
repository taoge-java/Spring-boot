package com.springboot.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

	private static Connection conn;
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USER, PASS);
			System.err.println("数据库驱动加载成功。。。。。");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
