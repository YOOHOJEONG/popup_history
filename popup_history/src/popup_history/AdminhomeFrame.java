package popup_history;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminhomeFrame extends AdminLoginFrame {

	private JPanel contentPane;

	//관리자 홈 화면의 UI와 기능
	public AdminhomeFrame() {
		setTitle("관리자 홈 화면");
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
		
		//추가 버튼 클릭시 역사 추가 프레임을 킴
		JButton MhIn = new JButton("추가");
		MhIn.setBounds(12, 65, 80, 23);
		contentPane.add(MhIn);
		MhIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		           	 EventQueue.invokeLater(new Runnable() {
		          	         public void run() {
		          	            try {
		          	            	InsertHistoryFrame frame = new InsertHistoryFrame();
		          	               frame.setVisible(true);
		          	            } catch (Exception e) {
		          	               e.printStackTrace();
		          	            }
		          	         }
		          	      });
		            }
		         });
		//수정 버튼 클릭시 역사 수정 프레임을 킴
		JButton MhCh = new JButton("수정");
		MhCh.setBounds(122, 65, 80, 23);
		contentPane.add(MhCh);
		MhCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		           	 EventQueue.invokeLater(new Runnable() {
		          	         public void run() {
		          	            try {
		          	            	ModifyHistoryFrame frame = new ModifyHistoryFrame();
		          	               frame.setVisible(true);
		          	            } catch (Exception e) {
		          	               e.printStackTrace();
		          	            }
		          	         }
		          	      });
		            }
		         });
		//삭제 버튼 클릭시 역사 삭제 프레임을 킴
		JButton MhDe = new JButton("삭제");
		MhDe.setBounds(232, 65, 80, 23);
		contentPane.add(MhDe);
		MhDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		           	 EventQueue.invokeLater(new Runnable() {
		          	         public void run() {
		          	            try {
		          	            	DeleteHistoryFrame frame = new DeleteHistoryFrame();
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
