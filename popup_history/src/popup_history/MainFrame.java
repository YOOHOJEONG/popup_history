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

	//메인 프레임의 UI와 기능
	public MainFrame(){
		setTitle("PopUp_History");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/tray.jpg")));
    	getContentPane().setBackground(new Color(255, 255, 255));
 
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setBounds(100, 100, 650, 469);
    	getContentPane().setLayout(null);
			
        JLabel label = new JLabel("검색");
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
        
        //검색 버튼 클릭시 입력한 text로 역사 검색
        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			String searchVal = textField.getText();
    			if("".equals(searchVal))
    				JOptionPane.showMessageDialog(null, "검색어를 입력하세요.","", JOptionPane.ERROR_MESSAGE );
    			else{
    				HomeSearch hs = new HomeSearch();
    				hs.HomeSearch(searchVal, list, textArea);	//입력한 text로 역사 검색해서 리스트에 출력
    		        textArea.setText(null);
    			}       		
        	}
        });
        
        btnSearch.setBounds(424, 211, 85, 23);
        getContentPane().add(btnSearch);
        
        //다시 오늘의 역사를 리스트에 출력
        JButton btnResoration = new JButton("복구");
        btnResoration.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Restoration_btn rb = new Restoration_btn();
        		rb.Restoration_btn(list, textArea);
        		textField.setText(null);
        	}
        });
        btnResoration.setBounds(521, 211, 101, 23);
        getContentPane().add(btnResoration);
        
        //선택한 역사를 즐겨찾기 테이블에 복사한다.
        JButton btnNewButton = new JButton("즐겨찾기 추가");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	InsertBookmark_btn ibn = new InsertBookmark_btn();
        	public void mouseClicked(MouseEvent arg0) {
        		if(list.getSelectedValue()==null){
    				JOptionPane.showMessageDialog(null, "즐겨찾기 할 목록을 선택하세요.","", JOptionPane.ERROR_MESSAGE );
        		}
        		else if(ibn.SearchBookmark(list)==0){
        			JOptionPane.showMessageDialog(null, "즐겨찾기 중복 되었습니다","", JOptionPane.WARNING_MESSAGE);
        		}
        		else{
        			ibn.InsertBookmark_btn(list);
        			JOptionPane.showMessageDialog(null, "즐겨찾기 등록 완료","", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        btnNewButton.setBounds(12, 211, 134, 23);
        getContentPane().add(btnNewButton);
        

        
         JMenuBar mb = new JMenuBar();
         setJMenuBar(mb);
         
         JMenu mnHome = new JMenu("HOME");
         mb.add(mnHome);
         
         //HOME 메뉴에서 '새 창' 클릭시 홈 프레임이 켜짐
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
         
         //HOME 메뉴에서 '끝내기' 클릭시 홈 프레임 꺼짐
         JMenuItem mntmq = new JMenuItem("끝내기 (Q)");
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
         
         //HOME 메뉴에서 '관리자' 클릭시 관리자 로그인 프레임이 켜짐
         JMenuItem mntmM = new JMenuItem("관리자");
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
         
         
         
         JMenu menu = new JMenu("기념일 관리");
         mb.add(menu);
         
         //기념일 관리 메뉴에 '기념일 추가' 클릭시 기념일 추가 프레임이 켜짐
         JMenuItem menuItem = new JMenuItem("기념일 추가");
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
         
         //기념일 관리 메뉴에 '기념일 수정' 클릭시 기념일 수정 프레임이 켜짐
         JMenuItem menuItem1 = new JMenuItem("기념일 수정");
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
         
         //기념일 관리 메뉴에 '기념일 삭제' 클릭시 기념일 삭제 프레임이 켜짐
         JMenuItem menuItem2 = new JMenuItem("기념일 삭제");
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
         
         //즐겨찾기 메뉴 안에 '즐겨찾기 삭제' 추가와 클릭시에 즐겨찾기 삭제 프레임이 켜짐
         JMenu Fav = new JMenu("즐겨찾기 관리");
         mb.add(Fav);
         JMenuItem FavM = new JMenuItem("즐겨찾기 삭제");
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