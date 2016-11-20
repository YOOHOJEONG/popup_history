package popup_history;

import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;

public class AdminSearch {

	public void deleteHistory(JList DmL){
		String str = (String)DmL.getSelectedValue();
		if(str==null){
			JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.WARNING_MESSAGE );
		}
		else{
			StringTokenizer tokens = new StringTokenizer(str);
			String date = tokens.nextToken("▶");//구분자
			String title = tokens.nextToken("▶");

			try {
				ModifyQuery mq = new ModifyQuery();
				mq.modifyQuery("delete from history where date=? and title=?;", date, title, null);
				JOptionPane.showMessageDialog(null, "삭제 완료","", JOptionPane.PLAIN_MESSAGE);   					
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void modifyHistory(JList CmL, JTextField textField_1, JTextArea textField_2){
		String str = (String)CmL.getSelectedValue();
		StringTokenizer tokens = new StringTokenizer(str);
		String date = tokens.nextToken("▶");//구분자
		String title = tokens.nextToken("▶");
		
		String update_title = textField_1.getText();
		String update_contents = textField_2.getText();
		if("".equals(update_title))
				JOptionPane.showMessageDialog(null, "제목을 입력하세요.","", JOptionPane.WARNING_MESSAGE );
		else if("".equals(update_contents))
				JOptionPane.showMessageDialog(null, "내용을 입력하세요.","", JOptionPane.WARNING_MESSAGE );
		else{
			try {
				ModifyQuery mq = new ModifyQuery();
				mq.modifyQuery("update history set title=?, contents=? where title = ?;", update_title, update_contents, title);	   			
				JOptionPane.showMessageDialog(null, "수정 완료","", JOptionPane.PLAIN_MESSAGE);   					
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
