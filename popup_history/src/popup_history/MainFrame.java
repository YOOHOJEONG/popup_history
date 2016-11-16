package popup_history;
 import java.awt.BorderLayout;
 import java.awt.EventQueue;
 import java.awt.FlowLayout;
 import java.awt.event.ActionListener;
 import java.awt.event.WindowEvent;
import java.util.StringTokenizer;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
 
 public class MainFrame extends JFrame {
    protected static final String JList = null;
	private JTextField textField;
 
    /**
     * Launch the application.
     */
  
    /**
     * Create the frame.
     */
    @SuppressWarnings("unchecked")
 public MainFrame() {
    	getContentPane().setBackground(new Color(245, 245, 245));
 
 	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setBounds(100, 100, 650, 469);
       getContentPane().setLayout(null);
       
       
       
       
      

       
       JButton btnNewButton = new JButton("����");
       btnNewButton.setFont(new Font("a���������B", Font.PLAIN, 18));
       btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
          }
       });
       btnNewButton.setBounds(486, 207, 125, 29);
       getContentPane().add(btnNewButton);
       
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
       
       HomePrint hp1 = new HomePrint();
       hp1.HomePrintIndex(list);
       
       JTextArea textArea = new JTextArea();
       textArea.setEditable(false);
       textArea.setBounds(12, 251, 610, 147);
       getContentPane().add(textArea);
       
       list.addListSelectionListener(new ListSelectionListener() {
          	public void valueChanged(ListSelectionEvent arg0) {
          		if(arg0.getSource() == list){
          	        HomePrint hp2 = new HomePrint();
        			hp2.HomePrintContents(list, textArea);
          		}
          	}
          });
       
       JCheckBox checkBox = new JCheckBox("\uC990\uACA8\uCC3E\uAE30");
      /* checkBox.addItemListener(new ItemListener() {
       	public void itemStateChanged(ItemEvent arg0) {
       		if(arg0.getStateChange()==1){
       			ModifyQuery mq = new ModifyQuery();
       			String str = (String)list.getSelectedValue();
       			StringTokenizer tokens = new StringTokenizer(str);
       			String date = tokens.nextToken("��");//������
       			String title = tokens.nextToken("��");
       			mq.modifyQuery("insert into bookmark(date, title, contents) "
       					+ "select date, title, contents from history where date='"+date+"' and title='"+title+"''", date, title);
       		}
       		else if(arg0.getStateChange()==0){
       			ModifyQuery mq = new ModifyQuery();
       			String str = (String)list.getSelectedValue();
       			StringTokenizer tokens = new StringTokenizer(str);
       			String date = tokens.nextToken("��");//������
       			String title = tokens.nextToken("��");
       			mq.modifyQuery("delete from bookmark(date, title, contents) "
       					+ "select date, title, contents from history where date='"+date+"' and title='"+title+"''", date, title);
       		}
       	}
       });*/
       checkBox.setBackground(new Color(245, 245, 245));
       checkBox.setBounds(373, 200, 105, 45);
       getContentPane().add(checkBox);
       
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu mnHome = new JMenu("HOME");
        mb.add(mnHome);
        
        JMenuItem mntmn = new JMenuItem("�� â (N)");
        mnHome.add(mntmn);
        mntmn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
           	 EventQueue.invokeLater(new Runnable() {
          	         public void run() {
          	            try {
          	            	MainFrame frame = new MainFrame();
          	               frame.setVisible(true);
          	            } catch (Exception e) {
          	               e.printStackTrace();
          	            }
          	         }
          	      });
            }
         });
        
        JMenuItem mntmq = new JMenuItem("������ (Q)");
        mnHome.add(mntmq);
        mntmq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
           	 EventQueue.invokeLater(new Runnable() {
          	         public void run() {
          	            try {
          	            	System.exit(0);
          	            } catch (Exception e) {
          	               e.printStackTrace();
          	            }
          	         }
          	      });
            }
         });
        
        JMenuItem mntmM = new JMenuItem("������");
        mnHome.add(mntmM);
        mntmM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
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
          	               Insert_user frame = new Insert_user();
          	               frame.setVisible(true);
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
          	              Change_user frame = new Change_user();
          	               frame.setVisible(true);
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
          	               Delete_user frame = new Delete_user();
          	               frame.setVisible(true);
          	            } catch (Exception e) {
          	               e.printStackTrace();
          	            }
          	         }
          	      });
            }
         });
        
        JMenu Fav = new JMenu("���ã�� ����");
        mb.add(Fav);
        JMenuItem FavM = new JMenuItem("���ã�� ����,����");
        Fav.add(FavM);
        FavM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
              	 EventQueue.invokeLater(new Runnable() {
             	         public void run() {
             	            try {
             	               Favorite frame = new Favorite();
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