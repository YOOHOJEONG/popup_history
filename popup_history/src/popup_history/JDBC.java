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
						"hojeong", "0802");    //�� �̴ϴ�!!
	    
	         //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/popup_history?useSSL=false",
				//"hojeong", "0802");  // Xshell �����е��� �̰ſ�!!
	   
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }
		return conn;
	}
}

class ModifyQuery {
	Vector<String> modifyQuery(String queryStmt, String input_1, String input_2/*insert ��, �˻��� ��*/){
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
					resultVal.add(date+"��"+title);
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
			
			/*else if(queryStmt == "insert into bookmark(date, title, contents) "
   					+ "select date, title, contents from history where date='"+input_1+"' and title='"+input_2+"';"){
				//st.executeUpdate("insert into bookmark(date, title, contents) "
       				//	+ "select date, title, contents from history where date="+input_1+"and title="+input_2);
				
				rset=query.executeQuery();
			}
			else if(queryStmt == "delete from bookmark(date, title, contents) "
   					+ "select date, title, contents from history where date='"+input_1+"' and title='"+input_2+"';"){
				//st.executeUpdate("delete from bookmark(date, title, contents) "
       			//		+ "select date, title, contents from history where date="+input_1+"and title="+input_2);
				rset=query.executeQuery();
			}*/
			
			return resultVal;			
	      } catch (SQLException sqex) {
	         System.out.println("SQLException: " + sqex.getMessage());
	         System.out.println("SQLState: " + sqex.getSQLState());
	      }
		return null;
	}
}