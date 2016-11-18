package popup_history;

import java.text.ParseException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTextArea;



public class HomeSearch {
	public void HomeSearch(String searchVal, JList list) {
		
		try {
			ModifyQuery mq = new ModifyQuery();
		    Vector<String> date_title;
			date_title = mq.modifyQuery("select date, title from history where title like ?", searchVal, null, null);
			list.setListData(date_title);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	 }
}
