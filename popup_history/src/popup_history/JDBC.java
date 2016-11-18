package popup_history;
//
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	Vector<String> modifyQuery(String queryStmt, String input_1, String input_2, String input_3/*insert ��, �˻��� ��*/) throws ParseException {
		JDBC jdbc = new JDBC();
		Connection conn = null;
		java.sql.Statement st = null;
        ResultSet rset = null;
		try {
			conn = jdbc.jdbc();
			st = conn.createStatement();

			Vector<String> resultVal;
			resultVal = new Vector<String>();
			PreparedStatement query = conn.prepareStatement(queryStmt);
			
			if(queryStmt == "select date, title from history where month(date)=month(current_date) and day(date)=day(current_date)"){
				rset = st.executeQuery(queryStmt);
			
				String date, title;
				while(rset.next()){
					date = rset.getString("date"); 
					title = rset.getString("title");
					resultVal.add(date+"��"+title);
				}
			}
			
			else if((queryStmt == "select contents from history where date=? and title=?")||
					(queryStmt == "select contents from bookmark where date=? and title=?")){
				query.setString(1, input_1);
				query.setString(2, input_2);
				rset = query.executeQuery();
			
				String contents;
				while(rset.next()){
					contents = rset.getString("contents");
					resultVal.add(contents);	
				}
			}
			
			else if(queryStmt == "insert ignore into bookmark(date, title, contents) "
   					+ "select date, title, contents from history where date=? and title=?;"){
				query.setString(1, input_1);
				query.setString(2, input_2);
				query.executeUpdate();
			}
			
			else if(queryStmt == "delete ignore into bookmark(date, title, contents) "
   					+ "select date, title, contents from history where date=? and title=?;"){
				query.setString(1, input_1);
				query.setString(2, input_2);
				query.executeUpdate();
			}
			
			else if(queryStmt == "select date, title from history where title like ?"){
				query.setString(1, "%"+input_1+"%");
				rset=query.executeQuery();

				String date, title;
				while(rset.next()){
					date = rset.getString("date"); 
					title = rset.getString("title");
					resultVal.add(date+"��"+title);
				}
			}
			else if(queryStmt == "insert ignore into history values(?, ?, ?);"){
   				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
   				java.util.Date to = transFormat.parse(input_1);
				
   				query.setString(1, input_1);
				query.setString(2, input_2);
				query.setString(3, input_3);
				query.executeUpdate();
			}
			else if((queryStmt == "delete from history where date=? and title=?;")||
					(queryStmt == "delete from bookmark where date=? and title=?;")){
				query.setString(1, input_1);
				query.setString(2, input_2);
				query.executeUpdate();
			}
			else if(queryStmt == "select date, title from bookmark"){
				rset = st.executeQuery(queryStmt);
				
				String date, title;
				while(rset.next()){
					date = rset.getString("date"); 
					title = rset.getString("title");
					resultVal.add(date+"��"+title);
				}
			}
			else if(queryStmt == "select date, title from bookmark where date=? and title=?"){
				query.setString(1, input_1);
				query.setString(2, input_2);
				rset=query.executeQuery();
				
				String date, title;
				while(rset.next()){
					date=rset.getString("date");
					title = rset.getString("title");
					resultVal.add(date+title);
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