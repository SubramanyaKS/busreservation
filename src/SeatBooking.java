import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.util.ArrayList;
import java.util.Date;
import java.awt.TextField;
import javax.swing.JTextField;


public class SeatBooking {

	private JFrame frame;
	private JRadioButton rdbtnSleeperBus;
	private JRadioButton rdbtnNonSleeperBus;
	private  JToggleButton tglbtnNewToggleButton,toggleButton;
	private  JToggleButton toggleButton_1,toggleButton_2,toggleButton_3,toggleButton_4,toggleButton_5;
	private  JToggleButton toggleButton_6,toggleButton_7,toggleButton_8,toggleButton_9,toggleButton_10;
	private  JToggleButton toggleButton_11,toggleButton_12,toggleButton_13,toggleButton_14,toggleButton_15;
	private  JToggleButton toggleButton_16, toggleButton_17, toggleButton_18, toggleButton_19, toggleButton_20;
	private  JToggleButton toggleButton_21,toggleButton_22,toggleButton_23,toggleButton_24,toggleButton_25;
	private  JToggleButton toggleButton_26,toggleButton_27,toggleButton_28,toggleButton_29,toggleButton_30;
	private  JToggleButton toggleButton_31,toggleButton_32,toggleButton_33,toggleButton_34,toggleButton_35;
	private  JToggleButton toggleButton_36,toggleButton_37,toggleButton_38,toggleButton_39,toggleButton_40;
	private  JToggleButton toggleButton_41,toggleButton_42,toggleButton_43,toggleButton_44,toggleButton_45;
	private  JToggleButton toggleButton_46,toggleButton_47,toggleButton_48,toggleButton_49,toggleButton_50;
	private  JToggleButton toggleButton_51;
	
	private JPanel panel;
	private JPanel panel_1;
	public static TextField textField;
	String st;
	int sel;
	//String seatno[] = new String[45];
	ArrayList<String> seatno = new ArrayList<String>();
	ArrayList<String> seat = new ArrayList<String>();
	int count=0;
	public static JTextField textField_1;
	public static JTextField btextField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					String v = args[1];
					SeatBooking window = new SeatBooking(u,v);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}   
		});
	}

	/**
	 * Create the application.
	 */
	public SeatBooking(String u, String v) {
		
		initialize(u,v);
		
	}
	
	public void disradio() {
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select bustype from BUS where bus_id = ?";
			pst = con.mkDataBase().prepareStatement(query);
			pst.setString(1, btextField_2.getText() );
			ResultSet rs=pst.executeQuery();
			rs.next(); 
				String g =rs.getString("bustype");
				//System.out.println(g);
				if(g.equals("A/c") || g.equals("Non A/c"))
				{
					//panel.setVisible(false);
					rdbtnSleeperBus.setEnabled(false);
					rdbtnNonSleeperBus.setEnabled(true);
					
				}
				else {
				//panel.setVisible(true);
				//panel_1.setVisible(false);
					rdbtnSleeperBus.setEnabled(true);
					rdbtnNonSleeperBus.setEnabled(false);
				
			  }
			
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u, String v) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(216, 191, 216));
		frame.setBounds(100, 100, 768, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(10, 270, 461, 174);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 235, 205));
		panel_1.setBounds(10, 77, 461, 174);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel.setVisible(false);
		panel_1.setVisible(false);
		
		
		
		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(584, 19, 89, 30);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d = sdf.format(date);
		label_4.setText(d);
		frame.getContentPane().add(label_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\wheel.jpg"));
		label.setBounds(0, 20, 25, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		label_1.setBounds(34, 20, 25, 14);
		panel.add(label_1);
		
		
		
	
		
		toggleButton_32 = new JToggleButton("");
		toggleButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_32).isSelected()) {
			seat.add("ss1");
			
			count++;
			 toggleButton_32.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss1");
				count--;
				toggleButton_32.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_32.setBackground(new Color(255, 235, 205));
		toggleButton_32.setBounds(88, 11, 63, 33);
		toggleButton_32.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_32);
		
		toggleButton_33 = new JToggleButton("");
		toggleButton_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_33).isSelected()) {
			seat.add("ss2");
			
			count++;
			 toggleButton_33.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss2");
				count--;
				toggleButton_33.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_33.setBackground(new Color(255, 235, 205));
		toggleButton_33.setBounds(88, 47, 63, 33);
		toggleButton_33.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_33);
		
	    toggleButton_34 = new JToggleButton("");
		toggleButton_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_34).isSelected()) {
			seat.add("ss3");
			count++;
			 toggleButton_34.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss3");
				count--;
				toggleButton_34.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_34.setBackground(new Color(255, 235, 205));
		toggleButton_34.setBounds(88, 96, 63, 33);
		toggleButton_34.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_34);
		
		toggleButton_35 = new JToggleButton("");
		toggleButton_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_35).isSelected()) {
			seat.add("ss4");
			count++;
			 toggleButton_35.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss4");
				count--;
				toggleButton_35.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_35.setBackground(new Color(255, 235, 205));
		toggleButton_35.setBounds(88, 130, 63, 33);
		toggleButton_35.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_35);
		
		toggleButton_36 = new JToggleButton("");
		toggleButton_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_36).isSelected()) {
			seat.add("ss8");
			count++;
			 toggleButton_36.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss8");
				count--;
				toggleButton_36.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_36.setBackground(new Color(255, 235, 205));
		toggleButton_36.setBounds(158, 11, 63, 33);
		toggleButton_36.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_36);
		
		toggleButton_37 = new JToggleButton("");
		toggleButton_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_37).isSelected()) {
			seat.add("ss7");
			count++;
			 toggleButton_37.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss7");
				count--;
				toggleButton_37.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_37.setBackground(new Color(255, 235, 205));
		toggleButton_37.setBounds(158, 47, 63, 33);
		toggleButton_37.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_37);
		
		toggleButton_38 = new JToggleButton("");
		toggleButton_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_38).isSelected()) {
			seat.add("ss6");
		
			count++;
			 toggleButton_38.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss6");
				count--;
				toggleButton_38.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_38.setBackground(new Color(255, 235, 205));
		toggleButton_38.setBounds(158, 96, 63, 33);
		toggleButton_38.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_38);
		
		toggleButton_39 = new JToggleButton("");
		toggleButton_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_39).isSelected()) {
			seat.add("ss5");
			
			count++;
			 toggleButton_39.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss25");
				count--;
				toggleButton_39.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_39.setBackground(new Color(255, 235, 205));
		toggleButton_39.setBounds(158, 130, 63, 33);
		toggleButton_39.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_39);
		
		toggleButton_40 = new JToggleButton("");
		toggleButton_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_40).isSelected()) {
			seat.add("ss9");
			
			count++;
			 toggleButton_40.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss9");
				count--;
				toggleButton_40.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_40.setBackground(new Color(255, 235, 205));
		toggleButton_40.setBounds(231, 11, 63, 33);
		toggleButton_40.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_40);
		
		toggleButton_41 = new JToggleButton("");
		toggleButton_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_41).isSelected()) {
			seat.add("ss10");
			
			count++;
			 toggleButton_41.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss10");
				count--;
				toggleButton_41.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_41.setBackground(new Color(255, 235, 205));
		toggleButton_41.setBounds(231, 47, 63, 33);
		toggleButton_41.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_41);
		
		toggleButton_42 = new JToggleButton("");
		toggleButton_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_42).isSelected()) {
			seat.add("ss11");
			count++;
			 toggleButton_42.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss11");
				count--;
				toggleButton_42.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_42.setBackground(new Color(255, 235, 205));
		toggleButton_42.setBounds(231, 96, 63, 33);
		toggleButton_42.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_42);
		
		toggleButton_43 = new JToggleButton("");
		toggleButton_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_43).isSelected()) {
			seat.add("ss12");
			count++;
			 toggleButton_43.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss12");
				count--;
				toggleButton_43.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_43.setBounds(231, 130, 63, 33);
		toggleButton_43.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_43);
		
        toggleButton_44 = new JToggleButton("");
		toggleButton_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_44).isSelected()) {
			seat.add("ss16");
			count++;
			 toggleButton_44.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss16");
				count--;
				toggleButton_44.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_44.setBackground(new Color(255, 235, 205));
		toggleButton_44.setBounds(304, 11, 63, 33);
		toggleButton_44.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_44);
		
		toggleButton_45 = new JToggleButton("");
		toggleButton_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_45).isSelected()) {
			seat.add("ss15");
			count++;
			 toggleButton_45.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss15");
				count--;
				toggleButton_45.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_45.setBackground(new Color(255, 235, 205));
		toggleButton_45.setBounds(304, 47, 63, 33);
		toggleButton_45.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_45);
		
		toggleButton_46 = new JToggleButton("");
		toggleButton_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_46).isSelected()) {
			seat.add("ss14");
			count++;
			 toggleButton_46.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss14");
				count--;
				toggleButton_46.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_46.setBackground(new Color(255, 235, 205));
		toggleButton_46.setBounds(304, 96, 63, 33);
		toggleButton_46.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_46);
		
		toggleButton_47 = new JToggleButton("");
		toggleButton_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_47).isSelected()) {
			seat.add("ss13");
			//i++;
			count++;
			 toggleButton_47.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
			//	i--;
				seat.remove("ss13");
				count--;
				toggleButton_47.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_47.setBackground(new Color(255, 235, 205));
		toggleButton_47.setBounds(304, 130, 63, 33);
		toggleButton_47.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_47);
		
		toggleButton_48 = new JToggleButton("");
		toggleButton_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_48).isSelected()) {
			seat.add("ss17");
			count++;
			 toggleButton_48.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss17");
				count--;
				toggleButton_48.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_48.setBackground(new Color(255, 235, 205));
		toggleButton_48.setBounds(377, 11, 63, 33);
		toggleButton_48.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_48);
		
		toggleButton_49 = new JToggleButton("");
		toggleButton_49.setBackground(new Color(255, 235, 205));
		toggleButton_49.setBounds(377, 47, 63, 33);
		toggleButton_49.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_49).isSelected()) {
				seat.add("ss18");
				count++;
				 toggleButton_49.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
				}
				else {
					seat.remove("ss18");
					count--;
					toggleButton_49.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
				}
			 }
		   });
		toggleButton_49.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_49);
		
		toggleButton_50 = new JToggleButton("");
		toggleButton_50.setBackground(new Color(255, 235, 205));
		toggleButton_50.setBounds(377, 96, 63, 33);
		toggleButton_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_50).isSelected()) {
				seat.add("ss19");
				count++;
				 toggleButton_50.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
				}
				else {
					seat.remove("ss19");
					count--;
					toggleButton_50.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
				}
			 }
		   });
		toggleButton_50.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_50);
		
		toggleButton_51 = new JToggleButton("");
		toggleButton_51.setBackground(new Color(255, 235, 205));
		toggleButton_51.setBounds(377, 130, 63, 33);
		toggleButton_51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if((toggleButton_51).isSelected()) {
			seat.add("ss20");
			count++;
			 toggleButton_51.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sselected.png"));
			}
			else {
				seat.remove("ss20");
				count--;
				toggleButton_51.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
			}
		 }
	   });
		toggleButton_51.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\sunselected.png"));
		panel.add(toggleButton_51);
		
		

		
		tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.setBackground(new Color(255, 235, 205));
		tglbtnNewToggleButton.setBounds(71, 11, 39, 23);
		panel_1.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((tglbtnNewToggleButton).isSelected()) {
				seat.add("sw1");
				
				count++;
				 tglbtnNewToggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
				}
				else {
					seat.remove("sw1");
					count--;
					tglbtnNewToggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
				}
			}
		});
		tglbtnNewToggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(tglbtnNewToggleButton);
		
		toggleButton_1 = new JToggleButton("");
		toggleButton_1.setBackground(new Color(255, 235, 205));
		toggleButton_1.setBounds(71, 106, 39, 23);
		toggleButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if((toggleButton_1).isSelected()) {
			seat.add("s3");
			
			count++;
			 toggleButton_1.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
			}
			else {
				seat.remove("s3");
				count--;
				toggleButton_1.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
			}
		 }
	   });
		toggleButton_1.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_1);
		
		toggleButton_2 = new JToggleButton("");
		toggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_2).isSelected()) {
					seat.add("sw4");
					count++;
					 toggleButton_2.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw4");
						count--;
						toggleButton_2.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_2.setBackground(new Color(255, 235, 205));
		toggleButton_2.setBounds(71, 140, 39, 23);
		toggleButton_2.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_2);
		
		toggleButton_3 = new JToggleButton("");
		toggleButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_3).isSelected()) {
					seat.add("sw5");
					
					count++;
					 toggleButton_3.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw5");
						count--;
						toggleButton_3.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_3.setBackground(new Color(255, 235, 205));
		toggleButton_3.setBounds(121, 140, 39, 23);
		toggleButton_3.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_3);
		
		toggleButton_4 = new JToggleButton("");
		toggleButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_4).isSelected()) {
					seat.add("s6");
					
					count++;
					 toggleButton_4.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s6");
						count--;
						toggleButton_4.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_4.setBackground(new Color(255, 235, 205));
		toggleButton_4.setBounds(120, 106, 39, 23);
		toggleButton_4.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_4);
		
		toggleButton_5 = new JToggleButton("");
		toggleButton_5.setBackground(new Color(255, 235, 205));
		toggleButton_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if((toggleButton_5).isSelected()) {
			seat.add("s7");
			count++;
			 toggleButton_5.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
			}
			else {
				seat.remove("s7");
				count--;
				toggleButton_5.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
			}
		 }
	   });
		toggleButton_5.setBounds(121, 45, 39, 23);
		toggleButton_5.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_5);
		
		toggleButton_6 = new JToggleButton("");
		toggleButton_6.setBackground(new Color(255, 239, 213));
		toggleButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sel==8)
				{
					toggleButton_6.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
				}
				if((toggleButton_6).isSelected()) {
					seat.add("sw8");
					count++;
					toggleButton_6.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw8");
						count--;
						//seat[i]=null;
						toggleButton_6.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_6.setBounds(120, 11, 39, 23);
		toggleButton_6.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_6);
		
		toggleButton_7 = new JToggleButton("");
		toggleButton_7.setBackground(new Color(255, 235, 205));
		toggleButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_7).isSelected()) {
					seat.add("sw9");
					
					count++;
					toggleButton_7.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw9");
						count--;
						//seat[i]=null;
						toggleButton_7.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_7.setBounds(169, 11, 39, 23);
		toggleButton_7.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_7);
		
		toggleButton = new JToggleButton("");
		toggleButton.setBackground(new Color(255, 235, 205));
		toggleButton.setBounds(71, 45, 39, 23);
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton).isSelected()) {
					seat.add("s2");
					
					count++;
					toggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s2");
						count--;
						//seat[i]=null;
						toggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton);
		
		toggleButton_8 = new JToggleButton("");
		toggleButton_8.setBackground(new Color(255, 235, 205));
		toggleButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_8).isSelected()) {
					seat.add("s10");
					count++;
					toggleButton_8.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s10");
						count--;
						//seat[i]=null;
						toggleButton_8.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_8.setBounds(170, 45, 39, 23);
		toggleButton_8.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_8);
		
		toggleButton_9 = new JToggleButton("");
		toggleButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_9).isSelected()) {
					seat.add("s11");
					count++;
					toggleButton_9.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s11");
						count--;
						//seat[i]=null;
						toggleButton_9.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_9.setBackground(new Color(255, 235, 205));
		toggleButton_9.setBounds(169, 106, 39, 23);
		toggleButton_9.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_9);
		
		toggleButton_10 = new JToggleButton("");
		toggleButton_10.setBackground(new Color(255, 235, 205));
		toggleButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_10).isSelected()) {
					seat.add("sw12");
					count++;
					toggleButton_10.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw12");
						count--;
						//seat[i]=null;
						toggleButton_10.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_10.setBounds(169, 140, 39, 23);
		toggleButton_10.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_10);
		
		toggleButton_11 = new JToggleButton("");
		toggleButton_11.setBackground(new Color(255, 235, 205));
		toggleButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_11).isSelected()) {
					seat.add("sw16");
					count++;
					toggleButton_11.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw16");
						count--;
						//seat[i]=null;
						toggleButton_11.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_11.setBounds(219, 11, 39, 23);
		toggleButton_11.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_11);
		
		toggleButton_12 = new JToggleButton("");
		toggleButton_12.setBackground(new Color(255, 235, 205));
		toggleButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_12).isSelected()) {
					seat.add("s15");
					count++;
					toggleButton_12.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s15");
						count--;
						//seat[i]=null;
						toggleButton_12.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_12.setBounds(219, 45, 39, 23);
		toggleButton_12.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_12);
		
		toggleButton_13 = new JToggleButton("");
		toggleButton_13.setBackground(new Color(255, 235, 205));
		toggleButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_13).isSelected()) {
					seat.add("s14");
					
					count++;
					toggleButton_13.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s14");
						count--;
						//seat[i]=null;
						toggleButton_13.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_13.setBounds(216, 106, 39, 23);
		toggleButton_13.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_13);
		
		toggleButton_14 = new JToggleButton("");
		toggleButton_14.setBackground(new Color(255, 235, 205));
		toggleButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_14).isSelected()) {
					seat.add("sw13");
					count++;
					toggleButton_14.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw13");
						count--;
						//seat[i]=null;
						toggleButton_14.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_14.setBounds(216, 140, 39, 23);
		toggleButton_14.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_14);
		
		toggleButton_15 = new JToggleButton("");
		toggleButton_15.setBackground(new Color(255, 235, 205));
		toggleButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_15).isSelected()) {
					seat.add("sw20");
					count++;
					toggleButton_15.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw20");
						count--;
						//seat[i]=null;
						toggleButton_15.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_15.setBounds(265, 140, 39, 23);
		toggleButton_15.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_15);
		
		toggleButton_16 = new JToggleButton("");
		toggleButton_16.setBackground(new Color(255, 235, 205));
		toggleButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_16).isSelected()) {
					seat.add("s19");
					count++;
					toggleButton_16.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s19");
						count--;
						//seat[i]=null;
						toggleButton_16.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_16.setBounds(265, 106, 39, 23);
		toggleButton_16.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_16);
		
		toggleButton_17 = new JToggleButton("");
		toggleButton_17.setBackground(new Color(255, 235, 205));
		toggleButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_17).isSelected()) {
					seat.add("s18");
					count++;
					toggleButton_17.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s18");
					
						count--;
						//seat[i]=null;
						toggleButton_17.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_17.setBounds(268, 45, 39, 23);
		toggleButton_17.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_17);
		
		toggleButton_18 = new JToggleButton("");
		toggleButton_18.setBackground(new Color(255, 235, 205));
		toggleButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_18).isSelected()) {
					seat.add("sw17");
					count++;
					toggleButton_18.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw17");
						count--;
						//seat[i]=null;
						toggleButton_18.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_18.setBounds(265, 11, 39, 23);
		toggleButton_18.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_18);
		
		toggleButton_19 = new JToggleButton("");
		toggleButton_19.setBackground(new Color(255, 235, 205));
		toggleButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_19).isSelected()) {
					seat.add("sw24");
					count++;
					toggleButton_19.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw24");
						count--;
						//seat[i]=null;
						toggleButton_19.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_19.setBounds(314, 11, 39, 23);
		toggleButton_19.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_19);
		
		toggleButton_20 = new JToggleButton("");
		toggleButton_20.setBackground(new Color(255, 235, 205));
		toggleButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_20).isSelected()) {
					seat.add("s23");
					count++;
					toggleButton_20.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s23");
						count--;
						//seat[i]=null;
						toggleButton_20.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_20.setBounds(317, 45, 39, 23);
		toggleButton_20.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_20);
		
		toggleButton_21 = new JToggleButton("");
		toggleButton_21.setBackground(new Color(255, 235, 205));
		toggleButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_21).isSelected()) {
					seat.add("s22");
					count++;
					toggleButton_21.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s22");
						count--;
						//seat[i]=null;
						toggleButton_21.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_21.setBounds(314, 106, 39, 23);
		toggleButton_21.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_21);
		
		toggleButton_22 = new JToggleButton("");
		toggleButton_22.setBackground(new Color(255, 235, 205));
		toggleButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_22).isSelected()) {
					seat.add("sw21");
					count++;
					toggleButton_22.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw21");
						count--;
						//seat[i]=null;
						toggleButton_22.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_22.setBounds(314, 140, 39, 23);
		toggleButton_22.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_22);
		
		toggleButton_23 = new JToggleButton("");
		toggleButton_23.setBackground(new Color(255, 235, 205));
		toggleButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_23).isSelected()) {
					seat.add("sw28");
					count++;
					toggleButton_23.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw28");
						count--;
						//seat[i]=null;
						toggleButton_23.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_23.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		toggleButton_23.setBounds(365, 140, 39, 23);
		panel_1.add(toggleButton_23);
		
		toggleButton_24 = new JToggleButton("");
		toggleButton_24.setBackground(new Color(255, 235, 205));
		toggleButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_24).isSelected()) {
					seat.add("s27");
					count++;
					toggleButton_24.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s27");
						count--;
						//seat[i]=null;
						toggleButton_24.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_24.setBounds(365, 106, 39, 23);
		toggleButton_24.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_24);
		
		toggleButton_25 = new JToggleButton("");
		toggleButton_25.setBackground(new Color(255, 235, 205));
		toggleButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_25).isSelected()) {
					seat.add("s26");
					count++;
					toggleButton_25.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s26");
						count--;
						//seat[i]=null;
						toggleButton_25.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_25.setBounds(366, 45, 39, 23);
		toggleButton_25.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_25);
		
		toggleButton_26 = new JToggleButton("");
		toggleButton_26.setBackground(new Color(255, 235, 205));
		toggleButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_26).isSelected()) {
					seat.add("sw25");
					count++;
					toggleButton_26.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw25");
						count--;
						//seat[i]=null;
						toggleButton_26.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_26.setBounds(365, 11, 39, 23);
		toggleButton_26.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_26);
		
		toggleButton_27 = new JToggleButton("");
		toggleButton_27.setBackground(new Color(255, 235, 205));
		toggleButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_27).isSelected()) {
					seat.add("s33");
					count++;
					toggleButton_27.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s33");
						count--;
						//seat[i]=null;
						toggleButton_27.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_27.setBounds(412, 11, 39, 23);
		toggleButton_27.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_27);
		
		toggleButton_28 = new JToggleButton("");
		toggleButton_28.setBackground(new Color(255, 235, 205));
		toggleButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_28).isSelected()) {
					seat.add("s32");
					count++;
					toggleButton_28.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s32");
						count--;
						//seat[i]=null;
						toggleButton_28.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_28.setBounds(412, 45, 39, 23);
		toggleButton_28.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_28);
		
		toggleButton_29 = new JToggleButton("");
		toggleButton_29.setBackground(new Color(255, 235, 205));
		toggleButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_29).isSelected()) {
					seat.add("s31");
					count++;
					toggleButton_29.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s31");
						count--;
						//seat[i]=null;
						toggleButton_29.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_29.setBounds(412, 78, 39, 23);
		toggleButton_29.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_29);
		
		toggleButton_30 = new JToggleButton("");
		toggleButton_30.setBackground(new Color(255, 235, 205));
		toggleButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_30).isSelected()) {
					seat.add("s30");
					count++;
					toggleButton_30.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("s30");
						count--;
						//seat[i]=null;
						toggleButton_30.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_30.setBounds(414, 106, 39, 23);
		toggleButton_30.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_30);
		
		toggleButton_31 = new JToggleButton("");
		toggleButton_31.setBackground(new Color(255, 235, 205));
		toggleButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((toggleButton_10).isSelected()) {
					seat.add("sw29");
					count++;
					toggleButton_31.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
					}
					else {
						seat.remove("sw29");
						count--;
						//seat[i]=null;
						toggleButton_31.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
					}
			}
		});
		toggleButton_31.setBounds(414, 140, 39, 23);
		toggleButton_31.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		panel_1.add(toggleButton_31);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\unselected.png"));
		label_2.setBounds(46, 20, 25, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\wheel.jpg"));
		label_3.setBounds(11, 20, 25, 14);
		panel_1.add(label_3);
		
		
		
		
		JButton btnBookSeat = new JButton("Book Seat");
		btnBookSeat.setBackground(new Color(216, 191, 216));
		btnBookSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					st = String.join(",", seat);
				   textField.setText(st);
				   String p = Integer.toString(count);
				   textField_1.setText(p);
				   BusBooking.textField_3.setText(textField_1.getText());
				   BusBooking.textField_4.setText(textField.getText());
				   frame.dispose();
				}
		});
		btnBookSeat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBookSeat.setBounds(646, 208, 96, 23);
		frame.getContentPane().add(btnBookSeat);
		
		textField = new TextField();
		textField.setBounds(516, 136, 205, 22);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(526, 170, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblViewSeatAllocation = new JLabel("View Seat Allocation");
		lblViewSeatAllocation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblViewSeatAllocation.setBounds(343, 26, 205, 14);
		frame.getContentPane().add(lblViewSeatAllocation);
		
		ButtonGroup bu = new ButtonGroup();
		
		rdbtnSleeperBus = new JRadioButton("Sleeper Bus");
		rdbtnSleeperBus.setBackground(new Color(216, 191, 216));
		rdbtnSleeperBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
				PreparedStatement pst;
				String pt="";
				try{
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement("select seat_numb, journey_date from BUSRESERVE r, BUS  b  where b.bus_id = r.bus_id  and b.bus_id =? and journey_date = ?");
					pst.setString(1, v);
					pst.setString(2, u);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()) {
						do{
								seatno.add(rs.getString("seat_numb"));
							    pt = String.join(",", seatno);
							
						}while(rs.next());
						String[] output  =  pt.split(",");
						for(int i=0;i<output.length;i++)
						{
						   if(output[i].equals("ss1")) {
								toggleButton_32.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_32.setEnabled(false);
							}
						   if(output[i].equals("ss2")) {
								toggleButton_33.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_33.setEnabled(false);
							}
						   if(output[i].equals("ss3")) {
								toggleButton_34.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_34.setEnabled(false);
							}
						   if(output[i].equals("ss4")) {
								toggleButton_35.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_35.setEnabled(false);
							}
						   if(output[i].equals("ss5")) {
								toggleButton_39.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_39.setEnabled(false);
							}
						   if(output[i].equals("ss6")) {
								toggleButton_38.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_38.setEnabled(false);
							}
						   if(output[i].equals("ss7")) {
								toggleButton_37.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_37.setEnabled(false);
							}
						   if(output[i].equals("ss8")) {
								toggleButton_36.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_36.setEnabled(false);
							}
						   if(output[i].equals("ss9")) {
								toggleButton_40.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_40.setEnabled(false);
							}
						   if(output[i].equals("ss10")) {
								toggleButton_41.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_41.setEnabled(false);
							}
						   if(output[i].equals("ss11")) {
								toggleButton_42.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_42.setEnabled(false);
							}
						   if(output[i].equals("ss12")) {
								toggleButton_43.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_43.setEnabled(false);
							}
						   if(output[i].equals("ss13")) {
								toggleButton_47.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_47.setEnabled(false);
							}
						   if(output[i].equals("ss14")) {
								toggleButton_46.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_46.setEnabled(false);
							}
						   if(output[i].equals("ss15")) {
								toggleButton_45.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_45.setEnabled(false);
							}
						   if(output[i].equals("ss16")) {
								toggleButton_44.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_44.setEnabled(false);
							}
						   if(output[i].equals("ss17")) {
								toggleButton_48.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_48.setEnabled(false);
							}
						   if(output[i].equals("ss18")) {
								toggleButton_49.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_49.setEnabled(false);
							}
						   if(output[i].equals("ss19")) {
								toggleButton_50.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_50.setEnabled(false);
							}
						   if(output[i].equals("ss20")) {
								toggleButton_51.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_51.setEnabled(false);
							}
						}
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		rdbtnSleeperBus.setBounds(516, 74, 83, 23);
		bu.add(rdbtnSleeperBus);
		frame.getContentPane().add(rdbtnSleeperBus);
		
		rdbtnNonSleeperBus = new JRadioButton("Non Sleeper Bus");
		rdbtnNonSleeperBus.setBackground(new Color(216, 191, 216));
		rdbtnNonSleeperBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				//Busseat();
				PreparedStatement pst;
				String pt="";
				try{
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement("select seat_numb, journey_date from BUSRESERVE r, BUS  b  where b.bus_id = r.bus_id and b.bus_id =? and journey_date = ?");
					pst.setString(1, v);
					pst.setString(2, u);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()) {
						do{
								seatno.add(rs.getString("seat_numb"));
								pt = String.join(",", seatno);
						}while(rs.next());
						String[] output  =  pt.split(",");
						for(int i=0;i<output.length;i++)
						{
						
						   if(output[i].equals("sw8")) {
								toggleButton_6.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_6.setEnabled(false);
							}
						   if(output[i].equals("sw9")) {
								toggleButton_7.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_7.setEnabled(false);
							}
						   if(output[i].equals("s2")) {
								toggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton.setEnabled(false);
							}
						   if(output[i].equals("s3")) {
								toggleButton_1.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_1.setEnabled(false);
							}
						   if(output[i].equals("s7")) {
								toggleButton_5.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_5.setEnabled(false);
							}
						   if(output[i].equals("s6")) {
								toggleButton_4.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_4.setEnabled(false);
							}
						   if(output[i].equals("s11")) {
								toggleButton_9.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_9.setEnabled(false);
							}
						   if(output[i].equals("s10")) {
								toggleButton_8.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_8.setEnabled(false);
							}
						   if(output[i].equals("sw4")) {
								toggleButton_2.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_2.setEnabled(false);
							}
						   if(output[i].equals("sw5")) {
								toggleButton_3.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
								toggleButton_3.setEnabled(false);
							}
						   if(output[i].equals("sw1")) {
							   tglbtnNewToggleButton.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   tglbtnNewToggleButton.setEnabled(false);
							}
						   if(output[i].equals("sw12")) {
							   toggleButton_10.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_10.setEnabled(false);
							}
						   if(output[i].equals("s13")) {
							   toggleButton_14.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_14.setEnabled(false);
							}
						   if(output[i].equals("s14")) {
							   toggleButton_13.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_13.setEnabled(false);
							}
						   if(output[i].equals("s15")) {
							   toggleButton_12.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_12.setEnabled(false);
							}
						   if(output[i].equals("sw16")) {
							   toggleButton_11.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_11.setEnabled(false);
							}
						   if(output[i].equals("sw17")) {
							   toggleButton_18.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_18.setEnabled(false);
							}
						   if(output[i].equals("s18")) {
							   toggleButton_17.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_17.setEnabled(false);
							}
						   if(output[i].equals("s19")) {
							   toggleButton_16.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_16.setEnabled(false);
							}
						   if(output[i].equals("sw20")) {
							   toggleButton_15.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_15.setEnabled(false);
							}
						   if(output[i].equals("sw21")) {
							   toggleButton_22.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_22.setEnabled(false);
							}
						   if(output[i].equals("s22")) {
							   toggleButton_21.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_21.setEnabled(false);
							}
						   if(output[i].equals("s23")) {
							   toggleButton_20.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_20.setEnabled(false);
							}
						   if(output[i].equals("sw24")) {
							   toggleButton_19.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_19.setEnabled(false);
							}
						   if(output[i].equals("sw25")) {
							   toggleButton_26.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_26.setEnabled(false);
							}
						   if(output[i].equals("s26")) {
							   toggleButton_25.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_25.setEnabled(false);
							}
						   if(output[i].equals("s27")) {
							   toggleButton_24.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_24.setEnabled(false);
							}
						   if(output[i].equals("sw28")) {
							   toggleButton_23.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_23.setEnabled(false);
							}
						   if(output[i].equals("sw29")) {
							   toggleButton_31.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_31.setEnabled(false);
							}
						   if(output[i].equals("s30")) {
							   toggleButton_30.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_30.setEnabled(false);
							}
						   if(output[i].equals("s31")) {
							   toggleButton_29.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_29.setEnabled(false);
							}
						   if(output[i].equals("s32")) {
							   toggleButton_28.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_28.setEnabled(false);
							}
						   if(output[i].equals("sw33")) {
							   toggleButton_27.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\selected.png"));
							   toggleButton_27.setEnabled(false);
							}
						   
						
						}
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		rdbtnNonSleeperBus.setBounds(616, 77, 105, 23);
		bu.add(rdbtnNonSleeperBus);
		frame.getContentPane().add(rdbtnNonSleeperBus);
		
		rdbtnSleeperBus.setEnabled(false);
		rdbtnNonSleeperBus.setEnabled(false);
		
		btextField_2 = new JTextField();
		btextField_2.setEditable(false);
		btextField_2.setBounds(537, 104, 96, 20);
		frame.getContentPane().add(btextField_2);
		btextField_2.setColumns(10);
		btextField_2.setText(v);
		disradio();
		
		
			
		
		
	}
}
