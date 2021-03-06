package popup_history;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;

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
      String message;
      int timer=0;
      MainFrame m_frame = new MainFrame();
      
      
      
      
      //트레이 메시지 출력
      class ShowMessageListener {
         String title;
         String message;
         TrayIcon.MessageType messageType;
         ShowMessageListener(TrayIcon trayicon, String title, String message, TrayIcon.MessageType messageType){
            m_ti=trayicon;
            this.title = title;
            this.message = message;
            this.messageType = messageType;
         }
         public void playMessage(){
            m_ti.displayMessage(title, message, messageType);
         }
      }
      
      //시간에 마춰서 트레이 메시지 출력
      class TimerMessage extends Thread{
         public void run(){
            Message Hm=new Message();
            Calendar today = Calendar.getInstance();
           
            while(true){
               today=Calendar.getInstance();
               message=Hm.Message(message);
               ShowMessageListener SML = new ShowMessageListener(m_ti,today.get(Calendar.YEAR)+"/"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DATE)+".",
                       message,TrayIcon.MessageType.NONE);   //지속적으로 내용을 받음
               if(today.get(Calendar.MINUTE)==timer){   //분 단위
                  SML.playMessage();
                  try{
                      Thread.sleep(10000);//10초에 한번씩 1분 뜸
                   }catch(Exception e){
                      System.out.println("Message down");
                   } 
               }
               try {
               Thread.sleep(5000);
               } catch (Exception e) {}
            }
         }   
      }
      
      //트레이 아이콘 UI
      void initTray(String m_strTrayTitle)
      {
       // 트레이 아이콘의 아이콘 역할을 할 이미지 입니다. 
       Image image = Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/tray.jpg"));
       
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
      
      // 트레이 아이콘에서 사용할 오른쪽 마우스 클릭 팝업 메뉴를 만듭니다.
      private PopupMenu createPopupMenu()
      {
          PopupMenu popupMenu = new PopupMenu();
          
          MenuItem miShow = new MenuItem("위젯");
          MenuItem timerM = new MenuItem("역사 출력 시간 설정");
          MenuItem miQuit = new MenuItem("종료");

          //각각에 항목에 대해 리스너 장착. 
          miShow.addActionListener(this);
          timerM.addActionListener(this);
          miQuit.addActionListener(this);
          
          //팝업 메뉴에 등록 
          popupMenu.add(miShow);
          popupMenu.add(timerM);
          // 줄 생성
          popupMenu.addSeparator();
          popupMenu.add(miQuit);
          TimerMessage TM=new TimerMessage();
          TM.start();
          return popupMenu;
      }
      
      //오른쪽 마우스 입력시 뜨는 팝업 메뉴의 각 기능
      public void actionPerformed(ActionEvent e)
      {
    	  ExitMessage eM = new ExitMessage();
       if(e.getActionCommand() == "위젯")
       {
           java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                   Widget dialog = new Widget();//new JFrame(), true);
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
       else if(e.getActionCommand() == "역사 출력 시간 설정"){
    	   while(true){
    		   timer = -1;
        	   try {
        		   timer=Integer.parseInt(JOptionPane.showInputDialog(null, "0~59 중 원하는 시간을 입력해주십시오.(숫자)"));
        	   }
        	   catch(Exception ex) {}
        	   if(0<=timer&&timer<=59){
        		   break;
        	   }
        	   else{
        		   eM.showMessage("오류","0~59 사이의 정수를 제대로 입력하십시오.");
        	   }
    	   }    	   
       }
       else if(e.getActionCommand() == "종료")
       {         
          eM.showMessage("종료","종료합니다");
          System.exit(0);
       }
      }        
}

//오늘의 역사를 출력양식에 마추어서 스트링으로 리턴
class Message{
   public String Message(String message){
      ModifyQuery mq = new ModifyQuery();
      Vector<String> plan;
      message = "";
      try {
         plan = mq.modifyQuery("select date, title from history where month(date)=month(current_date) and day(date)=day(current_date) order by year(date)", null, null, null);
           for(int i=0;i<plan.size();i++)
              message=message+plan.elementAt(i)+"\n";
      } catch (ParseException e) {
         e.printStackTrace();
      }
      return message;
   }
}

//종료시 받아온 타이틀과 메시지 출력을 메시지 판으로 생성
class ExitMessage{
   void showMessage(String title,String message){
         JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
      }
}