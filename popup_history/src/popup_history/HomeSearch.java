package popup_history;

import java.text.ParseException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTextArea;



public class HomeSearch {//���� �����ӿ��� �˻��� �� �� �ִ� ����� Ŭ����
	public void HomeSearch(String searchVal, JList list, JTextArea textArea) {//���� �����ӿ��� �˻��� �� �� �ִ� ���
		
		try {
			textArea.setText(null);//���ο� �� �˻��� ���� ������ �ε��� �󼼳��� ���� �ʱ�ȭ
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
