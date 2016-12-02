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

	static int set=0;
	
	//일정 삭제 UI와 기능
	public DeleteCalFrame() {
		setTitle("일정 삭제");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteCalFrame.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 463, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 10, 53, 24);
		contentPane.add(label);
		
		
		String arr[] = new String[101];
		arr[0]="년도";
		for(int i=1; i<101; i++)
		{
			arr[i] = String.valueOf(2023-i);
		}		
		JComboBox comboBox = new JComboBox(arr);
		comboBox.setBounds(58, 10, 86, 24);
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		String wal[]={"월", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox comboBox_1 = new JComboBox(wal);
		comboBox_1.setBounds(156, 10, 86, 24);
		comboBox_1.setSelectedIndex(0);
		contentPane.add(comboBox_1);
		
		String date[]={"일","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setBounds(258, 10, 86, 24);
		comboBox_2.setSelectedIndex(0);
		contentPane.add(comboBox_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(58, 44, 286, 24);
		contentPane.add(textField);
		
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(22, 127, 400, 111);
		contentPane.add(JSP);
		JList DuL = new JList();
		JSP.setViewportView(DuL);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flagAll=0;

				String searchVal = textField.getText();
				//입력된 날짜로 검색해서 리스트에 출력
 				if(((comboBox.getSelectedIndex()>0)&&(comboBox_1.getSelectedIndex()>0)&&(comboBox_2.getSelectedIndex()>0))
 						&&(!"".equals(searchVal))){
 					try{
 						ModifyQuery mq=new ModifyQuery();
 						Vector<String> date_plan;
 						String searchDate = comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString();
 						date_plan=mq.modifyQuery("select date, plan from calender where plan like ? and date like ? order by date, plan", searchVal, searchDate,null );
 						DuL.setListData(date_plan);
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
	 					DuL.setListData(date_plan);

 					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 				}
 				//입력한 텍스트로 검색해서 리스트에 출력
 				else if(!"".equals(searchVal)){
 					try {
 						ModifyQuery mq = new ModifyQuery();
 	 					Vector<String> date_plan;
						date_plan = mq.modifyQuery("select date, plan from calender where plan like ? order by date, plan", searchVal, null, null);
	 					DuL.setListData(date_plan);
 					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 				}
 				else
 	   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.ERROR_MESSAGE );
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(360, 43, 62, 24);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("목록");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 92, 53, 25);
		contentPane.add(label_1);
	
		//버튼을 클릭시 선택된 일정을 삭제
		JButton button = new JButton("삭제");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();
				if(DuL.getSelectedValue()==null){
					if("".equals(searchVal))
		   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.ERROR_MESSAGE );
					else
						JOptionPane.showMessageDialog(null, "삭제 할 데이터를 선택하세요.","", JOptionPane.ERROR_MESSAGE );
				}
				else{
					DeleteCal dc  = new DeleteCal();
					set=1;
					dc.DeleteCal(DuL);	//선택한 일정 삭제
					
					//일정 리스트 새로고침
					if(flagAll==1){
						try {
	   						ModifyQuery mq = new ModifyQuery();
		   				    Vector<String> date_plan;
							date_plan = mq.modifyQuery("select date, plan from calender where plan like ? order by date", "", null, null);
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
							date_plan = mq.modifyQuery("select date, plan from calender where plan like ? order by date", searchVal, null, null);
		   					DuL.setListData(date_plan);
	   					} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					set=0;
				}
			}
		});
		button.setBounds(216, 252, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("취소");
		button_1.setBounds(325, 252, 97, 23);
		contentPane.add(button_1);
		
		//일정 테이블의 목록을 모두 불러와서 리스트로 출력
		JButton button_2 = new JButton("all");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textField.setText(null);
					ModifyQuery mq = new ModifyQuery();
				    Vector<String> date_title;
					date_title = mq.modifyQuery("select date, plan from calender where plan like ? order by date", "", null, null);
					DuL.setListData(date_title);
					flagAll=1;
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(58, 93, 63, 24);
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
