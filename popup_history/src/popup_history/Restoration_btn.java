package popup_history;

import java.text.ParseException;

import javax.swing.JList;
import javax.swing.JTextArea;

public class Restoration_btn {//역사출력 창에 오늘날의 역사를 출력하는 클래스
	public void Restoration_btn(JList list, JTextArea textArea){//역사출력 창에 오늘날의 역사를 출력하는 기능
        textArea.setText(null);
		HomePrint hp1 = new HomePrint();
        hp1.HomePrintIndex(list);
	}
}
