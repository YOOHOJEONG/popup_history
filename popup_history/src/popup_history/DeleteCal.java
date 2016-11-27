package popup_history;

import javax.swing.JList;

public class DeleteCal {//일정 삭제 기능
	public void DeleteCal(JList DuL){
		SearchCal dc = new SearchCal();
		dc.deleteCal(DuL);
	}
}
