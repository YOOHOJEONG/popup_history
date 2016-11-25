package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.Toolkit;


public class ModifyHistoryFrame extends JFrame {
	int flagAll=0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;


	public ModifyHistoryFrame() {
		setTitle("History DB ����");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModifyHistoryFrame.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(62, 44, 286, 24);
		textField.setColumns(10);
		contentPane.add(textField);
		
		String wal[]={"��", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_1 = new JComboBox(wal);
		comboBox_1.setBounds(62, 10, 86, 24);
		comboBox_1.setSelectedIndex(0);
		contentPane.add(comboBox_1);
		
		String date[]={"��","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setBounds(161, 10, 86, 24);
		comboBox_2.setSelectedIndex(0);
		contentPane.add(comboBox_2);
		
		JLabel label_2 = new JLabel("�˻�");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 10, 53, 24);
		contentPane.add(label_2);
		
		
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(22, 120, 400, 52);
		contentPane.add(JSP);
		
		JList CmL = new JList();
		CmL.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try {
						String str = (String)CmL.getSelectedValue();
						StringTokenizer tokens = new StringTokenizer(str);
						String date = tokens.nextToken("��");//������
						String title = tokens.nextToken("��");
						
						ModifyQuery mq1 = new ModifyQuery();
						Vector<String> field_title = mq1.modifyQuery("select title from history where date=? and title=?", date, title, null);
						Vector<String> area_contents = mq1.modifyQuery("select contents from history where date=? and title=?", date, title, null);
						String text1 = (String)field_title.get(0);
						String text = (String)area_contents.get(0);      	       

						textField_1.setText(text1);
						textArea.setText(text);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		JSP.setViewportView(CmL);
		

		JButton button = new JButton("Ȯ��");
  		button.setBounds(360, 43, 63, 24);
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
 						CmL.setListData(date_title);
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
	 					CmL.setListData(date_title);

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
	 					CmL.setListData(date_title);
 					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 				}
 				else
 	   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );
 			}
 		});
 		contentPane.add(button);
		
		JLabel label_1 = new JLabel("���");
		label_1.setBounds(12, 85, 53, 25);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 205, 360, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);		
		
		JScrollPane JSP2= new JScrollPane();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		JSP2.setBounds(62, 239, 360, 45);
		textArea.setColumns(10);
		JSP2.setViewportView(textArea);
		contentPane.add(JSP2);
		
		
		JButton button_1 = new JButton("����");
 		
 		button_1.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				String searchVal = textField.getText();
 
 				if(CmL.getSelectedValue()==null){
 					if("".equals(searchVal))
 		   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );
 					else
 						JOptionPane.showMessageDialog(null, "���� �� �����͸� �����ϼ���.","", JOptionPane.ERROR_MESSAGE );
 				}
 				else{
 					AdminSearch mm = new AdminSearch();
 					mm.modifyHistory(CmL, textField_1, textArea);
 					if(flagAll==1){
 						try {
 							textField.setText(null);
 							textField_1.setText(null);
 							textArea.setText(null);
 							ModifyQuery mq = new ModifyQuery();
 						    Vector<String> date_title;
 							date_title = mq.modifyQuery("select date, title from history where title like ? order by month(date), day(date)", "", null, null);
 							CmL.setListData(date_title);
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
 							CmL.setListData(date_title);
 						} catch (ParseException e1) {
 							// TODO Auto-generated catch block
 							e1.printStackTrace();
 						}
 					}
 				}
 					
 			}
 		});
 		button_1.setBounds(221, 294, 97, 23);
 		contentPane.add(button_1);
		
		JButton button_2 = new JButton("���");
		button_2.setBounds(330, 294, 97, 23);
		contentPane.add(button_2);
		
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
		
		
		
		JLabel lblTitle = new JLabel("����");
		lblTitle.setBounds(22, 209, 57, 15);
		contentPane.add(lblTitle);
		
		JLabel lblContents = new JLabel("����");
		lblContents.setBounds(22, 244, 57, 15);
		contentPane.add(lblContents);
		
		JButton btnAll = new JButton("all");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(null);
					textField_1.setText(null);
					textArea.setText(null);
					ModifyQuery mq = new ModifyQuery();
				    Vector<String> date_title;
					date_title = mq.modifyQuery("select date, title from history where title like ? order by month(date), day(date)", "", null, null);
					CmL.setListData(date_title);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flagAll=1;
			}
		});
		btnAll.setBounds(62, 85, 63, 24);
		contentPane.add(btnAll);
		
		
	}
}
