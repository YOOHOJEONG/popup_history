package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Change_user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_user frame = new Change_user();
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
	public Change_user() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("검색");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 9, 53, 24);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(58, 10, 255, 24);
		contentPane.add(textField);
		
		JButton button = new JButton("확인");
		button.setBounds(325, 10, 97, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("목록");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(7, 34, 53, 25);
		contentPane.add(label_1);
		
		String[] Con ={"a","d","c","d","e","f","g","h","i","j"};
		JList CuL = new JList();
		//CuL.setBounds(17, 55, 400, 75);
		CuL.setListData(Con);
		JScrollPane JSP= new JScrollPane(CuL);
		JSP.setBounds(17, 55, 400, 75);
		//contentPane.add(CuL);
		contentPane.add(JSP);
		
		JLabel label_2 = new JLabel("수정용");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(7, 132, 57, 15);
		contentPane.add(label_2);
		
		JTextArea CuT = new JTextArea();
		CuT.setBounds(17, 150, 400, 85);
		contentPane.add(CuT);
		
		JButton button_1 = new JButton("수정");
		button_1.setBounds(216, 245, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("취소");
		button_2.setBounds(325, 245, 97, 23);
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
