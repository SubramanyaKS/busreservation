import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class Ticket {

	private JFrame frame;
	private JComboBox<String> comboBox;
	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					Ticket window = new Ticket(u);
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
	public Ticket(String u) {
		initialize(u);
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
	private void initialize(String u) {
		frame = new JFrame();
		frame.setBounds(100, 100, 769, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setBackground(new Color(240, 230, 140));
		textArea.setBounds(428, 21, 315, 407);
		frame.getContentPane().add(textArea);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText(u);
		textField.setBounds(188, 56, 110, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(99, 165, 96, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(315, 165, 96, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(99, 213, 96, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(322, 213, 96, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(99, 272, 96, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(322, 272, 96, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(99, 332, 96, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(322, 332, 96, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con = new DBConnection();
					PreparedStatement pst;
					String query = "select r.source, r.destination, b.dep_time, b.ar_time, r.seat_numb, r.journey_date, b.price, r.total_price \r\n" + 
							"from BUS b, PASSENGER p, BUSRESERVE r\r\n" + 
							"where b.bus_id = r.bus_id and r.passenger_id= p.passenger_id and p.passen_name =? and r.reserve_id = ?";
					pst = con.mkDataBase().prepareStatement(query);
					pst.setString(1, u);
					pst.setString(2,(String)comboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						textField_1.setText(rs.getString("source"));
						textField_2.setText(rs.getString("destination"));
						textField_3.setText(rs.getString("dep_time"));
						textField_4.setText(rs.getString("ar_time"));
						textField_5.setText(rs.getString("seat_numb"));
						textField_6.setText(rs.getString("journey_date"));
						textField_7.setText(rs.getString("price"));
						textField_8.setText(rs.getString("total_price"));
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		comboBox.setBounds(188, 99, 96, 22);
		frame.getContentPane().add(comboBox);
		Combo1(u);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a =Integer.parseInt((String)comboBox.getSelectedItem()) ;
				textArea.setText("---------------------------------------------------------------------------------\n");
				textArea.setText(textArea.getText()+"----------------------------RESERVATION TICKET-----------------------\n");
				textArea.setText(textArea.getText()+"------------------------------------------------------------------------------\n");
				textArea.setText(textArea.getText()+"Passenger Name  :"+textField.getText()+"\n");
				textArea.setText(textArea.getText()+"Reserve ID      :"+a+"\n");
				textArea.setText(textArea.getText()+"Source          :"+textField_1.getText()+"\t"+"  Destination     :"+textField_2.getText()+"\n");
				textArea.setText(textArea.getText()+"Departure Time  :"+textField_3.getText()+"\t"+"  Arrival Time    :"+textField_4.getText()+"\n");
				textArea.setText(textArea.getText()+"Seat Number     :"+textField_5.getText()+"\n");
				textArea.setText(textArea.getText()+"Journey Date    :"+textField_6.getText()+"\n");
				textArea.setText(textArea.getText()+"Price           :"+textField_7.getText()+"\n");
				textArea.setText(textArea.getText()+"Total Price     :"+textField_8.getText()+"\n");
				textArea.setText(textArea.getText()+"------------------------------------------------------------------------------\n");
				textArea.setText(textArea.getText()+"--------------------------HAPPY JOURNEY--------------------------------\n");
				textArea.setText(textArea.getText()+"------------------------------------------------------------------------------\n");
				
			}
			
		});
		btnGenerate.setBounds(10, 405, 89, 23);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
					frame.dispose();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(322, 405, 89, 23);
		frame.getContentPane().add(btnPrint);
		
		
		JLabel lblPassengerName = new JLabel("Passenger Name");
		lblPassengerName.setBounds(48, 59, 117, 14);
		frame.getContentPane().add(lblPassengerName);
		
		JLabel lblReserveId = new JLabel("Reserve ID");
		lblReserveId.setBounds(48, 103, 75, 14);
		frame.getContentPane().add(lblReserveId);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(21, 168, 48, 14);
		frame.getContentPane().add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(237, 168, 75, 14);
		frame.getContentPane().add(lblDestination);
		
		JLabel lblSeatNumber = new JLabel("Seat Number");
		lblSeatNumber.setBounds(10, 275, 75, 14);
		frame.getContentPane().add(lblSeatNumber);
		
		JLabel lblJourneyDate = new JLabel("Journey Date");
		lblJourneyDate.setBounds(223, 275, 89, 14);
		frame.getContentPane().add(lblJourneyDate);
		
		JLabel lblDepartureTime = new JLabel("Departure Time");
		lblDepartureTime.setBounds(10, 219, 89, 14);
		frame.getContentPane().add(lblDepartureTime);
		
		JLabel lblArivalTime = new JLabel("Arival  Time");
		lblArivalTime.setBounds(236, 216, 76, 14);
		frame.getContentPane().add(lblArivalTime);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 335, 48, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(223, 332, 82, 14);
		frame.getContentPane().add(lblTotalPrice);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(158, 405, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTicket.setBounds(281, 11, 130, 23);
		frame.getContentPane().add(lblTicket);
	}
}
