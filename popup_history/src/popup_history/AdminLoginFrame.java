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
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JPasswordField pwd;
	String MID="swM", Mpwd ="swM1";

	public Login() {
		setTitle("관리자 Log-In");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/tray.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(47, 74, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Password :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(47, 125, 100, 30);
		contentPane.add(label);
		
		ID = new JTextField();
		ID.setSelectedTextColor(Color.BLACK);
		ID.setForeground(new Color(0, 0, 0));
		ID.setBounds(159, 74, 130, 30);
		contentPane.add(ID);
		ID.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setText("");
		pwd.setBounds(159, 125, 130, 30);
		contentPane.add(pwd);
		
		//버튼에 몰아놓음
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(159, 175, 130, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
       	         public void run() {
       	            try {
       	            	String Id=ID.getText();
       	            	String Pwd=pwd.getText();
       	            	if(Id.equals(MID)&&Pwd.equals(Mpwd)){
       	            		Maneger_home Mh = new Maneger_home();
       	            		Mh.setVisible(true);
       	            		dispose();
       	            	}
       	            	else{
       	            		ID.setText("");
       	            		pwd.setText("");
       	            		ExitMessage eM = new ExitMessage();
       	            		eM.showMessage("로그인 오류","아이디 혹은 비밀번호가 틀립니다.");
       	            	}
       	            } catch (Exception e) {
       	               e.printStackTrace();
       	            }
       	         }
       	      });
			}
		});
		
	}
}
