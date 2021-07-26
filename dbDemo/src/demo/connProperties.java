package demo;
import java.io.*;
import java.sql.*;
import java.util.Properties;

import javax.sql.*;

public class connProperties {
	public Connection conn;
	public Properties loadPropertiesFile(){
		Properties prop = new Properties();
		try {
			
		InputStream in = new FileInputStream("properties.txt");
		
		prop.load(in);
		}catch(IOException err) {
			System.out.println("Unable to load properties");
			err.printStackTrace();
			System.exit(1);
		}
		
		return prop;
	}
	public connProperties() {
		System.out.println("create jdbc connection using properties file");
		
			Properties prop = loadPropertiesFile();
			String driverClass = prop.getProperty("MYSQLJDBC.driver");
			System.out.println(driverClass);
			String url = prop.getProperty("MYSQLJDBC.url");
			String username = prop.getProperty("MYSQLJDBC.username");
			String password = prop.getProperty("MYSQLJDBC.password");
			try {
			Class.forName(driverClass);
			}catch(ClassNotFoundException err) {
				System.out.println("Unable to load driver");
			}
			try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successful");
			}catch(SQLException err) {
				System.out.println("Unable to connect to datbase");
			}

	}
}
