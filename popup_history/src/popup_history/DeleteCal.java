package popup_history;

import javax.swing.JList;

public class DeleteCal {
	public void DeleteCal(JList DuL){
		SearchCal dc = new SearchCal();
		dc.deleteCal(DuL);
	}
}
