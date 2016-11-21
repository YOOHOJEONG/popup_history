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


public class Change_man extends JFrame {
	int flagAll=0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textField_2;


	public Change_man() {
		setTitle("History DB ����");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Change_man.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(77, 44, 286, 24);
		textField.setColumns(10);
		contentPane.add(textField);
		
		String arr[] = new String[101];
		arr[0]="�⵵";
		for(int i=1; i<101; i++)
		{
			arr[i] = String.valueOf(2023-i);
		}		
		JComboBox comboBox = new JComboBox(arr);
		comboBox.setBounds(77, 10, 86, 24);
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		String wal[]={"��", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		JComboBox comboBox_1 = new JComboBox(wal);
		comboBox_1.setBounds(177, 10, 86, 24);
		comboBox_1.setSelectedIndex(0);
		contentPane.add(comboBox_1);
		
		String date[]={"��","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setBounds(277, 10, 86, 24);
		comboBox_2.setSelectedIndex(0);
		contentPane.add(comboBox_2);
		
		JLabel label_2 = new JLabel("�˻�");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 10, 53, 24);
		contentPane.add(label_2);
		
		
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(22, 114, 400, 81);
		contentPane.add(JSP);
		
		JList CmL = new JList();
		JSP.setViewportView(CmL);
		

		JButton button = new JButton("Ȯ��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(370, 44, 62, 24);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flagAll=0;

				String searchVal = textField.getText();
	   			if("".equals(searchVal))
	   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.WARNING_MESSAGE );
	   			else{
	   				//HomeSearch hs = new HomeSearch();
	   				//hs.HomeSearch(searchVal, CmL);
	   				try {
						ModifyQuery mq = new ModifyQuery();
					    Vector<String> date_title;
						date_title = mq.modifyQuery("select date, title from history where title like ?", searchVal, null, null);
						CmL.setListData(date_title);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	   			}
			}
		});
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("���");
		label_1.setBounds(12, 78, 53, 25);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 205, 317, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);		
		
		JScrollPane JSP2= new JScrollPane();
		textField_2 = new JTextArea();
		textField_2.setLineWrap(true);
		JSP2.setBounds(105, 239, 317, 45);
		textField_2.setColumns(10);
		JSP2.setViewportView(textField_2);
		contentPane.add(JSP2);
		
		
		JButton button_1 = new JButton("����");
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String searchVal = textField.getText();

				if(CmL.getSelectedValue()==null){
					if("".equals(searchVal))
		   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.WARNING_MESSAGE );
					else
						JOptionPane.showMessageDialog(null, "���� �� �����͸� �����ϼ���.","", JOptionPane.WARNING_MESSAGE );
				}
				else{
					AdminSearch mm = new AdminSearch();
					mm.modifyHistory(CmL, textField_1, textField_2);
					if(flagAll==1){
						try {
							textField.setText(null);
							ModifyQuery mq = new ModifyQuery();
						    Vector<String> date_title;
							date_title = mq.modifyQuery("select date, title from history where title like ?", "", null, null);
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
							date_title = mq.modifyQuery("select date, title from history where title like ?", searchVal, null, null);
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
		
		
		
		JLabel lblTitle = new JLabel("title");
		lblTitle.setBounds(36, 209, 57, 15);
		contentPane.add(lblTitle);
		
		JLabel lblContents = new JLabel("contents");
		lblContents.setBounds(36, 243, 57, 15);
		contentPane.add(lblContents);
		
		JButton btnAll = new JButton("all");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(null);
					ModifyQuery mq = new ModifyQuery();
				    Vector<String> date_title;
					date_title = mq.modifyQuery("select date, title from history where title like ?", "", null, null);
					CmL.setListData(date_title);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flagAll=1;
			}
		});
		btnAll.setBounds(62, 78, 63, 24);
		contentPane.add(btnAll);
		
		
	}
}
