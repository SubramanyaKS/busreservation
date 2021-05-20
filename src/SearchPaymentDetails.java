import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class SearchPaymentDetails {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JLabel lblTotalAmountOn;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPaymentDetails window = new SearchPaymentDetails();
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
	public SearchPaymentDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 537, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(270, 148, 129, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(252, 46, 129, 20);
		frame.getContentPane().add(dateChooser);
		

		
		JLabel lblDate = new JLabel("select the Date to search");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(33, 81, 177, 20);
		frame.getContentPane().add(lblDate);
		
		JLabel lblNoOfReservation = new JLabel("No of reservation on that day");
		lblNoOfReservation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfReservation.setBounds(33, 143, 229, 29);
		frame.getContentPane().add(lblNoOfReservation);
		
		textField_1 = new JTextField();
		textField_1.setBounds(270, 206, 129, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		textField_2 = new JTextField();
		textField_2.setBounds(220, 255, 264, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(230, 286, 139, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAverageAmount = new JLabel("Average Amount");
		lblAverageAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAverageAmount.setBounds(33, 286, 177, 14);
		frame.getContentPane().add(lblAverageAmount);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(252, 102, 129, 20);
		frame.getContentPane().add(dateChooser_1);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat at = new SimpleDateFormat("yyy-MM-dd");
				String  jodate1 = at.format(dateChooser.getDate()); 
				String  jodate2 = at.format(dateChooser_1.getDate());

				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					String query ="select sum(seat_reserve), sum(total_price),avg(total_price),round(avg(total_price)) from BUSRESERVE where journey_date between ? and ?";
					pst = con.mkDataBase().prepareStatement(query);
					pst.setString(1,jodate1);
					pst.setString(2,jodate2);
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						textField.setText(rs.getString("sum(seat_reserve)"));
						textField_1.setText(rs.getString("sum(total_price)"));
						textField_2.setText(rs.getString("avg(total_price)"));
						textField_3.setText(rs.getString("round(avg(total_price))"));
					}
					
				}catch (Exception exception) {
					exception.printStackTrace();
				}
				
			
			}
			
		});
		btnNewButton.setBounds(395, 66, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		lblTotalAmountOn = new JLabel("Total Amount on that day");
		lblTotalAmountOn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalAmountOn.setBounds(33, 205, 166, 20);
		frame.getContentPane().add(lblTotalAmountOn);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" "); 
				textField_3.setText(" "); 
				dateChooser.setCalendar(null);
				dateChooser_1.setCalendar(null);
			}
		});
		btnReset.setBounds(310, 396, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton button = new JButton("<-- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(10, 396, 89, 23);
		frame.getContentPane().add(button);
		
		
		
		
		
		
	}
}
