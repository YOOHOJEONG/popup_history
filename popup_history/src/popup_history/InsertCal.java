package popup_history;

import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertCal {
	public void Insertcal(JTextField textField_1, JComboBox comboBox, JComboBox comboBox_1, JComboBox comboBox_2){
		String plan = textField_1.getText();
			if(comboBox.getSelectedIndex()==0||comboBox_1.getSelectedIndex()==0||comboBox_2.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null, "��¥�� �Է��ϼ���.","", JOptionPane.WARNING_MESSAGE );
			else if("".equals(plan))
				JOptionPane.showMessageDialog(null, "������ �Է��ϼ���.","", JOptionPane.WARNING_MESSAGE );   					
			else{
				String date = comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString();

				ModifyQuery mq = new ModifyQuery();
			try {
				mq.modifyQuery("insert ignore into calender values(?, ?);", date, plan, null);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				JOptionPane.showMessageDialog(null, "�Է� �Ϸ�","", JOptionPane.PLAIN_MESSAGE);   					
			}
	}
}