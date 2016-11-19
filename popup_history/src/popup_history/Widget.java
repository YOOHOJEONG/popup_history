package popup_history;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;

import javax.swing.*;
import java.util.*;

public class Widget extends javax.swing.JDialog{
    

	int x,y,xEkran,yEkran,i;
	Font font1 = new Font("Serif", Font.PLAIN, 20);
	Calendar today = Calendar.getInstance();
	MainFrame m_frame = new MainFrame();
	Calender Cal=new Calender();
	
    public Widget(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabe = new javax.swing.JLabel();
        workName = new JLabel("오늘 할 일");
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
        ImageIcon ExitIcon = new ImageIcon(ExitIcon3);         //아이콘 모양 세팅
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //할일
        textArea.setBackground(new java.awt.Color(255, 255, 255));
        textArea.setOpaque(true);
        textArea.setPreferredSize(new java.awt.Dimension(280, 60));
        textArea.setEditable(false);
        ModifyQuery mq = new ModifyQuery();
		Vector<String> plan;
		try {
			plan = mq.modifyQuery("select plan from calender where date=current_date", null, null, null);
	        textArea.append( today.get(Calendar.YEAR)+"년"+(today.get(Calendar.MONTH)+1)+"월"+today.get(Calendar.DATE)+"일"+"입니다.\n"+plan);
	        getContentPane().add(textArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 200, -1, -1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        //맨위 이번달
        textArea2.setBackground(new java.awt.Color(255, 255, 255));
        textArea2.setOpaque(true);
        textArea2.setPreferredSize(new java.awt.Dimension(130, 30));
        textArea2.setEditable(false);
        textArea2.append("  "+today.get(Calendar.YEAR)+"년 "+(today.get(Calendar.MONTH)+1)+"월");
        textArea2.setFont(font1);
        getContentPane().add(textArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
        
        //달력출력
        textArea3.setBackground(new java.awt.Color(255, 255, 255));
        textArea3.setOpaque(true);
        textArea3.setPreferredSize(new java.awt.Dimension(280, 130));
        textArea3.setEditable(false);
        textArea3.setTabSize(4);
        textArea3.getTabSize();        
        for(i=0;i<6;i++){
        	textArea3.append(Cal.Cal[i]);}
        //textArea3.setFont(font1);
        getContentPane().add(textArea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 45, -1, -1));
          

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setIcon(HomeIcon); // NOI18N
        home.setMaximumSize(new java.awt.Dimension(16, 16));
        home.setOpaque(true);
        home.setPreferredSize(new java.awt.Dimension(16, 16)); //크기
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        
        exit.setBackground(new java.awt.Color(255, 255, 255));
        exit.setIcon(ExitIcon); // NOI18N
        exit.setMaximumSize(new java.awt.Dimension(16, 16));
        exit.setOpaque(true);
        exit.setPreferredSize(new java.awt.Dimension(16, 16));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));
        
        workName.setHorizontalAlignment(SwingConstants.CENTER);
        workName.setBounds(0, 180, 80, 25);
        jLabe.add(workName);

        jLabe.setBackground(new java.awt.Color(255, 255, 255));
        jLabe.setOpaque(true);
        jLabe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabeMousePressed(evt);
            }
        });
        jLabe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabeMouseDragged(evt);
            }
        });
        getContentPane().add(jLabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
	       x=evt.getX();
	       y=evt.getY();
	       
	    }//GEN-LAST:event_jLabel5MousePressed

	private void jLabeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseDragged
		xEkran=evt.getXOnScreen();
		yEkran=evt.getYOnScreen();
		this.setLocation(xEkran-x,yEkran-y);
		}//GEN-LAST:event_jLabel5MouseDragged

	private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faceMousePressed
		try
		{
			m_frame.setVisible(!m_frame.isVisible());
		}catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}//GEN-LAST:event_faceMousePressed
	
	private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_youtubeMousePressed
		try{
			dispose();
			//System.exit(0);
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel home;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabe;
    private JLabel workName;
    // End of variables declaration//GEN-END:variables
    private JTextArea textArea;
    private JTextArea textArea2;
    private JTextArea textArea3;
}

class Calender{
	int Fweek,a,i,day=1;
	String[] Cal = {"","","","","",""};
	Calendar today = Calendar.getInstance();
	void Calender(){
		Cal[0]="일\t월\t화\t수\t목\t금\t토\n";
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
