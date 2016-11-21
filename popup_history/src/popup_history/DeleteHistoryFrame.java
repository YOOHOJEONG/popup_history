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
		setTitle("History DB 삭제");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteHistoryFrame.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String arr[] = new String[101];
		arr[0]="년도";
		for(int i=1; i<101; i++)
		{
			arr[i] = String.valueOf(2023-i);
		}		
		JComboBox comboBox = new JComboBox(arr);
		comboBox.setBounds(77, 10, 86, 24);
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		String wal[]={"월", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		JComboBox comboBox_1 = new JComboBox(wal);
		comboBox_1.setBounds(177, 10, 86, 24);
		comboBox_1.setSelectedIndex(0);
		contentPane.add(comboBox_1);
		
		String date[]={"일","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setBounds(277, 10, 86, 24);
		comboBox_2.setSelectedIndex(0);
		contentPane.add(comboBox_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(77, 44, 286, 24);
		contentPane.add(textField);
		
		JLabel label = new JLabel("검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 10, 53, 24);
		contentPane.add(label);
		
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(22, 114, 400, 136);
		contentPane.add(JSP);
		
		JList DmL = new JList();
		JSP.setViewportView(DmL);
		
		JButton button = new JButton("확인");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flagAll=0;

				String searchVal = textField.getText();
	   			if("".equals(searchVal))
	   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.WARNING_MESSAGE );
	   			else{
	   				//HomeSearch hs = new HomeSearch();
	   				//hs.HomeSearch(searchVal, DmL);
	   				try {
						ModifyQuery mq = new ModifyQuery();
					    Vector<String> date_title;
						date_title = mq.modifyQuery("select date, title from history where title like ?", searchVal, null, null);
						DmL.setListData(date_title);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	   			}       		
			}
		});
		button.setBounds(370, 44, 62, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("목록");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 79, 53, 25);
		contentPane.add(label_1);
		
		
		JButton button_1 = new JButton("삭제");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();

				if(DmL.getSelectedValue()==null){
					if("".equals(searchVal))
		   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.WARNING_MESSAGE );
					else
						JOptionPane.showMessageDialog(null, "삭제 할 데이터를 선택하세요.","", JOptionPane.WARNING_MESSAGE );
				}
				else{
				AdminSearch dm = new AdminSearch();
				dm.deleteHistory(DmL);
				
				if(flagAll==1){
					try {
						textField.setText(null);
						ModifyQuery mq = new ModifyQuery();
					    Vector<String> date_title;
						date_title = mq.modifyQuery("select date, title from history where title like ?", "", null, null);
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
						date_title = mq.modifyQuery("select date, title from history where title like ?", searchVal, null, null);
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
		
		JButton button_2 = new JButton("취소");
		button_2.setBounds(325, 260, 97, 23);
		contentPane.add(button_2);
		
		JButton btnNewButton = new JButton("all");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textField.setText(null);
					ModifyQuery mq = new ModifyQuery();
				    Vector<String> date_title;
					date_title = mq.modifyQuery("select date, title from history where title like ?", "", null, null);
					DmL.setListData(date_title);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				flagAll=1;
			}
		});
		btnNewButton.setBounds(58, 81, 53, 23);
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
