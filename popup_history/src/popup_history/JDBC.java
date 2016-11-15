package popup_history;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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

class ModifyQuery{
	String modifyQuery(String queryStmt){
		JDBC jdbc = new JDBC();
		Connection conn = null ;
		java.sql.Statement st = null;
        ResultSet rset = null;
		try {
			conn = jdbc.jdbc();
			queryStmt = "select date, title from history";
			st = conn.createStatement();
			rset = st.executeQuery(queryStmt);
			String dateTitle_his;
			while(rset.next()){
				dateTitle_his = "Date : " + rset.getDate("date") + "\nTitle : " + rset.getString("title");
				System.out.println(dateTitle_his);
				return dateTitle_his;
			}
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }
		return null;
	}
}