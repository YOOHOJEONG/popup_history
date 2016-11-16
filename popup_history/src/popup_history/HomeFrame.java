package popup_history;
 import java.awt.BorderLayout;
 import java.awt.EventQueue;
 import java.awt.FlowLayout;
 import java.awt.event.ActionListener;
 import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
 import java.awt.TextArea;
 import java.awt.Panel;
 import java.awt.Canvas;
 import java.awt.Label;
 import java.awt.TextField;
 import java.awt.ScrollPane;
 import java.awt.Button;
 import java.awt.Color;
 import java.awt.Font;
 import javax.swing.*;
 import java.awt.Choice;
 
 public class HomeFrame extends JFrame {
    private JTextField textField;
 
    /**
     * Launch the application.
     */
  
    /**
     * Create the frame.
     */
    @SuppressWarnings("unchecked")
 public HomeFrame() {
    	getContentPane().setBackground(new Color(255, 218, 185));
 
 	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setBounds(100, 100, 650, 480);
       getContentPane().setLayout(null);
       
       JCheckBox checkBox = new JCheckBox("\uC990\uACA8\uCC3E\uAE30");
       checkBox.setBackground(new Color(255, 228, 181));
       checkBox.setBounds(373, 200, 105, 45);
       getContentPane().add(checkBox);
       
       JButton btnNewButton = new JButton("����");
       btnNewButton.setFont(new Font("a���������B", Font.PLAIN, 18));
       btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
          }
       });
       btnNewButton.setBounds(486, 207, 125, 29);
       getContentPane().add(btnNewButton);
       
       TextArea textArea = new TextArea();
       textArea.setBounds(10, 251, 612, 157);
       getContentPane().add(textArea);
       
       String item[]={"����� �߰�", "����� ����", "����� ����"};
 		btnNewButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 			}
 		});
 					
       
       JLabel label = new JLabel("�˻�");
       label.setHorizontalAlignment(SwingConstants.CENTER);
       label.setBounds(144, 204, 53, 37);
       getContentPane().add(label);
       
       textField = new JTextField();
       textField.setBounds(209, 204, 156, 37);
       getContentPane().add(textField);
       textField.setColumns(10);
        
      
       JList list = new JList();
       list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       list.setBounds(12, 10, 610, 184);
       getContentPane().add(list);
       
       ModifyQuery mq = new ModifyQuery();
       Vector<String> haha = mq.modifyQuery("select date, title from history", null, null);
       list.setListData(haha);

       /*String date = "1955-11-01";
       String title = "��Ʈ�� ����";
      
       Vector<String> haha = mq.modifyQuery("select contents from history where date=? and title=?", date, title);
      *////////getSelected 
       
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu mnHome = new JMenu("HOME");
        mb.add(mnHome);
        
        JMenuItem mntmn = new JMenuItem("�� â (N)");
        mnHome.add(mntmn);
        
        JMenuItem mntmq = new JMenuItem("������ (Q)");
        mnHome.add(mntmq);
        mntmn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
           	 EventQueue.invokeLater(new Runnable() {
          	         public void run() {
          	            try {
          	            	HomeFrame frame = new HomeFrame();
          	               frame.setVisible(true);
          	            } catch (Exception e) {
          	               e.printStackTrace();
          	            }
          	         }
          	      });
            }
         });
        
        
        JMenu menu = new JMenu("����� ����");
        mb.add(menu);
        
        JMenuItem menuItem = new JMenuItem("����� �߰�");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
           	 EventQueue.invokeLater(new Runnable() {
          	         public void run() {
          	            try {
          	               //Insert_user frame = new Insert_user();
          	               //frame.setVisible(true);
          	            } catch (Exception e) {
          	               e.printStackTrace();
          	            }
          	         }
          	      });
            }
         });
        
        JMenuItem menuItem1 = new JMenuItem("����� ����");
        menu.add(menuItem1);
        menuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
           	 EventQueue.invokeLater(new Runnable() {
          	         public void run() {
          	            try {
          	              // Change_user frame = new Change_user();
          	               //frame.setVisible(true);
          	            } catch (Exception e) {
          	               e.printStackTrace();
          	            }
          	         }
          	      });
            }
         });
        
        JMenuItem menuItem2 = new JMenuItem("����� ����");
        menu.add(menuItem2);
        menuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
           	 EventQueue.invokeLater(new Runnable() {
          	         public void run() {
          	            try {
          	               //Delete_user frame = new Delete_user();
          	               //frame.setVisible(true);
          	            } catch (Exception e) {
          	               e.printStackTrace();
          	            }
          	         }
          	      });
            }
         });
        
        JMenu menu_1 = new JMenu("���ã��");
        mb.add(menu_1);
     }
  }