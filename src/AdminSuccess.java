import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminSuccess {

	private JFrame frame;
	private JTable table;
	private JLabel Label_1;
	private JLabel label;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					AdminSuccess window = new AdminSuccess(u);
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
							int day = cal.get(Calendar.DAY_OF_MONTH);
							int  month = (cal.get(Calendar.MONTH)+1);
							int year = cal.get(Calendar.YEAR);
							label.setText("Date  "+day+"  - "+month+" - "+year);
						
							int minute = cal.get(Calendar.MINUTE);
							int hour = cal.get(Calendar.HOUR);
							Label_1.setText("Time  "+hour+" : "+minute);
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
	public AdminSuccess(String u) {
		initialize(u);
		lblNewLabel.setText("Welcome "+u);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 787, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnManageAdmin = new JMenu("Manage Admin");
		mnManageAdmin.setBackground(Color.BLACK);
		menuBar.add(mnManageAdmin);
		
		Label_1 = new JLabel("");
		Label_1.setBounds(582, 56, 124, 14);
		frame.getContentPane().add(Label_1);
		
		JMenuItem mntmAddAdmin = new JMenuItem("Add Admin");
		mntmAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegistration.main(new String[]{});
				frame.dispose();
			}
		});
		mnManageAdmin.add(mntmAddAdmin);
		
		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(582, 21, 124, 14);
		frame.getContentPane().add(label);
		clock();
		
		JMenuItem mntmViewAdmin = new JMenuItem("View Admin");
		mntmViewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select admin_id, admin_Name, email, anumber from ADMIN";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
				
			}
		});
		mnManageAdmin.add(mntmViewAdmin);
		
		JMenuItem mntmDeleteAdmin = new JMenuItem("Delete Admin");
		mntmDeleteAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAdmin.main(new String[]{});
				frame.dispose();
			}
		});
		mnManageAdmin.add(mntmDeleteAdmin);
		JMenu mnManagePassenger = new JMenu("Manage Passenger");
		menuBar.add(mnManagePassenger);
		
		JMenuItem mntmAddPassenger = new JMenuItem("Add Passenger");
		mntmAddPassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerRegister.main(new String[]{});
				frame.dispose();
			}
		});
		mnManagePassenger.add(mntmAddPassenger);
		
		JMenuItem mntmEditPassenger = new JMenuItem("View Passenger");
		mntmEditPassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select passenger_id,passen_name,address,dateob,gender,city,cnumber,emailid from PASSENGER";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		mnManagePassenger.add(mntmEditPassenger);
		
		JMenuItem mntmDeletePassenger = new JMenuItem("Delete Passenger");
		mntmDeletePassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePassenger.main(new String[]{});
			}
		});
		mnManagePassenger.add(mntmDeletePassenger);
		
		JMenuItem mntmViewFeedback = new JMenuItem("View Feedback");
		mntmViewFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select f.passenger_id, p.passen_name, f.pfeedback from passenger p join feedback f on f.passenger_id = p.passenger_id";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			
		});
		mnManagePassenger.add(mntmViewFeedback);
		
		JMenu mnManageProfile = new JMenu("Manage Profile");
		menuBar.add(mnManageProfile);
		
		JMenuItem mntmChangePassword_1 = new JMenuItem("Change Password");
		mntmChangePassword_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ChangePassword.rdbtnPassenger.setEnabled(false);
				String o="a";
				ChangePassword.main(new String[]{o});
				//ChangePassword.rdbtnPassenger.setEnabled(false);
				frame.dispose();
			}
		});
		
		JMenuItem mntmMyProfile = new JMenuItem("My Profile");
		mntmMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditAdminProfile.main(new String[]{u});
			}
		});
		mnManageProfile.add(mntmMyProfile);
		mnManageProfile.add(mntmChangePassword_1);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});
				frame.dispose();
			}
			
		});
		mnManageProfile.add(mntmLogOut);
		
		JMenu mnRoute = new JMenu("Route");
		menuBar.add(mnRoute);
		
		JMenuItem mntmAddRoute = new JMenuItem("Add Route");
		mntmAddRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBusRoute.main(new String[]{});
			}
		});
		mnRoute.add(mntmAddRoute);
		
		JMenuItem mntmViewRoute = new JMenuItem("View Route");
		mntmViewRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select * from BUSROUTE";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
				
			}
		});
		mnRoute.add(mntmViewRoute);
		
		JMenuItem mntmDeleteRoute = new JMenuItem("Delete Route");
		mntmDeleteRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBusroute.main(new String[]{});
			}
		});
		mnRoute.add(mntmDeleteRoute);
		
		JMenu mnBus = new JMenu("Bus");
		menuBar.add(mnBus);
		
		JMenuItem mntmAddBus = new JMenuItem("Add Bus");
		mntmAddBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBus.main(new String[]{});
			}
		});
		mnBus.add(mntmAddBus);
		
		JMenuItem mntmDeleteBus = new JMenuItem("Delete Bus");
		mntmDeleteBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBus.main(new String[]{});
			}
		});
		mnBus.add(mntmDeleteBus);
		
		JMenuItem mntmViewBus = new JMenuItem("View Bus");
		mntmViewBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select * from BUS";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		mnBus.add(mntmViewBus);
		
		JMenuItem mntmViewReservation = new JMenuItem("View Reservation");
		mntmViewReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select * from BUSRESERVE";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			
		});
		mnBus.add(mntmViewReservation);
		
		JMenu mnPayment = new JMenu("Payment");
		menuBar.add(mnPayment);
		
		JMenuItem mntmPaymentDetails = new JMenuItem("Payment details");
		mntmPaymentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select * from PAYDETAILS";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		mnPayment.add(mntmPaymentDetails);
		
		JMenuItem mntmOnlinePaymentAmount = new JMenuItem("Online Payment amount");
		mntmOnlinePaymentAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select SUM(amount) from PAYDETAILS";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						
						JOptionPane.showMessageDialog(null,"Total Amount collected through Online Payment is Rs."+rs.getString("SUM(amount)"));
					}
					
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmTotalPayement = new JMenuItem("Total Payement");
		mntmTotalPayement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select SUM(total_price) from BUSRESERVE";
					pst = con.mkDataBase().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						
						JOptionPane.showMessageDialog(null,"Total Amount collected  is Rs."+rs.getString("SUM(total_price)"));
					}
					
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		mnPayment.add(mntmTotalPayement);
		mnPayment.add(mntmOnlinePaymentAmount);
		
		JMenuItem mntmDayPayment = new JMenuItem("day Payment");
		mntmDayPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPaymentDetails.main(new String[]{});
			}
		});
		mnPayment.add(mntmDayPayment);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 725, 158);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.CYAN);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(20, 21, 189, 32);
		frame.getContentPane().add(lblNewLabel);
	}
}
