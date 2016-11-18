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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
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
       
       String item[]={"기념일 추가", "기념일 수정", "기념일 삭제"};
 					
       
       JLabel label = new JLabel("검색");
       label.setHorizontalAlignment(SwingConstants.CENTER);
       label.setBounds(220, 204, 53, 37);
       getContentPane().add(label);
       
     
        
      
       JList list = new JList();
       list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "date                 title ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

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
      
       
       textField = new JTextField();
       textField.setBounds(262, 204, 156, 37);
       getContentPane().add(textField);
       textField.setColumns(10);
       
       /*JButton btnSearch = new JButton("search");
       btnSearch.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		String searchVal = textField.getText();
       		//System.out.println(searchVal);
    	    ModifyQuery mq = new ModifyQuery();
    	    Vector<String> date_title = mq.modifyQuery("select date, title from history where title like '%?%'", searchVal, null);
    	    list.setListData(date_title);	 
       	}
       });
       
       btnSearch.setBounds(424, 211, 85, 23);
       getContentPane().add(btnSearch);*/
       
       JButton btnResoration = new JButton("restoration");
       btnResoration.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	}
       });
       btnResoration.setBounds(521, 211, 101, 23);
       getContentPane().add(btnResoration);
       
       JButton btnNewButton = new JButton("insert bookmark");
       btnNewButton.addMouseListener(new MouseAdapter() {
       	@Override
       	public void mouseClicked(MouseEvent arg0) {
    		String str = (String)list.getSelectedValue();
    		StringTokenizer tokens = new StringTokenizer(str);
    		String date = tokens.nextToken("▶");//구분자
    		String title = tokens.nextToken("▶");
    		
       		ModifyQuery mq = new ModifyQuery();
       		mq.modifyQuery("insert ignore into bookmark(date, title, contents) "
   					+ "select date, title, contents from history where date=? and title=?;", date, title);
       	}
       });
       btnNewButton.setBounds(12, 204, 134, 23);
       getContentPane().add(btnNewButton);
       

       
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu mnHome = new JMenu("HOME");
        mb.add(mnHome);
        
        JMenuItem mntmn = new JMenuItem("새 창 (N)");
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
        
        JMenuItem mntmq = new JMenuItem("끝내기 (Q)");
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
        
        JMenuItem mntmM = new JMenuItem("관리자");
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
        
        
        
        JMenu menu = new JMenu("기념일 관리");
        mb.add(menu);
        
        JMenuItem menuItem = new JMenuItem("기념일 추가");
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
        
        JMenuItem menuItem1 = new JMenuItem("기념일 수정");
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
        
        JMenuItem menuItem2 = new JMenuItem("기념일 삭제");
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
        
        JMenu Fav = new JMenu("즐겨찾기 관리");
        mb.add(Fav);
        JMenuItem FavM = new JMenuItem("즐겨찾기 수정,삭제");
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