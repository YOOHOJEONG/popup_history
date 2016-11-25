package popup_history;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;

import javax.swing.*;
import java.util.*;

public class Widget extends JFrame{
    

   int x,y,xEkran,yEkran,a;
   Font font1 = new Font("Serif", Font.PLAIN, 20);
   Calendar today = Calendar.getInstance();
   MainFrame m_frame = new MainFrame();
   Calender Cal=new Calender();
   
    public Widget(){//Frame parent, boolean modal) {
        //super(parent, modal);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(new Rectangle(screenSize.width-300, 0, 0, 0));
        initComponents();
    }

  

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        home = new JLabel();
        exit = new JLabel();
        jLabe = new JLabel();
        workName = new JLabel("���� �� ��");
        textArea = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        Cal.Calender();
        
        ImageIcon HomeIcon1 = new ImageIcon("src/images/home.jpg");
        ImageIcon ExitIcon1 = new ImageIcon("src/images/exit.jpg");
        Image HomeIcon2 = HomeIcon1.getImage();
        Image ExitIcon2 = ExitIcon1.getImage();
        Image HomeIcon3 = HomeIcon2.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        Image ExitIcon3 = ExitIcon2.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
        ImageIcon HomeIcon = new ImageIcon(HomeIcon3);
        ImageIcon ExitIcon = new ImageIcon(ExitIcon3);         //������ ��� ����
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //����
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setOpaque(true);
        textArea.setPreferredSize(new Dimension(280, 60));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        getContentPane().add(textArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 200, -1, -1));
        Work work = new Work();
        work.Work(textArea);
        

        
        //���� �̹���
        textArea2.setBackground(new Color(255, 255, 255));
        textArea2.setOpaque(true);
        textArea2.setPreferredSize(new Dimension(130, 30));
        textArea2.setEditable(false);
        textArea2.append("  "+today.get(Calendar.YEAR)+"�� "+(today.get(Calendar.MONTH)+1)+"��");
        textArea2.setFont(font1);
        getContentPane().add(textArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
        
        //�޷����
        textArea3.setBackground(new Color(255, 255, 255));
        textArea3.setOpaque(true);
        textArea3.setPreferredSize(new Dimension(280, 130));
        textArea3.setEditable(false);
        textArea3.setTabSize(4);
        textArea3.getTabSize();        
        for(a=0;a<6;a++){
           textArea3.append(Cal.Cal[a]);}
        getContentPane().add(textArea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 45, -1, -1));
          

        home.setBackground(new Color(255, 255, 255));
        home.setIcon(HomeIcon); // NOI18N
        home.setMaximumSize(new Dimension(16, 16));
        home.setOpaque(true);
        home.setPreferredSize(new Dimension(16, 16)); //ũ��
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
    private JTextArea textArea;
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
           textArea.append( today.get(Calendar.YEAR)+"��"+(today.get(Calendar.MONTH)+1)+"��"+today.get(Calendar.DATE)+"��"+"�Դϴ�.\n");
           for(i=0;i<plan.size();i++)
              textArea.append("�� "+plan.elementAt(i)+"\n");
           
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
}

class Calender{
   int Fweek,a,i,day=1;
   String[] Cal = {"","","","","",""};
   Calendar today = Calendar.getInstance();
   void Calender(){
      Cal[0]="��\t��\tȭ\t��\t��\t��\t��\n";
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
            if(day==today.getActualMaximum(Calendar.DATE))break;
      }
      Cal[a]=Cal[a]+"\n";
      }
      
      /*for(a=0;a<6;a++){
         System.out.print(Cal[a]);
      }*/
   }
    
}