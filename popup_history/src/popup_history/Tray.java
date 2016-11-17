package popup_history;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tray extends Trayicon{
   
   //Ʈ���� ������ Ÿ��Ʋ  
   String m_strTrayTitle;
   
   public Tray(String strTrayTitle)
   {

    m_strTrayTitle = strTrayTitle;
    
    initTray(m_strTrayTitle);
   }
}

class Trayicon implements ActionListener {
	 // SystemTrayŬ������ ���ɴϴ�.
	   SystemTray m_tray = SystemTray.getSystemTray();
	   //������ �Դϴ�. 
	   TrayIcon m_ti;
	   //String m_strTrayTitle;
	// Ʈ���� �������� �ʱ⼳���� ���ݴϴ�.
	   MainFrame m_frame = new MainFrame();
	   
	   void initTray(String m_strTrayTitle)
	   {
	    // Ʈ���� �������� ������ ������ �� �̹��� �Դϴ�. 
	    Image image = Toolkit.getDefaultToolkit().getImage("images/tray.jpg");
	    
	    // TrayIcon�� �����մϴ�.
	    m_ti = new TrayIcon(image, m_strTrayTitle, createPopupMenu());
	    m_ti.setImageAutoSize(true);
	    
	    m_ti.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	           	m_frame.setVisible(!m_frame.isVisible());
	                // Ʈ���� ������ ��ü�� Ŭ�������� �Ͼ �̺�Ʈ�� ���� ������ �����մϴ�. 
	           }
	       });
	       
	    // ������ ���� SystemTray�� ��� �� ������ TrayIcon�� �ν��Ͻ��� ���ڷ� �־��ݴϴ�.
	    try 
	    {
	         m_tray.add(m_ti);
	         } 
	    catch (AWTException e1) 
	    {
	    	e1.printStackTrace();
	    	}
	    }
	   
	   // Ʈ���� �����ܿ��� ����� �˾� �Ŵ��� ����ϴ�.
	   private PopupMenu createPopupMenu()
	   {
	       PopupMenu popupMenu = new PopupMenu();
	       
	       MenuItem miShow = new MenuItem("����");
	       MenuItem miQuit = new MenuItem("����");

	       //������ �׸� ���� ������ ����. 
	       miShow.addActionListener(this);
	       miQuit.addActionListener(this);
	       
	       //�˾� �޴��� ��� 
	       popupMenu.add(miShow);
	       // �� ����
	       popupMenu.addSeparator();
	       popupMenu.add(miQuit);
	       
	       return popupMenu;
	   }
	   
	   public void actionPerformed(ActionEvent e)
	   {
	    if(e.getActionCommand() == "����")
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
	    else if(e.getActionCommand() == "����")
	    {
	    	ExitMessage eM = new ExitMessage();
	    	eM.showMessage("����","�����մϴ�");
	    	System.exit(0);
	    }
	   }
	     
}
class ExitMessage{
	void showMessage(String title,String message){
	   	JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
	   }
}

