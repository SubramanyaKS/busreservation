import java.awt.EventQueue;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

public class BusBooking {

	private JFrame frame;
	private JLabel label_1;
	private  JLabel label;
	public static JComboBox<String> comboBox_1;
	private JDateChooser dateChooser;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					BusBooking window = new BusBooking(u);
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
	public BusBooking(String u) {
		initialize(u);
		clock();
	}
	
	public void Combo1(){
		
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select bus_id from BUS";
			pst = con.mkDataBase().prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			
				comboBox_1.addItem(rs.getString("bus_id"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void clock() {
		Thread clock = new Thread()
		{
				public void run()
				{
					try {
						while(true)
						{
							Calendar cal = new GregorianCalendar();
							int day = cal.get(Calendar.DAY_OF_MONTH);
							int  month = (cal.get(Calendar.MONTH)+1);
							int year = cal.get(Calendar.YEAR);
							label.setText("Date  "+day+"  - "+month+" - "+year);
						
							int minute = cal.get(Calendar.MINUTE);
							int hour = cal.get(Calendar.HOUR);
							label_1.setText("Time  "+hour+" : "+minute);
							sleep(1000);
				
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
		};
		clock.start();
		
	}
	
	/**
	 * function for auto increment of Reserve id
	 */
	public void autoreserve() {
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select Max(reserve_id) from BUSRESERVE";
			pst = con.mkDataBase().prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			rs.getString("Max(reserve_id)");
			if(rs.getString("Max(reserve_id)")==null)
			{
				textField.setText("Max(reserve_id)");
			}
			else {
				int id =  Integer.parseInt(rs.getString("max(reserve_id)"));
				id++;
				String a = Integer.toString(id);
				textField.setText(a);
			}
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(253, 245, 230));
		frame.setBounds(100, 100, 791, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBackground(new Color(253, 245, 230));
		textField.setEditable(false);
		textField.setBounds(496, 57, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		autoreserve();
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(199, 173, 112, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblReserveid = new JLabel("Reserve ID");
		lblReserveid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReserveid.setBounds(158, 60, 96, 14);
		frame.getContentPane().add(lblReserveid);
		
		JLabel lblBusId = new JLabel("Bus ID");
		lblBusId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBusId.setBounds(158, 127, 48, 14);
		frame.getContentPane().add(lblBusId);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(598, 173, 113, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(199, 209, 112, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(608, 209, 113, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(158, 307, 96, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(253, 245, 230));
		textField_7.setEditable(false);
		textField_7.setBounds(496, 92, 134, 20);
		frame.getContentPane().add(textField_7);
		//textField_7.setText(u);
		textField_7.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(476, 241, 124, 20);
		//dateChooser.setSelectableDateRange(arg0, arg1);
		frame.getContentPane().add(dateChooser);
		
		try {
			String q = "Select passenger_id from Passenger where passen_Name= ?";
			PreparedStatement pst;
			DBConnection con=new DBConnection();
			pst = con.mkDataBase().prepareStatement(q);
			pst.setString(1,u);
			//System.out.print(u);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				textField_7.setText(rs.getString("passenger_id"));
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
		JLabel lblSeatsRequired = new JLabel("Seats Required");
		lblSeatsRequired.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeatsRequired.setBounds(44, 212, 135, 14);
		frame.getContentPane().add(lblSeatsRequired);
		
		JButton btnViewSeat = new JButton("View Seat");
		btnViewSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
						String v =(String)comboBox_1.getSelectedItem();
						SimpleDateFormat at = new SimpleDateFormat("yyy-MM-dd");
						String  jodate = at.format(dateChooser.getDate()); 
						String current = at.format(new Date());;
						Date d1 = at.parse(jodate);
						Date d2 = at.parse(current);
						if(d1.compareTo(d2)>0 )
							SeatBooking.main(new String[] {jodate,v});
						else
						{
							dateChooser.setCalendar(null);
						}
	              } catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnViewSeat.setBounds(622, 268, 89, 23);
		frame.getContentPane().add(btnViewSeat);
		
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reserve_id=Integer.parseInt(textField.getText());
				int passen_id=Integer.parseInt(textField_7.getText());
				int a =Integer.parseInt((String)comboBox_1.getSelectedItem()) ;
	            String source = textField_1.getText();
	            String destination = textField_2.getText();
	            int seat_r = Integer.parseInt(textField_3.getText());
	            String seat_n = textField_4.getText();
	            SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
                String  jdate = df.format(dateChooser.getDate());
	            String total_price  = textField_6.getText();
	            String query ="Insert into BUSRESERVE (reserve_id, bus_id, source, destination, seat_reserve,seat_numb,journey_date,total_price,passenger_id) values(?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst;
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement(query);
					pst.setInt(1,reserve_id);
					pst.setInt(2,a);
					pst.setString(3,source);
					pst.setString(4,destination);
					pst.setInt(5,seat_r);
					pst.setString(6,seat_n);
					pst.setString(7,jdate);
					pst.setString(8,total_price);
					pst.setInt(9,passen_id);
					pst.executeQuery();
					JOptionPane.showMessageDialog(btnReserve, "Booked  successfully please do payment : ");
					//Passenger.main(new String[]{});
					//frame.dispose();
					}catch(Exception exception){
						JOptionPane.showMessageDialog(btnReserve, "Booked  unsuccessfully please try again : ");
					}
					
			}
		});
		btnReserve.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReserve.setBounds(257, 347, 89, 23);
		frame.getContentPane().add(btnReserve);
		
		comboBox_1 = new JComboBox<>();
		comboBox_1.setBackground(new Color(255, 222, 173));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con = new DBConnection();
					PreparedStatement pst;
					
					String query = "select  dstation,astation,price from BUSROUTE r, BUS b where r.route_id = b.route_id and b.bus_id = ?";
					pst = con.mkDataBase().prepareStatement(query);
					pst.setString(1,(String)comboBox_1.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						textField_1.setText(rs.getString("dstation"));
						textField_2.setText(rs.getString("astation"));
						textField_5.setText(rs.getString("price"));
					
						
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		comboBox_1.setBounds(496, 123, 134, 22);
		frame.getContentPane().add(comboBox_1);
		Combo1();
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSource.setBounds(68, 176, 48, 14);
		frame.getContentPane().add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDestination.setBounds(380, 176, 96, 14);
		frame.getContentPane().add(lblDestination);
		
		JLabel lblReservation = new JLabel("Bus Booking");
		lblReservation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblReservation.setBounds(299, 11, 199, 27);
		frame.getContentPane().add(lblReservation);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setBounds(68, 310, 48, 14);
		frame.getContentPane().add(lblPrice);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.setBackground(new Color(255, 228, 181));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt( textField_3.getText());
					int b= Integer.parseInt(textField_5.getText());
					String c = String.valueOf(a*b);
						textField_6.setText(c);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnTotal.setBounds(299, 306, 78, 23);
		frame.getContentPane().add(btnTotal);
	
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalPrice.setBounds(420, 310, 89, 14);
		frame.getContentPane().add(lblTotalPrice);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnReset.setBounds(409, 421, 89, 23);
		frame.getContentPane().add(btnReset);
		
		
		
		JLabel lblJourneyDate = new JLabel("Journey Date");
		lblJourneyDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJourneyDate.setBounds(158, 247, 89, 14);
		frame.getContentPane().add(lblJourneyDate);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBackground(new Color(253, 245, 230));
		textField_6.setBounds(598, 307, 96, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblSeatNumbers = new JLabel("Seat numbers");
		lblSeatNumbers.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeatNumbers.setBounds(380, 212, 81, 14);
		frame.getContentPane().add(lblSeatNumbers);
		
		ButtonGroup bu = new ButtonGroup();
		
		JLabel lblPassengerId = new JLabel("Passenger ID");
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassengerId.setBounds(158, 102, 89, 14);
		frame.getContentPane().add(lblPassengerId);
		
		JRadioButton rdbtnThroughOnline = new JRadioButton("through online");
		rdbtnThroughOnline.setBackground(new Color(255, 248, 220));
		rdbtnThroughOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment.main(new String[] {textField_6.getText(),textField.getText()});
			}
		});
		rdbtnThroughOnline.setBounds(519, 378, 109, 23);
		bu.add(rdbtnThroughOnline);
		frame.getContentPane().add(rdbtnThroughOnline);
		
		JLabel lblL = new JLabel("Payment");
		lblL.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblL.setBounds(199, 381, 78, 14);
		frame.getContentPane().add(lblL);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("through Cash");
		rdbtnNewRadioButton.setBackground(new Color(255, 239, 213));
		rdbtnNewRadioButton.setBounds(355, 378, 109, 23);
		bu.add(rdbtnNewRadioButton);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) { 
					  frame.dispose();
                } 
				else if (rdbtnThroughOnline.isSelected()) { 
					frame.dispose();
                }
                else {
                	 
                }
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDone.setBounds(222, 421, 89, 23);
		frame.getContentPane().add(btnDone);
		
		label = new JLabel("");
		label.setBounds(622, 21, 130, 22);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(663, 54, 89, 20);
		frame.getContentPane().add(label_1);
		
	
		
		
		
		
	}
}
