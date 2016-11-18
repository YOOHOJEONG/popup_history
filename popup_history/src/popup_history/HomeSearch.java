package popup_history;

import java.util.Vector;

import javax.swing.JList;



public class HomeSearch {
	public void HomeSearch(String searchVal, JList list) {
		ModifyQuery mq = new ModifyQuery();
	    Vector<String> date_title = mq.modifyQuery("select date, title from history where title like ?", searchVal, null);
	    list.setListData(date_title);
	}
}
