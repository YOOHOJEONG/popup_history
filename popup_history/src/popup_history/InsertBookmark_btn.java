package popup_history;

import java.text.ParseException;
import java.util.*;
import javax.swing.JList;

public class InsertBookmark_btn {//���ã�� ����� �߰� �� �� �ִ� ��ư����� Ŭ����
	public void InsertBookmark_btn(JList list){//���ã�� ����� �߰� �� �� �ִ� ��ư���
		try {
   			String str = (String)list.getSelectedValue();
   			StringTokenizer tokens = new StringTokenizer(str);
   			String date = tokens.nextToken("��");//������
   			String title = tokens.nextToken("��");
   	   		ModifyQuery mq = new ModifyQuery();
			mq.modifyQuery("insert ignore into bookmark(date, title, contents) "
						+ "select date, title, contents from history where date=? and title=?;", date, title, null);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public int SearchBookmark(JList list){
		String str = (String)list.getSelectedValue();
		StringTokenizer tokens = new StringTokenizer(str);
		String date = tokens.nextToken("��");
		String title = tokens.nextToken("��");
		try{
			ModifyQuery mq = new ModifyQuery();
			Vector<String> contents;
			contents = mq.modifyQuery("select contents from bookmark where date=? and title=?",  date, title, null);
			str = (String)contents.get(0);
   			return 0;
		} catch(Exception e){
			return 1;
		}
	}
}
