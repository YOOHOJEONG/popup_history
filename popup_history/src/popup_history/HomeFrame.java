package popup_history;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.TextField;
import java.awt.ScrollPane;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.Choice;

public class HomeFrame extends JFrame {
   private JTextField textField;

   /**
    * Launch the application.
    */
 
   /**
    * Create the frame.
    */
   @SuppressWarnings("unchecked")
public HomeFrame() {
   	getContentPane().setBackground(new Color(255, 218, 185));

	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 650, 480);
      getContentPane().setLayout(null);
      
      JCheckBox checkBox = new JCheckBox("\uC990\uACA8\uCC3E\uAE30");
      checkBox.setBackground(new Color(255, 228, 181));
      checkBox.setBounds(373, 200, 105, 45);
      getContentPane().add(checkBox);
      
      JButton btnNewButton = new JButton("∫π±∏");
      btnNewButton.setFont(new Font("aøæ≥Ø∏ÒøÂ≈¡B", Font.PLAIN, 18));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
         }
      });
      btnNewButton.setBounds(486, 207, 125, 29);
      getContentPane().add(btnNewButton);
      
      TextArea textArea = new TextArea();
      textArea.setBounds(10, 251, 612, 157);
      getContentPane().add(textArea);
      
      String item[]={"±‚≥‰¿œ √ﬂ∞°", "±‚≥‰¿œ ºˆ¡§", "±‚≥‰¿œ ªË¡¶"};
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
					
      
      JLabel label = new JLabel("∞Àªˆ");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setBounds(144, 204, 53, 37);
      getContentPane().add(label);
      
      textField = new JTextField();
      textField.setBounds(209, 204, 156, 37);
      getContentPane().add(textField);
      textField.setColumns(10);
      
      JList list = new JList();
      list.setBounds(12, 10, 610, 184);
      getContentPane().add(list);
      
      JMenuBar mb = new JMenuBar();
      setJMenuBar(mb);
      
      JMenu mnHome = new JMenu("HOME");
      mb.add(mnHome);
      
      JMenuItem mntmn = new JMenuItem("ªı √¢ (N)");
      mnHome.add(mntmn);
      
      JMenuItem mntmq = new JMenuItem("≥°≥ª±‚ (Q)");
      mnHome.add(mntmq);
      mntmn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
         	 EventQueue.invokeLater(new Runnable() {
        	         public void run() {
        	            try {
        	            	HomeFrame frame = new HomeFrame();
        	               frame.setVisible(true);
        	            } catch (Exception e) {
        	               e.printStackTrace();
        	            }
        	         }
        	      });
          }
       });
      
      
      JMenu menu = new JMenu("±‚≥‰¿œ ∞¸∏Æ");
      mb.add(menu);
      
      JMenuItem menuItem = new JMenuItem("±‚≥‰¿œ √ﬂ∞°");
      menu.add(menuItem);
      menuItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
         	 EventQueue.invokeLater(new Runnable() {
        	         public void run() {
        	            try {
        	               //Insert_user frame = new Insert_user();
        	               //frame.setVisible(true);
        	            } catch (Exception e) {
        	               e.printStackTrace();
        	            }
        	         }
        	      });
          }
       });
      
      JMenuItem menuItem1 = new JMenuItem("±‚≥‰¿œ ºˆ¡§");
      menu.add(menuItem1);
      menuItem1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
         	 EventQueue.invokeLater(new Runnable() {
        	         public void run() {
        	            try {
        	              // Change_user frame = new Change_user();
        	               //frame.setVisible(true);
        	            } catch (Exception e) {
        	               e.printStackTrace();
        	            }
        	         }
        	      });
          }
       });
      
      JMenuItem menuItem2 = new JMenuItem("±‚≥‰¿œ ªË¡¶");
      menu.add(menuItem2);
      menuItem2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
         	 EventQueue.invokeLater(new Runnable() {
        	         public void run() {
        	            try {
        	               //Delete_user frame = new Delete_user();
        	               //frame.setVisible(true);
        	            } catch (Exception e) {
        	               e.printStackTrace();
        	            }
        	         }
        	      });
          }
       });
      
      JMenu menu_1 = new JMenu("¡Ò∞‹√£±‚");
      mb.add(menu_1);
   }
}
