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


public class Delete_user extends JFrame {
	int flagAll=0;
	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_user frame = new Delete_user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete_user() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("�˻�");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 9, 53, 24);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(58, 10, 255, 24);
		contentPane.add(textField);
		
		JList DuL = new JList();
		DuL.setBounds(22, 90, 400, 125);
		contentPane.add(DuL);
		
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
		btnNewButton.setBounds(325, 10, 97, 24);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("���");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 55, 53, 25);
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
		button.setBounds(216, 229, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("���");
		button_1.setBounds(325, 229, 97, 23);
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
		button_2.setBounds(58, 55, 63, 24);
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
