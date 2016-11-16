package popup_history;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Maneger_home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maneger_home frame = new Maneger_home();
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
	public Maneger_home() {
		setTitle("\uAD00\uB9AC\uC790 \uD648\uD654\uBA74");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 10, 53, 24);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 10, 234, 24);
		contentPane.add(textField);
		
		JButton button = new JButton("확인");
		button.setBounds(315, 10, 97, 24);
		contentPane.add(button);
		
		JList MhL = new JList();
		MhL.setBounds(12, 40, 414, 110);
		contentPane.add(MhL);
		
		TextArea MhT = new TextArea();
		MhT.setBounds(12, 156, 414, 110);
		contentPane.add(MhT);
		
		JButton Mhbutton_1 = new JButton("삭제");
		Mhbutton_1.setBounds(346, 279, 80, 23);
		contentPane.add(Mhbutton_1);
		
		JButton Mhbutton_2 = new JButton("추가");
		Mhbutton_2.setBounds(162, 279, 80, 23);
		contentPane.add(Mhbutton_2);
		Mhbutton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		           	 EventQueue.invokeLater(new Runnable() {
		          	         public void run() {
		          	            try {
		          	            	Insert_man frame = new Insert_man();
		          	               frame.setVisible(true);
		          	            } catch (Exception e) {
		          	               e.printStackTrace();
		          	            }
		          	         }
		          	      });
		            }
		         });
		
		
		JButton Mhbutton_3 = new JButton("수정");
		Mhbutton_3.setBounds(254, 279, 80, 23);
		contentPane.add(Mhbutton_3);
	}
}
