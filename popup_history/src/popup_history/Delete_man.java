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

public class Delete_man extends JFrame {
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
					Delete_man frame = new Delete_man();
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
	public Delete_man() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(58, 10, 290, 24);
		contentPane.add(textField);
		
		JLabel label = new JLabel("�˻�");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 9, 53, 24);
		contentPane.add(label);
		
		JList DmL = new JList();
		DmL.setBounds(22, 79, 400, 136);
		contentPane.add(DmL);
		
		JButton button = new JButton("Ȯ��");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchVal = textField.getText();
	   			if("".equals(searchVal))
	   				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.WARNING_MESSAGE );
	   			else{
	   				HomeSearch hs = new HomeSearch();
	   				hs.HomeSearch(searchVal, DmL, null);	
	   			}       		
			}
		});
		button.setBounds(360, 9, 62, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("���");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 44, 53, 25);
		contentPane.add(label_1);
		
		
		JButton button_1 = new JButton("����");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminSearch dm = new AdminSearch();
				dm.deleteHistory(DmL);
				
				String searchVal = textField.getText();
				if(flagAll==1){
					HomeSearch hs = new HomeSearch();
	   				hs.HomeSearch("", DmL, null);
				}
				else{
					HomeSearch hs = new HomeSearch();
					hs.HomeSearch(searchVal, DmL, null);
				}
			}
		});
		button_1.setBounds(216, 225, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("���");
		button_2.setBounds(325, 225, 97, 23);
		contentPane.add(button_2);
		
		JButton btnNewButton = new JButton("all");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeSearch hs = new HomeSearch();
   				hs.HomeSearch("", DmL, null);
   				flagAll=1;
			}
		});
		btnNewButton.setBounds(55, 46, 53, 23);
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
