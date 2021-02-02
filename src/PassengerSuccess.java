import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;

public class PassengerSuccess {

	private JFrame frame;
	private JLabel lblWelcome;
	private JLabel label_1;
	private JTable table;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					PassengerSuccess window = new PassengerSuccess(u);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	 * Create the application.
	 */
	public PassengerSuccess(String u) {
		initialize(u);
		lblWelcome.setText("Hi "+u);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 247, 551, 171);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(0, 255, 255));
		scrollPane.setViewportView(table);
		
		
	   clock();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 787, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label_1 = new JLabel();
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(564, 62, 107, 30);
		frame.getContentPane().add(label_1);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(240, 230, 140));
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setBounds(528, 126, 208, 104);
		frame.getContentPane().add(textArea);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(564, 21, 107, 30);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d = sdf.format(date);
		label.setText(d);
		frame.getContentPane().add(label);
		
		lblWelcome = new JLabel("Hi");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(174, 21, 265, 30);
		frame.getContentPane().add(lblWelcome);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnManageProfile = new JMenu("Manage Profile");
		menuBar.add(mnManageProfile);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String o="p";
				ChangePassword.main(new String[]{o});
				frame.dispose();
			}
		});
		
		JMenuItem mntmMyProfile = new JMenuItem("MY Profile");
		mntmMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPassengerProfile.main(new String[]{u});
			}
		});
		mnManageProfile.add(mntmMyProfile);
		mnManageProfile.add(mntmChangePassword);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerLogin.main(new String[]{});
				frame.dispose();
			}
		});
		mnManageProfile.add(mntmLogOut);
		
		JMenu mnNewMenu = new JMenu("Feedback");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Feedback");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feedback.main(new String[]{u});
			}
			
		});
		
		JMenu mnTicket = new JMenu("Ticket");
		menuBar.add(mnTicket);
		
		JMenuItem mntmBookATicket = new JMenuItem("Book a  Ticket");
		mntmBookATicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusBooking.main(new String[]{u});
			}
		});
		mnTicket.add(mntmBookATicket);
		
		JMenuItem mntmViewBusDetails = new JMenuItem("View Bus Details");
		mntmViewBusDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select * from BUSDETAILS";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmPrintTicket = new JMenuItem("Print Ticket");
		mntmPrintTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket.main(new String[]{u});
			}
		});
		mnTicket.add(mntmPrintTicket);
		mnTicket.add(mntmViewBusDetails);
		
		JMenuItem mntmViewMyBooking = new JMenuItem("View My Booking Details");
		mntmViewMyBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select bb.reserve_id ,bb.source, bb.destination, bb.seat_reserve,bb.journey_date,bb.seat_numb,b.price,bb.total_price from BUSRESERVE bb,BUS b ,PASSENGER p where bb.bus_id = b.bus_id and bb.passenger_id = p.passenger_id and p.passen_name = ?";
					pst = con.mkDataBase().prepareStatement(query);
					pst.setString(1,u);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		mnTicket.add(mntmViewMyBooking);
		
		JMenuItem mntmCancelMyBooking = new JMenuItem("Cancel My Booking");
		mntmCancelMyBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelBook.main(new String[]{u,d});
			}
		});
		mnTicket.add(mntmCancelMyBooking);
		
		JMenu mnContact = new JMenu("contact");
		menuBar.add(mnContact);
		
		JMenuItem mntmContactUs = new JMenuItem("Contact us");
		mntmContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setEnabled(true);
				textArea.setText("---------------------------------------------------------------------------------\n");
				textArea.setText(textArea.getText()+"----------------------------Contact us-----------------------\n");
				textArea.setText(textArea.getText()+"Subramanya KS\n");
				textArea.setText(textArea.getText()+"Phone Number: 9535290710\n");
				textArea.setText(textArea.getText()+"email: Subbu2000@gmail.com\n");
				textArea.setText(textArea.getText()+"---------------------------------------------------------------\n");
			
			}
		});
		mnContact.add(mntmContactUs);
	}
}
