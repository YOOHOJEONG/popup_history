package popup_history;
//
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

public class Main {//���α׷� ������ ���� Ŭ����
      public static void main(String[] args) {//���α׷� ����
         
         Tray test= new Tray("Popup History");
         Thread wP = new Thread(new widgetPlay());
         wP.start();
      }
}

class widgetPlay extends Thread{//������ ��������ִ� Ŭ����
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