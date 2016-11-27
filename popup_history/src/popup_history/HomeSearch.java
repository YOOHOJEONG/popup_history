package popup_history;

import java.text.ParseException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JTextArea;



public class HomeSearch {//메인 프레임에서 검색을 할 수 있는 기능의 클래스
	public void HomeSearch(String searchVal, JList list, JTextArea textArea) {//메인 프레임에서 검색을 할 수 있는 기능
		
		try {
			textArea.setText(null);//새로운 값 검색을 위해 선택한 인덱스 상세내용 보기 초기화
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
