package popup_history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;


public class Favorite extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame5 frame = new frame5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Favorite() {
		//EXIT_ON_CLOSE
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JList FavL = new JList();

		
		try {
			ModifyQuery mq = new ModifyQuery();
			Vector<String> date_title_bookmark;
			date_title_bookmark = mq.modifyQuery("select date, title from bookmark", null, null, null);
		    FavL.setListData(date_title_bookmark);

		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel label = new JLabel("목록");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 10, 53, 25);
		contentPane.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 137, 414, 90);
		contentPane.add(textArea);
		
		FavL.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					String str = (String)FavL.getSelectedValue();
					StringTokenizer tokens = new StringTokenizer(str);
					String date = tokens.nextToken("▶");//구분자
					String title = tokens.nextToken("▶");
					
					ModifyQuery mq = new ModifyQuery();
					Vector<String> contents;
					contents = mq.modifyQuery("select contents from bookmark where date=? and title=?",  date, title, null);
					String text = (String)contents.get(0);      	       
					textArea.setText(text);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		FavL.setBounds(10, 30, 414, 101);
		contentPane.add(FavL);
	      
		JButton button = new JButton("취소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
         	         public void run() {
         	            try {
         	            	dispose();
         	            } catch (Exception e) {
         	               e.printStackTrace();
         	            }
         	         }
         	      });
			}
		});
		button.setBounds(344, 233, 80, 23);
		contentPane.add(button);
		
		JButton button_2 = new JButton("삭제");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = (String)FavL.getSelectedValue();
				if(str==null){
	   				JOptionPane.showMessageDialog(null, "삭제 할 목록을 선택하십시오.","", JOptionPane.WARNING_MESSAGE );
				}
				else{
					StringTokenizer tokens = new StringTokenizer(str);
					String date = tokens.nextToken("▶");//구분자
					String title = tokens.nextToken("▶");

					try {

						ModifyQuery mq = new ModifyQuery();
						Vector<String> deleteRec;
						deleteRec = mq.modifyQuery("delete from bookmark where date=? and title=?;",  date, title, null);
						JOptionPane.showMessageDialog(null, "삭제 완료","", JOptionPane.PLAIN_MESSAGE);
						
					    textArea.setText(null);	

						ModifyQuery mq1 = new ModifyQuery();
						Vector<String> date_title_bookmark;
						date_title_bookmark = mq1.modifyQuery("select date, title from bookmark", null, null, null);
					    FavL.setListData(date_title_bookmark);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(252, 233, 80, 23);
		contentPane.add(button_2);
	}

}
