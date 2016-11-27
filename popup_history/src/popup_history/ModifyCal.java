package popup_history;

import javax.swing.JList;
import javax.swing.JTextArea;

public class ModifyCal {//사용자의 일정을 수정할 수 있는 기능의 클래스
	public void modifyCal(JList DuL, JTextArea CuT){//사용자의 일정을 수정할 수 있는 기능
		SearchCal mc = new SearchCal();
		mc.modifyCal(DuL, CuT);
	}
}
