package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Change_man extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		textField.setColumns(10);
		textField.setBounds(58, 10, 255, 24);
		contentPane.add(textField);
		
		JLabel label = new JLabel("검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 9, 53, 24);
		contentPane.add(label);
		
		JButton button = new JButton("확인");
		button.setBounds(325, 10, 97, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("목록");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 44, 53, 25);
		contentPane.add(label_1);
		
		JList CmL = new JList();
		CmL.setBounds(22, 65, 400, 81);
		contentPane.add(CmL);
		
		JLabel label_2 = new JLabel("내용");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 156, 57, 15);
		contentPane.add(label_2);
		
		
		JTextArea CmT = new JTextArea();
		CmT.setBounds(22, 171, 400, 89);
		contentPane.add(CmT);
		
		JButton button_1 = new JButton("수정");
		button_1.setBounds(216, 270, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("취소");
		button_2.setBounds(325, 270, 97, 23);
		contentPane.add(button_2);
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
