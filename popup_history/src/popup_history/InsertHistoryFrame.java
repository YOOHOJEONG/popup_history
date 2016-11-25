package popup_history;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertHistoryFrame extends JFrame {

   private JPanel contentPane;
   private JTextField ImT_1;
   private JTextArea ImT_2;

   public InsertHistoryFrame() {
   	setTitle("History DB �߰�");
   	setIconImage(Toolkit.getDefaultToolkit().getImage(InsertHistoryFrame.class.getResource("/images/tray.jpg")));

      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 411, 272);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      String arr[] = new String[101];
      arr[0]="����";
      for(int i=1; i<101; i++)
      {
         arr[i]= String.valueOf(2023-i);
      }
      JComboBox comboBox = new JComboBox(arr);
      comboBox.setSelectedIndex(0);
      comboBox.setFont(new Font("���纻��üM", Font.BOLD, 12));
      comboBox.setBounds(82, 30, 87, 30);
      contentPane.add(comboBox);
      
      String wal[]={"��", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
         JComboBox comboBox_1 = new JComboBox(wal);
      comboBox_1.setSelectedIndex(0);
      comboBox_1.setFont(new Font("���纻��üM", Font.BOLD, 12));
      comboBox_1.setBounds(181, 30, 87, 30);
      contentPane.add(comboBox_1);
      
      String date[]={"��","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
            "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
      JComboBox comboBox_2 = new JComboBox(date);
      comboBox_2.setSelectedIndex(0);
      comboBox_2.setFont(new Font("���纻��üM", Font.BOLD, 12));
      comboBox_2.setBounds(280, 30, 87, 30);
      contentPane.add(comboBox_2);
      
      JLabel lblNewLabel = new JLabel("��¥");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(12, 30, 58, 30);
      contentPane.add(lblNewLabel);
      
      JLabel label = new JLabel("����");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setBounds(12, 70, 58, 30);
      contentPane.add(label);
      
      JLabel label_1 = new JLabel("����");
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      label_1.setBounds(12, 110, 58, 30);
      contentPane.add(label_1);
      
      ImT_1 = new JTextField();
      ImT_1.setBounds(82, 70, 281, 30);
      contentPane.add(ImT_1);
      ImT_1.setColumns(10);
      
      JScrollPane JSP= new JScrollPane();
      JSP.setBounds(82, 110, 281, 70);
      contentPane.add(JSP);
      
      ImT_2 = new JTextArea();
      ImT_2.setLineWrap(true);
      ImT_2.setColumns(10);
      JSP.setViewportView(ImT_2);
      
      
      JButton button = new JButton("�߰�");
      button.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
   			String title = ImT_1.getText();
   			String contents = ImT_2.getText();
   			if(comboBox.getSelectedIndex()==0||comboBox_1.getSelectedIndex()==0||comboBox_2.getSelectedIndex()==0)
   				JOptionPane.showMessageDialog(null, "��¥�� �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );
   			else if("".equals(title))
   				JOptionPane.showMessageDialog(null, "������ �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );
   			else if("".equals(contents))
   				JOptionPane.showMessageDialog(null, "������ �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );   					
   			else{
   				String date = comboBox.getSelectedItem().toString()+"-"+comboBox_1.getSelectedItem().toString()+"-"+comboBox_2.getSelectedItem().toString();

   				ModifyQuery mq = new ModifyQuery();
				try {
					mq.modifyQuery("insert ignore into history values(?, ?, ?);", date, title, contents);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
   				JOptionPane.showMessageDialog(null, "�Է� �Ϸ�","", JOptionPane.INFORMATION_MESSAGE);   					
   			}
   				
      	}
      });
      button.setBounds(195, 192, 80, 23);
      contentPane.add(button);
      
      JButton button_1 = new JButton("���");
      button_1.setBounds(287, 192, 80, 23);
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