package popup_history;
//
import java.awt.EventQueue;

public class Main {
	   public static void main(String[] args) {
		   
		   Tray test= new Tray("∆Æ∑π¿Ã");
		   	//frame1 test1=new frame1();
		   Thread wP = new Thread(new widgetPlay());
		   MainFrame frame = new MainFrame();
           frame.setVisible(true);
           wP.start();
	   }
}

class widgetPlay extends Thread{
	public void run(){
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
	            try{
	            	Thread.sleep(1000);
	            }catch(Exception e){}
	        }
	    });
	}
}
