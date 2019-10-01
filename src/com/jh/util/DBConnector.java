package com.jh.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnector {

		//메서드명  getConnect 
		//Exception은 throws 
	
	public static Connection getConnect() throws Exception {
		String user = "scott";
		String password="tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String drvier = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(drvier);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
