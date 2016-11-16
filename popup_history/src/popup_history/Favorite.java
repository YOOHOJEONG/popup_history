package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Favorite extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame5 frame = new frame5();
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
	public Favorite() {
		//EXIT_ON_CLOSE
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(10, 41, 414, 90);
		contentPane.add(textArea_1);
		
		JLabel label = new JLabel("목록");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 10, 53, 25);
		contentPane.add(label);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 137, 414, 90);
		contentPane.add(textArea);
		
		JButton button = new JButton("취소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(344, 233, 80, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("확인");
		button_1.setBounds(252, 233, 80, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("삭제");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(160, 233, 80, 23);
		contentPane.add(button_2);
	}

}
