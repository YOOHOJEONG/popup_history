package popup_history;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Maneger_home extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 339, 144);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("History DB 관리");
		label.setFont(new Font("돋움", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(89, 20, 145, 24);
		contentPane.add(label);
		
		JButton MhIn = new JButton("추가");
		MhIn.setBounds(12, 65, 80, 23);
		contentPane.add(MhIn);
		MhIn.addActionListener(new ActionListener() {
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
		
		JButton MhCh = new JButton("수정");
		MhCh.setBounds(122, 65, 80, 23);
		contentPane.add(MhCh);
		MhCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		         });
		
		JButton MhDe = new JButton("삭제");
		MhDe.setBounds(232, 65, 80, 23);
		contentPane.add(MhDe);
		MhDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		         });
		
	}
}
