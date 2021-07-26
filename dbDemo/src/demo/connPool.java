package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class connPool {
	public Connection conn;
	String url="jdbc:mysql://localhost:3306/test_db";
	String uname = "root";
	String pswd ="admin";
	public connPool() {
	/*try {
	conn = DriverManager.getConnection(url,uname,pswd);
	}catch(SQLException se) {
		se.printStackTrace();
	}*/
		DataSource pool=null ;
	try {
		System.getProperty(Context.PROVIDER_URL);

		Context ctx = new InitialContext();
	Context ctext = new InitialContext();
	pool= (DataSource)ctext.lookup("java:comp/env/jdbc/pool");
	}catch(NamingException ne) {
	ne.printStackTrace();
	}
	try {
		conn = pool.getConnection();
	}catch(SQLException se) {
		se.printStackTrace();
	}
	}
}
