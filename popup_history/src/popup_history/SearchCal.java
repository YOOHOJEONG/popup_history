package popup_history;

import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchCal {
	public void deleteCal(JList DuL){
		String str = (String)DuL.getSelectedValue();
		if(str==null){
				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.WARNING_MESSAGE );
		}
		else{
			StringTokenizer tokens = new StringTokenizer(str);
			String date = tokens.nextToken("▶");//구분자
			String plan = tokens.nextToken("▶");

			try {
				ModifyQuery mq = new ModifyQuery();
				Vector<String> deleteRec;
				deleteRec = mq.modifyQuery("delete from calender where date=? and plan=?;", date, plan, null);
				JOptionPane.showMessageDialog(null, "삭제 완료","", JOptionPane.PLAIN_MESSAGE);   					
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void modifyCal(JList CuL, JTextArea CuT){
		String str = (String)CuL.getSelectedValue();
		StringTokenizer tokens = new StringTokenizer(str);
		String date = tokens.nextToken("▶");//구분자
		String plan = tokens.nextToken("▶");
		String update_plan = CuT.getText();

		if("".equals(update_plan))
				JOptionPane.showMessageDialog(null, "내용을 입력하세요.","", JOptionPane.WARNING_MESSAGE );
		else{
			ModifyQuery mq = new ModifyQuery();
			try {
				mq.modifyQuery("update calender set plan = ? where plan = ?;", update_plan, plan, null);
				JOptionPane.showMessageDialog(null, "수정 완료","", JOptionPane.PLAIN_MESSAGE);   					

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
