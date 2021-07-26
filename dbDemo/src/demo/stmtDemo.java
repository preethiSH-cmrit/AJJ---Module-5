package demo;

import java.sql.*;
import javax.sql.*;

public class stmtDemo {
   public stmtDemo(Connection conn) {
	   Statement stmt;
		ResultSet rs=null;
		try {
			String query = "SELECT * from cust_tbl";
			String updateQ = "update cust_tbl set lname = 'Brown' where custNumber='A100'";
			stmt=conn.createStatement();
			int nRowsUpdated = stmt.executeUpdate(updateQ);
			System.out.println(nRowsUpdated +" rows updated");
			boolean b= stmt.execute(query);
			if(b)
				rs =stmt.getResultSet();
			// or use executeQuery() to directly obtain the result set.
			//rs = stmt.executeQuery(query);
			boolean rec = rs.next();
			if(!rec) {
				System.out.println("No data returned");
			}else {
				System.out.println(String.format("%11s %20s %20s","cust_num","Name","Street"));
				do {
					String cust_num = rs.getString("custNumber");
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					String street = rs.getString("street");
					System.out.println(String.format("%11s %20s %20s",cust_num,fname+" "+lname,street));
					}while(rs.next());
				
				//prepared Statement
				String qPrep ="Select * from cust_tbl where custNumber = ?";
				PreparedStatement pstmt =conn.prepareStatement(qPrep);
				pstmt.setString(1, "C100");
				ResultSet prs = pstmt.executeQuery();
				prs.next();
				System.out.println("\n**Customer with Number : C100 is ");
				System.out.println(prs.getString(2)+" "+prs.getString(3));
				
				
				//Callable Statement
				String cQry = "{CALL democt(?,?)}";
				CallableStatement cstmt = conn.prepareCall(cQry);
			
				cstmt.setString(1,"C100");
				//cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter("opParam", Types.VARCHAR);
				
				
				cstmt.execute();
				String street = cstmt.getString("opParam");
				System.out.println("\n**Call Statement Demo");
				System.out.println(street);
			}
			stmt.close();
			rs.close();
		}catch(SQLException err) {
			err.printStackTrace();
		}

	}
   
}
