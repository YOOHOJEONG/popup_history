package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextArea;
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
		
		TextArea textArea = new TextArea();
		textArea.setBounds(12, 40, 414, 110);
		contentPane.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(12, 156, 414, 110);
		contentPane.add(textArea_1);
		
		JButton button_1 = new JButton("삭제");
		button_1.setBounds(254, 279, 80, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("확인");
		button_2.setBounds(346, 279, 80, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("추가");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(70, 279, 80, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("수정");
		button_4.setBounds(162, 279, 80, 23);
		contentPane.add(button_4);
	}
}
