package popup_history;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class JDBC {
	void jdbc(){
		try {

	         Class.forName("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.err.println("ClassNotFoundException : " + e.getMessage());
	      }
	      try {
	         Connection conn = null;

	         conn = DriverManager.getConnection("jdbc:mysql://165.229.88.154:3306/popup_history?useSSL=false",
						"hojeong", "0802");    //제 겁니다!!
	    
	         //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe?useSSL=false&autoReconnect=true",
	                 //"hoonju", "19950905");  // Xshell 여러분들은 이거요!!

	         
	         java.sql.Statement st = null;
	         ResultSet rset = null;
	         st = conn.createStatement();
	         
	        // while (rset.next()) {
	        //    System.out.println("d_name : "+rset.getString(1)+"\td_food : "+rset.getString(2)+"\td_price : "+rset.getInt(3)+"\td_tel : "+rset.getString(4)+"\td_group : "+rset.getString(5));
	       //  }
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }

	}
}

class ModifyQuery{
	void modifyQuery(){
		JDBC jdbc = new JDBC();
		try {
	         Connection conn = null;

	         conn = DriverManager.getConnection("jdbc:mysql://165.229.88.154:3306/popup_history?useSSL=false",
						"hojeong", "0802");
	         
	         java.sql.Statement st = null;
	         ResultSet rset = null;
	         st = conn.createStatement();
	         
	        // while (rset.next()) {
	        //    System.out.println("d_name : "+rset.getString(1)+"\td_food : "+rset.getString(2)+"\td_price : "+rset.getInt(3)+"\td_tel : "+rset.getString(4)+"\td_group : "+rset.getString(5));
	       //  }
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }
	}
}

