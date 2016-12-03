package popup_history;

import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;

public class AdminSearch extends AdminLoginFrame{//관리자가 역사를 수정, 삭제할 때 검색하는 기능의 클래스
	
	public void deleteHistory(JList DmL){//역사 정보 삭제 기능
		String str = (String)DmL.getSelectedValue();//삭제하기 위해 선택한 인덱스 값
		if(str==null){
			JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.ERROR_MESSAGE );
		}
		else{//인덱스를 선택했다면
			StringTokenizer tokens = new StringTokenizer(str);
			String date = tokens.nextToken("▶");//구분자
			String title = tokens.nextToken("▶");

			try {
				ModifyQuery mq = new ModifyQuery();
				mq.modifyQuery("delete from history where date=? and title=?;", date, title, null);
				JOptionPane.showMessageDialog(null, "삭제 완료","", JOptionPane.INFORMATION_MESSAGE);   					
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void modifyHistory(JList CmL, JTextField textField_1, JTextArea textField_2){//역사 정보 수정 기능
		String str = (String)CmL.getSelectedValue();
		StringTokenizer tokens = new StringTokenizer(str);
		String date = tokens.nextToken("▶");//구분자
		String title = tokens.nextToken("▶");
		
		String update_title = textField_1.getText();//수정 할 제목
		String update_contents = textField_2.getText();//수정 할 내용
		if("".equals(update_title))
				JOptionPane.showMessageDialog(null, "제목을 입력하세요.","", JOptionPane.ERROR_MESSAGE );
		else if("".equals(update_contents))
				JOptionPane.showMessageDialog(null, "내용을 입력하세요.","", JOptionPane.ERROR_MESSAGE );
		else{//제목과 내용을 입력했다면
			try {
				ModifyQuery mq = new ModifyQuery();
				mq.modifyQuery("update history set title=?, contents=? where title = ?;", update_title, update_contents, title);	   			
				JOptionPane.showMessageDialog(null, "수정 완료","", JOptionPane.INFORMATION_MESSAGE);   					
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
