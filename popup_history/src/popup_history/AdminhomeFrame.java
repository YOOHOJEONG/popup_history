package popup_history;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminhomeFrame extends AdminLoginFrame {
	AdminhomeFrame insert = new InsertHistoryFrame();
	AdminhomeFrame modify = new ModifyHistoryFrame();
	AdminhomeFrame delete = new DeleteHistoryFrame();

	private JPanel contentPane;

	//������ Ȩ ȭ���� UI�� ���
	public AdminhomeFrame() {
		setTitle("������ Ȩ ȭ��");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 144);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("History DB ����");
		label.setFont(new Font("����", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(89, 20, 145, 24);
		contentPane.add(label);
		
		//�߰� ��ư Ŭ���� ���� �߰� �������� Ŵ
		JButton MhIn = new JButton("�߰�");
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
		//���� ��ư Ŭ���� ���� ���� �������� Ŵ
		JButton MhCh = new JButton("����");
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
		//���� ��ư Ŭ���� ���� ���� �������� Ŵ
		JButton MhDe = new JButton("����");
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
