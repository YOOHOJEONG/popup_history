package popup_history;

import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTextArea;

public class HomePrint {//메인 프레임에서 역사를 출력해주는 기능의 클래스
	public void HomePrintIndex(JList list){//MainFrame에 오늘 날짜와 관련 된 역사 인덱스 출력
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
	
	public void HomePrintContents(JList list, JTextArea textArea){//MainFrame에서 선택한 인덱스의 상세 내용 출력
		// TODO Auto-generated method stub
		
		try {
			String str = (String)list.getSelectedValue();
			StringTokenizer tokens = new StringTokenizer(str);
			String date = tokens.nextToken("▶");//구분자
			String title = tokens.nextToken("▶");

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
