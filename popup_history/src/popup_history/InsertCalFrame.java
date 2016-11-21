package popup_history;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.text.ParseException;

public class Insert_user extends JFrame {

	private JPanel contentPane;
	private JTextArea IuT;

	public Insert_user() {
		setTitle("일정 추가");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Insert_user.class.getResource("/images/tray.jpg")));


		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 283);
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
		comboBox.setFont(new Font("양재본목각체M", Font.BOLD, 12));
		comboBox.setBounds(78, 27, 87, 30);
		contentPane.add(comboBox);
		comboBox.setSelectedIndex(0);
	      
	    String wal[]={"월", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
   		JComboBox comboBox_1 = new JComboBox(wal);
   		comboBox_1.setFont(new Font("양재본목각체M", Font.BOLD, 12));
   		comboBox_1.setBounds(177, 27, 87, 30);
   		contentPane.add(comboBox_1);
   		comboBox_1.setSelectedIndex(0);
	      
		String date[]={"일","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setFont(new Font("양재본목각체M", Font.BOLD, 12));
		comboBox_2.setBounds(276, 27, 87, 30);
		contentPane.add(comboBox_2);
		
		JScrollPane JSP= new JScrollPane();
		JSP.setBounds(78, 67, 285, 130);
		contentPane.add(JSP);
		
		IuT = new JTextArea();
		IuT.setLineWrap(true);
		IuT.setColumns(10);
		JSP.setViewportView(IuT);
		
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(266, 209, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
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
		
		
		JButton btnNewButton_1 = new JButton("추가");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	   			InsertCal ic = new InsertCal();
	   			ic.Insertcal(IuT, comboBox, comboBox_1, comboBox_2);
			}
		});
		btnNewButton_1.setBounds(153, 209, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("날짜");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 26, 58, 31);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("내용");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 116, 58, 30);
		contentPane.add(label_2);
		
		
	}
}
