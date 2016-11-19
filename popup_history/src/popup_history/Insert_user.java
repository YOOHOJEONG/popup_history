package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class Insert_user extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_user frame = new Insert_user();
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
	public Insert_user() {


		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 67, 285, 130);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(325, 209, 97, 23);
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
	   			ic.Insertcal(textField_1, comboBox, comboBox_1, comboBox_2);
			}
		});
		btnNewButton_1.setBounds(216, 209, 97, 23);
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
