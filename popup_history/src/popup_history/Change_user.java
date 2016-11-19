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
import java.util.Vector;

public class Change_user extends JFrame {
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
					Change_user frame = new Change_user();
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
	public Change_user() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 9, 53, 24);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(58, 10, 255, 24);
		contentPane.add(textField);
				
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(22, 90, 400, 79);
		contentPane.add(JSP);
				
		JList CuL = new JList();
		JSP.setViewportView(CuL);
				
				
		JButton button = new JButton("확인");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();
	   			if("".equals(searchVal))
	   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.WARNING_MESSAGE );
	   			else{
	   				try {
   						ModifyQuery mq = new ModifyQuery();
	   				    Vector<String> date_plan;
						date_plan = mq.modifyQuery("select date, plan from calender where plan like ?", searchVal, null, null);
	   					CuL.setListData(date_plan);
   					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
	   			}
			}
		});
		button.setBounds(325, 10, 97, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("목록");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 55, 53, 25);
		contentPane.add(label_1);		
		
		JLabel lblPlan = new JLabel("plan");
		lblPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlan.setBounds(8, 188, 57, 15);
		contentPane.add(lblPlan);
		
		JTextArea CuT = new JTextArea();
		CuT.setBounds(58, 184, 364, 24);
		contentPane.add(CuT);
		
		JButton button_1 = new JButton("수정");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModifyCal dc = new ModifyCal();
				dc.modifyCal(CuL, CuT);
				
				String searchVal = textField.getText();
				if(flagAll==1){
					try {
   						ModifyQuery mq = new ModifyQuery();
	   				    Vector<String> date_plan;
						date_plan = mq.modifyQuery("select date, plan from calender where plan like ?", "", null, null);
	   					CuL.setListData(date_plan);
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
	   					CuL.setListData(date_plan);
   					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_1.setBounds(216, 245, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("취소");
		button_2.setBounds(325, 245, 97, 23);
		contentPane.add(button_2);
				
				JButton button_3 = new JButton("all");
				button_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							ModifyQuery mq = new ModifyQuery();
						    Vector<String> date_title;
							date_title = mq.modifyQuery("select date, plan from calender where plan like ?", "", null, null);
							CuL.setListData(date_title);
							flagAll=1;
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				button_3.setBounds(58, 56, 63, 24);
				contentPane.add(button_3);
						
						
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
