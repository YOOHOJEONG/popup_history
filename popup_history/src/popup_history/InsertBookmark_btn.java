package popup_history;

import java.util.StringTokenizer;

import javax.swing.JList;

public class InsertBookmark_btn {
	public void InsertBookmark_btn(JList list){
		String str = (String)list.getSelectedValue();
		StringTokenizer tokens = new StringTokenizer(str);
		String date = tokens.nextToken("¢º");//±¸ºÐÀÚ
		String title = tokens.nextToken("¢º");
		
   		ModifyQuery mq = new ModifyQuery();
   		mq.modifyQuery("insert ignore into bookmark(date, title, contents) "
					+ "select date, title, contents from history where date=? and title=?;", date, title);
	}
}
