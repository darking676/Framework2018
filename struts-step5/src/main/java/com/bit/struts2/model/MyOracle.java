package com.bit.struts2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOracle {
	private static Connection conn;
	
	private MyOracle() {
	}
	
	public static Connection getConnection(){
		try {
			if(conn==null||conn.isClosed()){
				Class.forName("oracle.jdbc.OracleDriver");
				conn=DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe"
						, "scott", "tiger");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
