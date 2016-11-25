package popup_history;

import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTextArea;

public class HomePrint {
	public void HomePrintIndex(JList list){
		// TODO Auto-generated method stub
	   
		try {
			ModifyQuery mq = new ModifyQuery();
			Vector<String> date_title;
			date_title = mq.modifyQuery("select date, title from history where month(date)=month(current_date) and day(date)=day(current_date) order by year(date)", null, null, null);
		    list.setListData(date_title);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void HomePrintContents(JList list, JTextArea textArea){
		// TODO Auto-generated method stub
		
		try {
			String str = (String)list.getSelectedValue();
			StringTokenizer tokens = new StringTokenizer(str);
			String date = tokens.nextToken("¢º");//±¸ºÐÀÚ
			String title = tokens.nextToken("¢º");

			ModifyQuery mq = new ModifyQuery();
			Vector<String> contents;
			contents = mq.modifyQuery("select contents from history where date=? and title=?", date, title, null);

			String text = (String)contents.get(0);      	       
			textArea.setText(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
  	}
	
}
