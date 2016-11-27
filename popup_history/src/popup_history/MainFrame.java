package popup_history;
 import java.awt.BorderLayout;
 import java.awt.EventQueue;
 import java.awt.FlowLayout;
 import java.awt.event.ActionListener;
 import java.awt.event.WindowEvent;
import java.text.ParseException;
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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
 public class MainFrame extends JFrame {
    protected static final String JList = null;
	private JTextField textField;

	//���� �������� UI�� ���
	public MainFrame(){
		setTitle("PopUp_History");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/tray.jpg")));
    	getContentPane().setBackground(new Color(255, 255, 255));
 
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setBounds(100, 100, 650, 469);
    	getContentPane().setLayout(null);
			
        JLabel label = new JLabel("�˻�");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(220, 204, 53, 37);
        getContentPane().add(label);
       
        JScrollPane JSP= new JScrollPane();
		JSP.setBounds(12, 10, 610, 184);
		getContentPane().add(JSP);
		
        JList list = new JList();
        list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "date                 title ", 
        		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JSP.setViewportView(list);
        
        HomePrint hp1 = new HomePrint();
        hp1.HomePrintIndex(list);
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setBounds(12, 251, 610, 147);
        textArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contents ", 
        		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        getContentPane().add(textArea);
        
        list.addListSelectionListener(new ListSelectionListener() {
          	public void valueChanged(ListSelectionEvent arg0) {
          		if(arg0.getSource() == list){
          	        HomePrint hp2 = new HomePrint();
          	        hp2.HomePrintContents(list, textArea);
          		}
          	}
          });
       
        textField = new JTextField();
        textField.setBounds(262, 204, 156, 37);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        //�˻� ��ư Ŭ���� �Է��� text�� ���� �˻�
        JButton btnSearch = new JButton("�˻�");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			String searchVal = textField.getText();
    			if("".equals(searchVal))
    				JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���.","", JOptionPane.ERROR_MESSAGE );
    			else{
    				HomeSearch hs = new HomeSearch();
    				hs.HomeSearch(searchVal, list, textArea);	//�Է��� text�� ���� �˻��ؼ� ����Ʈ�� ���
    		        textArea.setText(null);
    			}       		
        	}
        });
        
        btnSearch.setBounds(424, 211, 85, 23);
        getContentPane().add(btnSearch);
        
        //�ٽ� ������ ���縦 ����Ʈ�� ���
        JButton btnResoration = new JButton("����");
        btnResoration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Restoration_btn rb = new Restoration_btn();
        		rb.Restoration_btn(list, textArea);
        		textField.setText(null);
        	}
        });
        btnResoration.setBounds(521, 211, 101, 23);
        getContentPane().add(btnResoration);
        
        //������ ���縦 ���ã�� ���̺� �����Ѵ�.
        JButton btnNewButton = new JButton("���ã�� �߰�");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		if(list.getSelectedValue()==null){
    				JOptionPane.showMessageDialog(null, "���ã�� �� ����� �����ϼ���.","", JOptionPane.ERROR_MESSAGE );
        		}
        		else{
     		InsertBookmark_btn ibn = new InsertBookmark_btn();
     		ibn.InsertBookmark_btn(list);
 			JOptionPane.showMessageDialog(null, "���ã�� ��� �Ϸ�","", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        btnNewButton.setBounds(12, 211, 134, 23);
        getContentPane().add(btnNewButton);
        

        
         JMenuBar mb = new JMenuBar();
         setJMenuBar(mb);
         
         JMenu mnHome = new JMenu("HOME");
         mb.add(mnHome);
         
         //HOME �޴����� '�� â' Ŭ���� Ȩ �������� ����
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
         
         //HOME �޴����� '������' Ŭ���� Ȩ ������ ����
         JMenuItem mntmq = new JMenuItem("������ (Q)");
         mnHome.add(mntmq);
         mntmq.addActionListener(new ActionListener() {
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
         
         //HOME �޴����� '������' Ŭ���� ������ �α��� �������� ����
         JMenuItem mntmM = new JMenuItem("������");
         mnHome.add(mntmM);
         mntmM.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
            	 EventQueue.invokeLater(new Runnable() {
           	         public void run() {
           	            try {
           	            	AdminLoginFrame frame = new AdminLoginFrame();
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
         
         //����� ���� �޴��� '����� �߰�' Ŭ���� ����� �߰� �������� ����
         JMenuItem menuItem = new JMenuItem("����� �߰�");
         menu.add(menuItem);
         menuItem.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
            	 EventQueue.invokeLater(new Runnable() {
           	         public void run() {
           	            try {
           	               InsertCalFrame frame = new InsertCalFrame();
           	               frame.setVisible(true);
           	            } catch (Exception e) {
           	               e.printStackTrace();
           	            }
           	         }
           	      });
             }
          });
         
         //����� ���� �޴��� '����� ����' Ŭ���� ����� ���� �������� ����
         JMenuItem menuItem1 = new JMenuItem("����� ����");
         menu.add(menuItem1);
         menuItem1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
            	 EventQueue.invokeLater(new Runnable() {
           	         public void run() {
           	            try {
           	            	modifyCalFrame frame = new modifyCalFrame();
           	               frame.setVisible(true);
           	            } catch (Exception e) {
           	               e.printStackTrace();
           	            }
           	         }
           	      });
             }
          });
         
         //����� ���� �޴��� '����� ����' Ŭ���� ����� ���� �������� ����
         JMenuItem menuItem2 = new JMenuItem("����� ����");
         menu.add(menuItem2);
         menuItem2.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
            	 EventQueue.invokeLater(new Runnable() {
           	         public void run() {
           	            try {
           	               DeleteCalFrame frame = new DeleteCalFrame();
           	               frame.setVisible(true);
           	            } catch (Exception e) {
           	               e.printStackTrace();
           	            }
           	         }
           	      });
             }
          });
         
         //���ã�� �޴� �ȿ� '���ã�� ����' �߰��� Ŭ���ÿ� ���ã�� ���� �������� ����
         JMenu Fav = new JMenu("���ã�� ����");
         mb.add(Fav);
         JMenuItem FavM = new JMenuItem("���ã�� ����");
         Fav.add(FavM);
         FavM.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
               	 EventQueue.invokeLater(new Runnable() {
              	         public void run() {
              	            try {
              	            	deleteBookmarkFrame frame = new deleteBookmarkFrame();
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