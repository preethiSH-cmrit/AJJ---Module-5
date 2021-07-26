package demo;
import java.sql.*;
import javax.sql.*;

public class updateRSDemo {
	public updateRSDemo(Connection conn) {
		Statement stmt;
		ResultSet rs;
		try{
			String query = "SELECT * FROM cust_tbl WHERE fname='Bobby'";
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query);
			Boolean rec = rs.next();
			if(! rec){
			System.out.println("No data returned");
			System.exit(0);
			}
			rs.updateString("lname","Jones");
			rs.updateRow();
			System.out.println("Updated: "+ rs.getString("fname")+" "+rs.getString("lname"));
			
			String query_ud = "SELECT * FROM cust_tbl";
			
					
			//Insert row in ResultSet
			rs.moveToInsertRow();
			rs.updateString("custNumber", "Ztest");
			rs.updateString("fname", "Jack");
			rs.insertRow();
			System.out.println("Inserted : "+rs.getString("custNumber")+ " "+ rs.getString("fname"));
		
			//Delete row from ResultSet
			rs.last();
			rs.deleteRow();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query);
			stmt.close();
			}catch(SQLException e) {
			System.err.println("SQL Error" + e);
			}
	}
}
