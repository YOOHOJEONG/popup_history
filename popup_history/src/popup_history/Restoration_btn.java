package popup_history;

import java.text.ParseException;

import javax.swing.JList;
import javax.swing.JTextArea;

public class Restoration_btn {//������� â�� ���ó��� ���縦 ����ϴ� Ŭ����
	public void Restoration_btn(JList list, JTextArea textArea){//������� â�� ���ó��� ���縦 ����ϴ� ���
        textArea.setText(null);
		HomePrint hp1 = new HomePrint();
        hp1.HomePrintIndex(list);
	}
}
