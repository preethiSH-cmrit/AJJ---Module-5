package demo;

import java.sql.*;
import javax.sql.*;
public class dbConn {
	public Connection conn;
	public dbConn() {
		String url = "jdbc:mysql://localhost:3306/custdb";
		//String url = "jdbc:odbc:Customer_Database";
		String username = "root";
		String password = "admin";
				//try {
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					//Class.forName("com.mysql.cj.jdbc.Driver");	
					//System.out.println("Connected to driver successfully");
					//int sec = DriverManager.getLoginTimeout();
					//System.out.println("Timeout: "+sec);
				//}catch(ClassNotFoundException ce) {
					//System.out.println("Unable to connect to driver");
				//	ce.printStackTrace();
				//}
				try {
					conn = DriverManager.getConnection(url,username, password);
					System.out.println("Connected to database successfully!");
				}catch(SQLException err) {
					System.out.println("Unable to connect to database");
					err.printStackTrace();
				}

	}

}
