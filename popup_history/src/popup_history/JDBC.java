package popup_history;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

class JDBC {
	Connection jdbc(){
        Connection conn = null;

		try {

	         Class.forName("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.err.println("ClassNotFoundException : " + e.getMessage());
	      }
	      try {

	         conn = DriverManager.getConnection("jdbc:mysql://165.229.88.154:3306/popup_history?useSSL=false",
						"hojeong", "0802");    //제 겁니다!!
	    
	         //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/popup_history?useSSL=false",
				//"hojeong", "0802");  // Xshell 여러분들은 이거요!!
	   
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }
		return conn;
	}
}

class ModifyQuery {
	Vector<String> modifyQuery(String queryStmt, String order){
		JDBC jdbc = new JDBC();
		Connection conn = null;
		java.sql.Statement st = null;
        ResultSet rset = null;
		try {
			conn = jdbc.jdbc();
			//queryStmt = "select date, title from history";
			st = conn.createStatement();
			rset = st.executeQuery(queryStmt);
			
			if(order == "selectDateTitle_history"){
				Vector<String> date_title;
				date_title = new Vector<String>();
			
				String date, title;
			
				while(rset.next()){
					date = rset.getString("date"); 
					title = rset.getString("title");
					date_title.add(date+title);
				}
				return date_title;
			}
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }
		return null;
	}
}