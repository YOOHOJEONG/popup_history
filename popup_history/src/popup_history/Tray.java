package popup_history;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tray extends Trayicon{
   
   //트레이 아이콘 타이틀  
   String m_strTrayTitle;
   
   public Tray(String strTrayTitle)
   {

    m_strTrayTitle = strTrayTitle;
    
    initTray(m_strTrayTitle);
   }
}

class Trayicon implements ActionListener {
	 // SystemTray클래스를 얻어옵니다.
	   SystemTray m_tray = SystemTray.getSystemTray();
	   //아이콘 입니다. 
	   TrayIcon m_ti;
	   //String m_strTrayTitle;
	// 트레이 아이콘의 초기설정을 해줍니다.
	   MainFrame m_frame = new MainFrame();
	   
	   void initTray(String m_strTrayTitle)
	   {
	    // 트레이 아이콘의 아이콘 역할을 할 이미지 입니다. 
	    Image image = Toolkit.getDefaultToolkit().getImage("images/tray.jpg");
	    
	    // TrayIcon을 생성합니다.
	    m_ti = new TrayIcon(image, m_strTrayTitle, createPopupMenu());
	    m_ti.setImageAutoSize(true);
	    
	    m_ti.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	           	m_frame.setVisible(!m_frame.isVisible());
	                // 트레이 아이콘 자체를 클릭했을때 일어날 이벤트에 대한 동작을 구현합니다. 
	           }
	       });
	       
	    // 위에서 얻어온 SystemTray에 방금 막 생성한 TrayIcon의 인스턴스를 인자로 넣어줍니다.
	    try 
	    {
	         m_tray.add(m_ti);
	         } 
	    catch (AWTException e1) 
	    {
	    	e1.printStackTrace();
	    	}
	    }
	   
	   // 트레이 아이콘에서 사용할 팝업 매뉴를 만듭니다.
	   private PopupMenu createPopupMenu()
	   {
	       PopupMenu popupMenu = new PopupMenu();
	       
	       MenuItem miShow = new MenuItem("위젯");
	       MenuItem miQuit = new MenuItem("종료");

	       //각각에 항목에 대해 리스너 장착. 
	       miShow.addActionListener(this);
	       miQuit.addActionListener(this);
	       
	       //팝업 메뉴에 등록 
	       popupMenu.add(miShow);
	       // 줄 생성
	       popupMenu.addSeparator();
	       popupMenu.add(miQuit);
	       
	       return popupMenu;
	   }
	   
	   public void actionPerformed(ActionEvent e)
	   {
	    if(e.getActionCommand() == "위젯")
	    {
	    	 java.awt.EventQueue.invokeLater(new Runnable() {
	 	        public void run() {
	 	            Widget dialog = new Widget(new javax.swing.JFrame(), true);
	 	            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
	 	                @Override
	 	                public void windowClosing(java.awt.event.WindowEvent e) {
	 	                    System.exit(0);
	 	                }
	 	            });
	 	            dialog.setVisible(true);
	 	        }
	 	    });
	    }
	    else if(e.getActionCommand() == "종료")
	    {
	    	ExitMessage eM = new ExitMessage();
	    	eM.showMessage("종료","종료합니당");
	    	System.exit(0);
	    }
	   }
	     
}
class ExitMessage{
	void showMessage(String title,String message){
	   	JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
	   }
}

