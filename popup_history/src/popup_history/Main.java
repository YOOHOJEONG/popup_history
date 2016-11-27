package popup_history;
//
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

public class Main {//프로그램 실행을 위한 클래스
      public static void main(String[] args) {//프로그램 실행
         
         Tray test= new Tray("Popup History");
         Thread wP = new Thread(new widgetPlay());
         MainFrame frame = new MainFrame();
           frame.setVisible(true);
           wP.start();
      }
}

class widgetPlay extends Thread{//위젯을 실행시켜주는 클래스
   public void run(){
      java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               Widget dialog = new Widget();//new JFrame(), true);
               dialog.addWindowListener(new WindowAdapter() {
                   @Override
                   public void windowClosing(WindowEvent e) {
                       System.exit(0);
                   }
               });
               dialog.setVisible(true);
               try{
                  Thread.sleep(1000);
               }catch(Exception e){}
           }
       });
   }
}