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


public class Change_man extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_man frame = new Change_man();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Change_man() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(57, 10, 285, 24);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel label = new JLabel("검색");
		label.setBounds(7, 9, 53, 24);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
		
		JList CmL = new JList();
		CmL.setBounds(17, 90, 400, 81);

		JButton button = new JButton("확인");
		button.setBounds(354, 9, 63, 24);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();
	   			if("".equals(searchVal))
	   				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.WARNING_MESSAGE );
	   			else{
	   				HomeSearch hs = new HomeSearch();
	   				hs.HomeSearch(searchVal, CmL);	
	   			}
			}
		});
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("목록");
		label_1.setBounds(7, 54, 53, 25);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label_1);
		contentPane.add(CmL);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 181, 310, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);		
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 215, 310, 24);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		
		JButton button_1 = new JButton("수정");
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminSearch mm = new AdminSearch();
				mm.modifyHistory(CmL, textField_1, textField_2);
			}
		});
		button_1.setBounds(216, 270, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("취소");
		button_2.setBounds(325, 270, 97, 23);
		contentPane.add(button_2);
		
		
		
		JLabel lblTitle = new JLabel("title");
		lblTitle.setBounds(31, 185, 57, 15);
		contentPane.add(lblTitle);
		
		JLabel lblContents = new JLabel("contents");
		lblContents.setBounds(31, 219, 57, 15);
		contentPane.add(lblContents);
		
		JButton btnAll = new JButton("all");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchVal = textField.getText();
				HomeSearch hs = new HomeSearch();
   				hs.HomeSearch(searchVal, CmL);
			}
		});
		btnAll.setBounds(57, 54, 63, 24);
		contentPane.add(btnAll);
		
		
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
