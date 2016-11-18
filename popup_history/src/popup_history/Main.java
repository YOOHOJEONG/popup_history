package popup_history;
//
import java.awt.EventQueue;

public class Main {
	   public static void main(String[] args) {
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
		   /*Tray test= new Tray("∆Æ∑π¿Ã");
		   	//frame1 test1=new frame1();
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
		    });*/
	   }
}
