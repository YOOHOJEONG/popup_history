package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class Insert_man extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Insert_man() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String arr[] = new String[101];
		arr[0]="楷档";
		for(int i=1; i<101; i++)
		{
			arr[i]= 2023-i+"斥";
		}
		JComboBox comboBox = new JComboBox(arr);
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("剧犁夯格阿眉M", Font.BOLD, 12));
		comboBox.setBounds(82, 50, 87, 30);
		contentPane.add(comboBox);
		
		String wal[]={"岿", "1岿", "2岿", "3岿", "4岿", "5岿", "6岿", "7岿", "8岿", "9岿", "10岿", "11岿", "12岿"};
   		JComboBox comboBox_1 = new JComboBox(wal);
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setFont(new Font("剧犁夯格阿眉M", Font.BOLD, 12));
		comboBox_1.setBounds(181, 50, 87, 30);
		contentPane.add(comboBox_1);
		
		String date[]={"老","1老","2老","3老","4老","5老","6老","7老","8老","9老","10老","11老","12老","13老","14老","15老",
				"16老","17老","18老","19老","20老","21老","22老","23老","24老","25老","26老","27老","28老","29老","30老","31老"};
		JComboBox comboBox_2 = new JComboBox(date);
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setFont(new Font("剧犁夯格阿眉M", Font.BOLD, 12));
		comboBox_2.setBounds(280, 50, 87, 30);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel = new JLabel("朝楼");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 50, 58, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("力格");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 90, 58, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("郴侩");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 130, 58, 30);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(82, 90, 281, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 130, 281, 70);
		contentPane.add(textField_1);
		
		JButton button = new JButton("犬牢");
		button.setBounds(250, 229, 80, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("秒家");
		button_1.setBounds(342, 229, 80, 23);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
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
