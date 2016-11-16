package popup_history;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	Vector<String> modifyQuery(String queryStmt, String input_1, String input_2/*insert 값, 검색한 값*/){
		JDBC jdbc = new JDBC();
		Connection conn = null;
		java.sql.Statement st = null;
        ResultSet rset = null;
		try {
			conn = jdbc.jdbc();
			st = conn.createStatement();
			
			PreparedStatement query = conn.prepareStatement(queryStmt);
			
			Vector<String> resultVal;
			resultVal = new Vector<String>();
			
			if(queryStmt == "select date, title from history where date=current_date"){
				rset = query.executeQuery();
			
				String date, title;
				while(rset.next()){
					date = rset.getString("date"); 
					title = rset.getString("title");
					resultVal.add(date+"▶"+title);
				}
			}
			
			else if(queryStmt == "select contents from history where date=? and title=?"){
				query.setString(1, input_1);
				query.setString(2, input_2);
				rset = query.executeQuery();
			
				String contents;
				while(rset.next()){
					contents = rset.getString("contents");
					resultVal.add(contents);	
				}
			}
			
			return resultVal;			
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }
		return null;
	}
}