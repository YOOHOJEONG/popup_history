package popup_history;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;

import javax.swing.*;
import java.util.*;

public class Widget extends JFrame{

   int x,y,xEkran,yEkran,a;
   static int reset=0;
   Font font1 = new Font("Serif", Font.PLAIN, 20);
   Calendar today = Calendar.getInstance();
   MainFrame m_frame = new MainFrame();
   CalendarShow Cal=new CalendarShow();
   
    public Widget(){//Frame parent, boolean modal) {
        //super(parent, modal);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(new Rectangle(screenSize.width-300, 0, 0, 0));
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    void initComponents() {
        home = new JLabel();
        exit = new JLabel();
        jLabe = new JLabel();
        workName = new JLabel("today's plan");
        textArea = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        InsertCalFrame icf = new InsertCalFrame();
        DeleteCalFrame dcf = new DeleteCalFrame();
        modifyCalFrame mcf = new modifyCalFrame();
        Work work = new Work();
        
        ImageIcon HomeIcon1 = new ImageIcon("src/images/home.jpg");
        ImageIcon ExitIcon1 = new ImageIcon("src/images/exit.jpg");
        Image HomeIcon2 = HomeIcon1.getImage();
        Image ExitIcon2 = ExitIcon1.getImage();
        Image HomeIcon3 = HomeIcon2.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        Image ExitIcon3 = ExitIcon2.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon HomeIcon = new ImageIcon(HomeIcon3);
        ImageIcon ExitIcon = new ImageIcon(ExitIcon3);         //아이콘 모양 세팅
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //할일
        JScrollPane JSP= new JScrollPane();
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setOpaque(true);
        JSP.setPreferredSize(new Dimension(280, 60));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JSP.setViewportView(textArea);
        getContentPane().add(JSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 200, -1, -1));
        
        //맨위 이번달
        textArea2.setBackground(new Color(255, 255, 255));
        textArea2.setOpaque(true);
        textArea2.setPreferredSize(new Dimension(130, 30));
        textArea2.setEditable(false);
        textArea2.append("  "+(today.get(Calendar.MONTH)+1)+", "+today.get(Calendar.YEAR));
        textArea2.setFont(font1);
        getContentPane().add(textArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
        
        //달력출력
        textArea3.setBackground(new Color(255, 255, 255));
        textArea3.setOpaque(true);
        textArea3.setPreferredSize(new Dimension(280, 130));
        textArea3.setEditable(false);
        textArea3.setTabSize(4);
        textArea3.getTabSize();
        getContentPane().add(textArea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 45, -1, -1));
          

        home.setBackground(new Color(255, 255, 255));
        home.setIcon(HomeIcon); // NOI18N
        home.setMaximumSize(new Dimension(16, 16));
        home.setOpaque(true);
        home.setPreferredSize(new Dimension(16, 16)); //크기
        home.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                homeMousePressed(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        
        exit.setBackground(new Color(255, 255, 255));
        exit.setIcon(ExitIcon); // NOI18N
        exit.setMaximumSize(new Dimension(16, 16));
        exit.setOpaque(true);
        exit.setPreferredSize(new Dimension(16, 16));
        exit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));
        
        workName.setHorizontalAlignment(SwingConstants.CENTER);
        workName.setBounds(0, 180, 80, 25);
        jLabe.add(workName);

        jLabe.setBackground(new Color(255, 255, 255));
        jLabe.setOpaque(true);
        jLabe.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jLabeMousePressed(evt);
            }
        });
        jLabe.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jLabeMouseDragged(evt);
            }
        });
        getContentPane().add(jLabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 270));

        pack();
		
        class ShowText extends Thread{
        	public void run(){
        		while(true){
                	Cal.CalendarShow();
                	for(a=0;a<6;a++)
                		textArea3.append(Cal.Cal[a]);
                	work.Work(textArea);
                	System.out.println("\t"+reset);
                	try {
                        Thread.sleep(3600000);	//한시간 단위로 텍스트에리어 변환
                        } catch (Exception e) {} 
                	textArea.setText("");
                	textArea3.setText("");
                }
        	}
        }
        class ResetWork extends Thread{
        	public void run(){
        		while(true){
        			if(icf.set==1)
        				reset=icf.set;
        			else if(dcf.set==1)
        				reset=dcf.set;
        			else if(mcf.set==1)
        				reset=mcf.set;
        			else
        				reset=0;
        			System.out.println(reset);
        			if(reset==1){
        				textArea.setText("");
        				work.Work(textArea);
        			}
        			try{
        				Thread.sleep(1000);	//한시간 단위로 텍스트에리어 변환
                    } catch (Exception e) {} 
        		}
        	}
        }

        Thread st = new Thread(new ShowText());
        Thread rw = new Thread(new ResetWork());
        st.start();
        rw.start();   
        
    }// </editor-fold>//GEN-END:initComponents

    private void jLabeMousePressed(MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
          x=evt.getX();
          y=evt.getY();
          
       }//GEN-LAST:event_jLabel5MousePressed

   private void jLabeMouseDragged(MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseDragged
      xEkran=evt.getXOnScreen();
      yEkran=evt.getYOnScreen();
      this.setLocation(xEkran-x,yEkran-y);
      }//GEN-LAST:event_jLabel5MouseDragged

   private void homeMousePressed(MouseEvent evt) {//GEN-FIRST:event_faceMousePressed
      try
      {
         m_frame.setVisible(!m_frame.isVisible());
      }catch(Exception ex) 
      {
         JOptionPane.showMessageDialog(null,ex.getMessage());
      }
   }//GEN-LAST:event_faceMousePressed
   
   private void exitMousePressed(MouseEvent evt) {//GEN-FIRST:event_youtubeMousePressed
      try{
         dispose();
         //System.exit(0);
      }catch(Exception ex)
      {
         JOptionPane.showMessageDialog(null,ex.getMessage());
      }
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel home;
    private JLabel exit;
    private JLabel jLabe;
    private JLabel workName;
    // End of variables declaration//GEN-END:variables
    JTextArea textArea;
    private JTextArea textArea2;
    private JTextArea textArea3;
}
class Work{
   int i;
   Calendar today = Calendar.getInstance();
   
   void Work(JTextArea textArea){
      ModifyQuery mq = new ModifyQuery();
      Vector<String> plan;
      try {
         plan = mq.modifyQuery("select plan from calender where date=current_date", null, null, null);
           textArea.append( "today is "+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DATE)+"/"+today.get(Calendar.YEAR)+"\n");
           for(i=0;i<plan.size();i++)
              textArea.append("· "+plan.elementAt(i)+"\n");
           
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
}

class CalendarShow{
   int Fweek,a,i,day=1;
   String[] Cal = {"","","","","",""};
   Calendar today = Calendar.getInstance();
   void CalendarShow(){
	   day=1;
	   for(i=1;i<6;i++)
		   Cal[i]="";
      Cal[0]="sun\tmon\ttue\twed\tthu\tfri\tsat\n";
      today.set(Calendar.DATE, 1);
      Fweek=today.get(Calendar.DAY_OF_WEEK);
      for(i=1;i<Fweek;i++){
         Cal[1]=Cal[1]+"  \t";
      }
      for(i=Fweek;i<8;i++){
         Cal[1]=Cal[1]+day+"\t";
         day++;
      }
      Cal[1]=Cal[1]+"\n";
      for(a=2;a<6;a++){
         for(i=1;i<8;i++){
            Cal[a]=Cal[a]+day+"\t";
            day++;
            if(day==(today.getActualMaximum(Calendar.DATE)+1))break;
      }
      Cal[a]=Cal[a]+"\n";
      }
      
   }
    
}
