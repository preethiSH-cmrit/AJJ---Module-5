package demo;
import java.sql.*;
import javax.sql.*;

public class srsDemo {
	public srsDemo(Connection conn) {
		try {
			System.out.println("\n** Scrollable ResultSet Demo ");
			String query = "Select fname from cust_tbl";
			Statement st = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet scrs= st.executeQuery(query);
			boolean rec = scrs.next();
			scrs.first();
			System.out.println(scrs.getString(1));
			scrs.last(); System.out.println(scrs.getString(1));
			scrs.previous(); System.out.println(scrs.getString(1));
			scrs.absolute(5); System.out.println(scrs.getString(1));
			scrs.relative(-2); System.out.println(scrs.getString(1));
			scrs.relative(3); System.out.println(scrs.getString(1));
			st.close();
			}catch(SQLException err) {
			err.printStackTrace();
			}
	}

}
