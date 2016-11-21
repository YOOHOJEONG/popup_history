package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Vector;
import java.awt.Color;
import java.awt.Toolkit;


public class DeleteCalFrame extends JFrame {
	int flagAll=0;
	
	private JPanel contentPane;
	private JTextField textField;

	
	public DeleteCalFrame() {
		setTitle("���� ����");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteCalFrame.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("�˻�");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 10, 53, 24);
		contentPane.add(label);
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(77, 44, 286, 24);
		contentPane.add(textField);
		
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(22, 113, 400, 125);
		contentPane.add(JSP);
		JList DuL = new JList();
		JSP.setViewportView(DuL);
		
		JButton btnNewButton = new JButton("Ȯ��");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flagAll=0;

				String searchVal = textField.getText();
	   			if("".equals(searchVal))
	   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.WARNING_MESSAGE );
	   			else{
	   					try {
	   						ModifyQuery mq = new ModifyQuery();
		   				    Vector<String> date_plan;
							date_plan = mq.modifyQuery("select date, plan from calender where plan like ?", searchVal, null, null);
		   					DuL.setListData(date_plan);
	   					} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	   			} 
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(370, 44, 62, 24);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("���");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 78, 53, 25);
		contentPane.add(label_1);
	
		
		JButton button = new JButton("����");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();
				if(DuL.getSelectedValue()==null){
					if("".equals(searchVal))
		   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.WARNING_MESSAGE );
					else
						JOptionPane.showMessageDialog(null, "���� �� �����͸� �����ϼ���.","", JOptionPane.WARNING_MESSAGE );
				}
				else{
					DeleteCal dc  = new DeleteCal();
					dc.DeleteCal(DuL);
					if(flagAll==1){
						try {
	   						ModifyQuery mq = new ModifyQuery();
		   				    Vector<String> date_plan;
							date_plan = mq.modifyQuery("select date, plan from calender where plan like ?", "", null, null);
		   					DuL.setListData(date_plan);						
	   					} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						try {
	   						ModifyQuery mq = new ModifyQuery();
		   				    Vector<String> date_plan;
							date_plan = mq.modifyQuery("select date, plan from calender where plan like ?", searchVal, null, null);
		   					DuL.setListData(date_plan);
	   					} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		button.setBounds(216, 252, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("���");
		button_1.setBounds(325, 252, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("all");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textField.setText(null);
					ModifyQuery mq = new ModifyQuery();
				    Vector<String> date_title;
					date_title = mq.modifyQuery("select date, plan from calender where plan like ?", "", null, null);
					DuL.setListData(date_title);
					flagAll=1;
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(58, 78, 63, 24);
		contentPane.add(button_2);
		button_1.addActionListener(new ActionListener() {
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
