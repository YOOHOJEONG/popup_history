package popup_history;

import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchCal {//일정을 수정, 삭제할 때  검색하는  기능의  클래스
	public void deleteCal(JList DuL){//일정 삭제를 위한 기능
		String str = (String)DuL.getSelectedValue();//삭제를 위해 선택한 인덱스 값
		if(str==null){
				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.ERROR_MESSAGE );
		}
		else{//선택한 인덱스 값이 있다면 삭제 실행
			StringTokenizer tokens = new StringTokenizer(str);
			String date = tokens.nextToken("▶");//구분자
			String plan = tokens.nextToken("▶");

			try {
				ModifyQuery mq = new ModifyQuery();
				Vector<String> deleteRec;
				deleteRec = mq.modifyQuery("delete from calender where date=? and plan=?;", date, plan, null);
				JOptionPane.showMessageDialog(null, "삭제 완료","", JOptionPane.INFORMATION_MESSAGE);   					
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void modifyCal(JList CuL, JTextArea CuT){//일정 수정을 위한 기능
		String str = (String)CuL.getSelectedValue();//수정을 위해 선택한 인덱스 값
		StringTokenizer tokens = new StringTokenizer(str);
		String date = tokens.nextToken("▶");//구분자
		String plan = tokens.nextToken("▶");
		String update_plan = CuT.getText();

		if("".equals(update_plan))
				JOptionPane.showMessageDialog(null, "내용을 입력하세요.","", JOptionPane.ERROR_MESSAGE );
		else{//선택한 인덱스 값이 있다면 수정 실행
			ModifyQuery mq = new ModifyQuery();
			try {
				mq.modifyQuery("update calender set plan = ? where plan = ?;", update_plan, plan, null);
				JOptionPane.showMessageDialog(null, "수정 완료","", JOptionPane.INFORMATION_MESSAGE);   					

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
