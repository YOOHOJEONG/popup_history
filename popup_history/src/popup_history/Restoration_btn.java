package popup_history;

import java.text.ParseException;

import javax.swing.JList;
import javax.swing.JTextArea;

public class Restoration_btn {
	public void Restoration_btn(JList list, JTextArea textArea){
        textArea.setText(null);
		HomePrint hp1 = new HomePrint();
        hp1.HomePrintIndex(list);
	}
}
