package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.Toolkit;
import java.awt.Color;

public class DeleteHistoryFrame extends JFrame {
	int flagAll=0;

	private JPanel contentPane;
	private JTextField textField;

	
	public DeleteHistoryFrame() {
		setTitle("History DB ����");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteHistoryFrame.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String wal[]={"��", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_1 = new JComboBox(wal);
		comboBox_1.setBounds(46, 10, 86, 24);
		comboBox_1.setSelectedIndex(0);
		contentPane.add(comboBox_1);
		
		String date[]={"��","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setBounds(144, 10, 86, 24);
		comboBox_2.setSelectedIndex(0);
		contentPane.add(comboBox_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(46, 44, 312, 24);
		contentPane.add(textField);
		
		JLabel label = new JLabel("�˻�");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 10, 53, 24);
		contentPane.add(label);
		
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(12, 120, 420, 130);
		contentPane.add(JSP);
		
		JList DmL = new JList();
		JSP.setViewportView(DmL);
		
		JButton button = new JButton("Ȯ��");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flagAll=0;

				String searchVal = textField.getText();
 				if(((comboBox_1.getSelectedIndex()>0)&&(comboBox_2.getSelectedIndex()>0))
 						&&(!"".equals(searchVal))){
 					try{
 						ModifyQuery mq=new ModifyQuery();
 						Vector<String> date_title;
 						String month_date = "____-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString();
 						date_title=mq.modifyQuery("select date, title from history where title like ? and date like ? order by month(date), day(date)", searchVal, month_date,null );
 						DmL.setListData(date_title);
 					}catch(ParseException e1){
 						e1.printStackTrace();
 					}
 					
 				}
 				else if((comboBox_1.getSelectedIndex()>0)&&(comboBox_2.getSelectedIndex()>0)){
 					try {
 						ModifyQuery mq = new ModifyQuery();
 	 					Vector<String> date_title;
 						String month_date = "____-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString();
						date_title=mq.modifyQuery("select date, title from history where date like ? order by month(date), day(date)", month_date, comboBox_1.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString());
	 					DmL.setListData(date_title);

 					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 				}
 				else if(!"".equals(searchVal)){
 					try {
 						ModifyQuery mq = new ModifyQuery();
 	 					Vector<String> date_title;
						date_title = mq.modifyQuery("select date, title from history where title like ? order by month(date), day(date)", searchVal, null, null);
	 					DmL.setListData(date_title);
 					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 				}
 				else
 	   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );       		
			}
		});
		button.setBounds(370, 43, 62, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("���");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 85, 53, 25);
		contentPane.add(label_1);
		
		
		JButton button_1 = new JButton("����");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();

				if(DmL.getSelectedValue()==null){
					if("".equals(searchVal))
		   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );
					else
						JOptionPane.showMessageDialog(null, "���� �� �����͸� �����ϼ���.","", JOptionPane.ERROR_MESSAGE );
				}
				else{
				AdminSearch dm = new AdminSearch();
				dm.deleteHistory(DmL);
				
				if(flagAll==1){
					try {
						textField.setText(null);
						ModifyQuery mq = new ModifyQuery();
					    Vector<String> date_title;
						date_title = mq.modifyQuery("select date, title from history where title like ? order by month(date), day(date)", "", null, null);
						DmL.setListData(date_title);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				else{
					try {
						ModifyQuery mq = new ModifyQuery();
					    Vector<String> date_title;
						date_title = mq.modifyQuery("select date, title from history where title like ? order by month(date), day(date)", searchVal, null, null);
						DmL.setListData(date_title);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			}
		});
		button_1.setBounds(216, 260, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("���");
		button_2.setBounds(325, 260, 97, 23);
		contentPane.add(button_2);
		
		JButton btnNewButton = new JButton("all");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textField.setText(null);
					ModifyQuery mq = new ModifyQuery();
				    Vector<String> date_title;
					date_title = mq.modifyQuery("select date, title from history where title like ? order by month(date), day(date)", "", null, null);
					DmL.setListData(date_title);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				flagAll=1;
			}
		});
		btnNewButton.setBounds(46, 87, 53, 23);
		contentPane.add(btnNewButton);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
        	         public void run() {
        	            try {
        	            	dispose();
        	            } catch (Exception e) {
        	               e.printStackTrace();
        	            }
        	         }
        	      });
			}
		});
	}

}
