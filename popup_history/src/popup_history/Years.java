package popup_history;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
public class Years{
	public void Year(JComboBox comboBox){}
}

class NextYear extends Years{			//이번년도 기준으로 100년 이후의 연도를 콤보박스에 넣음
	public void Year(JComboBox comboBox){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("연도");
	    comboBox.addItem(arr.get(0));
	    Calendar today = Calendar.getInstance();
	    int year=today.get(Calendar.YEAR)-1;
	    for(int i=1; i<102; i++)
	    {
	       arr.add(String.valueOf(year+i));
	       comboBox.addItem(arr.get(i));
	    }
	}
}
class PastYear extends Years{		//이번년도 기준으로 1년까지 콤보박스에 추가
	public void Year(JComboBox comboBox){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("연도");
	    comboBox.addItem(arr.get(0));
	    Calendar today = Calendar.getInstance();
	    int year=today.get(Calendar.YEAR)+1;
	    for(int i=1; i<year; i++)
	    {
	       arr.add(String.valueOf(year-i));
	       comboBox.addItem(arr.get(i));
	    }
	}
}
