package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete_man extends JFrame {

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
		textField.setBounds(79, 10, 234, 24);
		contentPane.add(textField);
		
		JLabel label = new JLabel("�˻�");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(22, 10, 53, 24);
		contentPane.add(label);
		
		JButton button = new JButton("Ȯ��");
		button.setBounds(325, 10, 97, 24);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("���");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(22, 44, 53, 25);
		contentPane.add(label_1);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(22, 75, 400, 144);
		contentPane.add(textArea);
		
		JButton button_1 = new JButton("Ȯ��");
		button_1.setBounds(216, 225, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("���");
		button_2.setBounds(325, 225, 97, 23);
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
