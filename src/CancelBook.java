import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelBook {

	private JFrame frame;
	private JComboBox<String> comboBox;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					String d = args[1];
					CancelBook window = new CancelBook(u,d);
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
	public CancelBook(String u,String d) {
		initialize(u,d);
	}
	
public void Combo1(String u){
		
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select reserve_id from BUSRESERVE r,PASSENGER p where r.passenger_id=p.passenger_id and p.passen_name =?";
			pst = con.mkDataBase().prepareStatement(query);
			pst.setString(1,u);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			
				comboBox.addItem(rs.getString("reserve_id"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u, String d) {
		frame = new JFrame();
		frame.setBackground(Color.YELLOW);
		frame.setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 575, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(364, 70, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
				textField.setText(rs.getString("passenger_id"));
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(364, 186, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con = new DBConnection();
					PreparedStatement pst;
					String query = "select  journey_date from BUSRESERVE r, PASSENGER p where p.passenger_id = r.passenger_id and r.reserve_id = ?";
					pst = con.mkDataBase().prepareStatement(query);
					pst.setString(1,(String)comboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						textField_1.setText(rs.getString("journey_date"));
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		comboBox.setBounds(364, 124, 96, 22);
		frame.getContentPane().add(comboBox);
		Combo1(u);
		
		JLabel lblJourneyDate = new JLabel("Journey date");
		lblJourneyDate.setBounds(77, 189, 72, 14);
		frame.getContentPane().add(lblJourneyDate);
		
		JLabel lblPassengerid = new JLabel("Passenger_id");
		lblPassengerid.setBounds(77, 73, 78, 14);
		frame.getContentPane().add(lblPassengerid);
		
		JLabel lblNewLabel = new JLabel("Reserve_id");
		lblNewLabel.setBounds(77, 128, 78, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
					Date date1 = sdf.parse(d);
					Date date2 = sdf.parse(textField_1.getText());
					if(date1.compareTo(date2)<0)
					{	
						String q = "Delete from BUSRESERVE where passenger_id= ? and reserve_id=? and journey_date=?";
						PreparedStatement pst;
						DBConnection con=new DBConnection();
						int pid = Integer.parseInt(textField.getText());
						int rid = Integer.parseInt((String)comboBox.getSelectedItem());
						String jdate = textField_1.getText();
						pst = con.mkDataBase().prepareStatement(q);
						pst.setInt(1,pid);
						pst.setInt(2,rid);
						pst.setString(3,jdate);
						pst.execute();
						JOptionPane.showMessageDialog(btnCancelBooking, "Booking Cancellation is done . Please Recollect your Money. ");
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(btnCancelBooking, "Cancellation is not Possible");
						textField_1.setText("");
						
					}
					}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
		});
		btnCancelBooking.setBounds(219, 275, 130, 33);
		frame.getContentPane().add(btnCancelBooking);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 11, 539, 33);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBookingCancel = new JLabel("Booking Cancel");
		lblBookingCancel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblBookingCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingCancel.setBounds(0, 0, 539, 33);
		panel.add(lblBookingCancel);
		
		
		
		
	}
}
