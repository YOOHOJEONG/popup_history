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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.Color;

public class Log_in extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in frame = new Log_in();
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
	public Log_in() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(47, 79, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Password :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(47, 130, 100, 30);
		contentPane.add(label);
		
		ID = new JTextField();
		ID.setForeground(new Color(255, 255, 255));
		ID.setBounds(159, 79, 130, 30);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(159, 180, 130, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		pwd = new JPasswordField();
		pwd.setText("");
		pwd.setBounds(159, 130, 130, 30);
		contentPane.add(pwd);
	}
}
