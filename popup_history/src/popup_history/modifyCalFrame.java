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
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class modifyCalFrame extends JFrame {
	int flagAll=0;
	private JPanel contentPane;
	private JTextField textField;
	static int set=0;

	//일정 수정의 UI와 기능
	public modifyCalFrame() {
		setTitle("일정 수정");
		setIconImage(Toolkit.getDefaultToolkit().getImage(modifyCalFrame.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		Years year = null;		
		JComboBox comboBox = new JComboBox();
		year = new NextYear();
		year.Year(comboBox);
		comboBox.setBounds(44, 10, 86, 24);
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		String wal[]={"월", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_1 = new JComboBox(wal);
		comboBox_1.setBounds(139, 10, 86, 24);
		comboBox_1.setSelectedIndex(0);
		contentPane.add(comboBox_1);
		
		String date[]={"일","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setBounds(237, 10, 86, 24);
		comboBox_2.setSelectedIndex(0);
		contentPane.add(comboBox_2);
		
		
		JScrollPane JSP1= new JScrollPane();
		JTextArea CuT = new JTextArea();
		CuT.setLineWrap(true);
		JSP1.setBounds(44, 207, 388, 51);
		JSP1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		contentPane.add(JSP1);
		
		JSP1.setViewportView(CuT);
		
		JLabel label = new JLabel("검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(-3, 10, 53, 24);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(44, 38, 308, 24);
		contentPane.add(textField);
				
		JScrollPane JSP2= new JScrollPane();
		JSP2.setBounds(12, 109, 420, 88);
		contentPane.add(JSP2);
				
		JList CuL = new JList();
		CuL.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					String str = (String)CuL.getSelectedValue();
					StringTokenizer tokens = new StringTokenizer(str);
					String date = tokens.nextToken("▶");//구분자
					String plan = tokens.nextToken("▶");
					
					ModifyQuery mq1 = new ModifyQuery();
					Vector<String> area_plan = mq1.modifyQuery("select plan from calender where date=? and plan=?", date, plan, null);
					String text = (String)area_plan.get(0);
					CuT.setText(text);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		JSP2.setViewportView(CuL);
				
				
		JButton button = new JButton("확인");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flagAll=0;

				String searchVal = textField.getText();
				//입력한 날짜로 일정을 검색하여 리스트에 출력
 				if(((comboBox.getSelectedIndex()>0)&&(comboBox_1.getSelectedIndex()>0)&&(comboBox_2.getSelectedIndex()>0))
 						&&(!"".equals(searchVal))){
 					try{
 						ModifyQuery mq=new ModifyQuery();
 						Vector<String> date_plan;
 						String searchDate = comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString();
 						date_plan=mq.modifyQuery("select date, plan from calender where plan like ? and date like ? order by date, plan", searchVal, searchDate,null );
 						CuL.setListData(date_plan);
 					}catch(ParseException e1){
 						e1.printStackTrace();
 					}
 					
 				}
 				else if((comboBox.getSelectedIndex()>0)&&(comboBox_1.getSelectedIndex()>0)&&(comboBox_2.getSelectedIndex()>0)){
 					try {
 						ModifyQuery mq = new ModifyQuery();
 	 					Vector<String> date_plan;
 						String searchDate = comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString();
						date_plan=mq.modifyQuery("select date, plan from calender where date like ? order by date, plan", searchDate, null, null);
	 					CuL.setListData(date_plan);

 					} catch (ParseException e1) {
						e1.printStackTrace();
					}
 				}
 				//입력한 text로 일정을 검색하여 리스트에 출력
 				else if(!"".equals(searchVal)){
 					try {
 						ModifyQuery mq = new ModifyQuery();
 	 					Vector<String> date_plan;
						date_plan = mq.modifyQuery("select date, plan from calender where plan like ? order by date, plan", searchVal, null, null);
	 					CuL.setListData(date_plan);
 					} catch (ParseException e1) {
						e1.printStackTrace();
					}
 				}
 				else
 	   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.ERROR_MESSAGE );
			}
		});
		button.setBounds(370, 37, 62, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("목록");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(-3, 72, 53, 25);
		contentPane.add(label_1);		
		
		JLabel lblPlan = new JLabel("일정");
		lblPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlan.setBounds(-3, 207, 57, 15);
		contentPane.add(lblPlan);
		
		JButton button_1 = new JButton("수정");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();
				
				if(CuL.getSelectedValue()==null){
					if("".equals(searchVal))
		   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.ERROR_MESSAGE );
					else
						JOptionPane.showMessageDialog(null, "수정 할 데이터를 선택하세요.","", JOptionPane.ERROR_MESSAGE );
				}
				else{
					ModifyCal dc = new ModifyCal();
					set=1;
					dc.modifyCal(CuL, CuT);	//입력한 text로 일정 테이블의 내용을 수정
					
					//버튼 클릭시 출력되는 리스트를 새로고침
					if(flagAll==1){						
						try {
							textField.setText(null);
 							CuT.setText(null);
							ModifyQuery mq = new ModifyQuery();
							Vector<String> date_plan;
							date_plan = mq.modifyQuery("select date, plan from calender where plan like ? order by date", "", null, null);
							set=0;
							CuL.setListData(date_plan);
						} catch (ParseException e1) {
							e1.printStackTrace();
							set=0;
						}
						
					}
					else{						
						try {
							ModifyQuery mq = new ModifyQuery();
							Vector<String> date_plan;
							date_plan = mq.modifyQuery("select date, plan from calender where plan like ? order by date", searchVal, null, null);
							set=0;
							CuL.setListData(date_plan);
						} catch (ParseException e1) {
							e1.printStackTrace();
							set=0;
						}
						
					}
					
				}
				set=0;
			}
		});
		button_1.setBounds(226, 268, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("취소");
		button_2.setBounds(335, 268, 97, 23);
		contentPane.add(button_2);
		
		//일정 테이블에 있는 모든 목록을 불러와서 리스트에 출력
		JButton button_3 = new JButton("all");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textField.setText(null);
						CuT.setText(null);
					ModifyQuery mq = new ModifyQuery();
				    Vector<String> date_title;
					date_title = mq.modifyQuery("select date, plan from calender where plan like ? order by date", "", null, null);
					CuL.setListData(date_title);
					flagAll=1;
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(44, 72, 63, 24);
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
