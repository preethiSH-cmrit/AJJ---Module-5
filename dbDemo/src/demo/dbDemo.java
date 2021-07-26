package demo;
import java.sql.*;
import javax.sql.*;
public class dbDemo {

	public static void main(String[] args) {
		
		//connProperties cp = new connProperties();
		//Connection conn = cp.conn;
		dbConn dc = new dbConn();
		Connection conn = dc.conn;
		//srsDemo sd = new srsDemo(conn);
		//updateRSDemo urs = new updateRSDemo(conn);
		stmtDemo std = new stmtDemo(conn);
		//connPool cp = new connPool();
		//Connection conn = cp.conn;
		
	}
}
