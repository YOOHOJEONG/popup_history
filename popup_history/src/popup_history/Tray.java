package popup_history;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;

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
	   String message;
	   MainFrame m_frame = new MainFrame();
	   
	   
	   
	   
	   //Ʈ���� �޽��� ���
	   class ShowMessageListener implements ActionListener{
		   String title;
		   String message;
		   TrayIcon.MessageType messageType;
		   ShowMessageListener(TrayIcon trayicon, String title, String message, TrayIcon.MessageType messageType){
			   m_ti=trayicon;
			   this.title = title;
			   this.message = message;
			   this.messageType = messageType;
		   }
		   public void actionPerformed(ActionEvent e){
			   m_ti.displayMessage(title, message, messageType);
		   }
		   public void playMessage(){
			   m_ti.displayMessage(title, message, messageType);
		   }
		}
	   //�ð��� ���缭 Ʈ���� �޽��� ���
	   class TimerMessage extends Thread{
		   public void run(){
			   Message Hm=new Message();
			   message=Hm.Message(message);
			   int t=0;
			   Calendar today = Calendar.getInstance();
			   
			   ShowMessageListener SML = new ShowMessageListener(m_ti,today.get(Calendar.YEAR)+"/"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DATE)+".",
					   message,TrayIcon.MessageType.NONE);
			   
			   while(true){
				   today=Calendar.getInstance();
				   if(today.get(Calendar.MINUTE)==00){
					   SML.playMessage();
					   try{
				    	   Thread.sleep(10000);//10�ʿ� �ѹ��� 1�� ��
				       }catch(Exception e){
				    	   System.out.println("Message down");
				       }
					   //System.out.println("�� ����Ŭ ��"); 
				   }
				   try {
					Thread.sleep(5000);
				   } catch (Exception e) {}
			   }
		   }   
	   }
	   
	   //Ʈ���� ������ ui
	   void initTray(String m_strTrayTitle)
	   {
	    // Ʈ���� �������� ������ ������ �� �̹��� �Դϴ�. 
	    Image image = Toolkit.getDefaultToolkit().getImage("src/images/tray.jpg");
	    
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
	       MenuItem test = new MenuItem("Test");

	       //������ �׸� ���� ������ ����. 
	       miShow.addActionListener(this);
	       miQuit.addActionListener(this);
	       test.addActionListener(new ShowMessageListener(m_ti,"Ÿ��Ʋ","�޽��� ����",TrayIcon.MessageType.INFO));
	       
	       //�˾� �޴��� ��� 
	       popupMenu.add(miShow);
	       // �� ����
	       popupMenu.addSeparator();
	       popupMenu.add(test);
	       popupMenu.add(miQuit);
	       TimerMessage TM=new TimerMessage();
	       TM.start();
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

class Message{
	public String Message(String message){
		ModifyQuery mq = new ModifyQuery();
		Vector<String> plan;
		message = "";
		try {
			plan = mq.modifyQuery("select date, title from history where month(date)=month(current_date) and day(date)=day(current_date)", null, null, null);
	        for(int i=0;i<plan.size();i++)
	        	message=message+plan.elementAt(i)+"\n";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return message;
	}
}

class ExitMessage{
	void showMessage(String title,String message){
	   	JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
	   }
}
