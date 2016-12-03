package popup_history;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
public class Years{
	public void Year(JComboBox comboBox){}
}

class NextYear extends Years{			//�̹��⵵ �������� 100�� ������ ������ �޺��ڽ��� ����
	public void Year(JComboBox comboBox){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("����");
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
class PastYear extends Years{		//�̹��⵵ �������� 1����� �޺��ڽ��� �߰�
	public void Year(JComboBox comboBox){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("����");
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
