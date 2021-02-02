import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class PassengerRegister {

	private JFrame frame;
	private JTextField passenger_id;
	private JTextField passen_name;
	private JTextField email;
	private JTextField cnumber;
	private JPasswordField password;
	private JTextField city;
	private String gender;
	private JDateChooser dateofbirth;
	private JTextArea address;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerRegister window = new PassengerRegister();
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
	public PassengerRegister() {
		initialize();
	}
	/**
	 * function for auto increment of passenger id
	 */
	public void autopassengerid() {
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select Max(passenger_id) from PASSENGER";
			pst = con.mkDataBase().prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			rs.getString("Max(passenger_id)");
			if(rs.getString("Max(passenger_id)")==null)
			{
				passenger_id.setText("Max(passenger_id)");
			}
			else {
				int id =  Integer.parseInt(rs.getString("Max(passenger_id)"));
				id++;
				String a = Integer.toString(id);
				passenger_id.setText(a);
			}
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 789, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 11, 753, 434);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		passenger_id = new JTextField();
		passenger_id.setBackground(Color.ORANGE);
		passenger_id.setEditable(false);
		passenger_id.setBounds(362, 45, 163, 20);
		panel.add(passenger_id);
		passenger_id.setColumns(10);
		autopassengerid();
		
		passen_name = new JTextField();
		passen_name.setBounds(362, 76, 163, 20);
		panel.add(passen_name);
		passen_name.setColumns(10);
		
		ButtonGroup bu = new ButtonGroup();
		
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.ORANGE);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender= "male";
			}
		});
		rdbtnMale.setBounds(312, 203, 63, 23);
		bu.add(rdbtnMale);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.ORANGE);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "female";
			}
		});
		rdbtnFemale.setBounds(415, 203, 77, 23);
		bu.add(rdbtnFemale);
		panel.add(rdbtnFemale);
		
		JRadioButton rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setBackground(Color.ORANGE);
		rdbtnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "others";
			}
		});
		rdbtnOthers.setBounds(525, 203, 63, 23);
		bu.add(rdbtnOthers);
		panel.add(rdbtnOthers);
		
		email = new JTextField();
		email.setBounds(362, 318, 163, 20);
		panel.add(email);
		email.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnMale.isSelected()) { 
					  
                    gender = "Male"; 
                } 
  
				else if  (rdbtnFemale.isSelected()) { 
  
                    gender = "Female"; 
				}
				else {
					gender = "others";
				}
				
				int pass_id=Integer.parseInt(passenger_id.getText());
                String pass_name = passen_name.getText();
                String addr = address.getText();
                SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
                String  dateob = df.format(dateofbirth.getDate());
               // Date dateob = to.date(dateofbirth.getDate(),"DD-MM-YYYY");
                String pcity = city.getText();
                String pnumber = cnumber.getText();
                String emailId = email.getText();
                String ppassword = String.valueOf(password.getPassword());
			
				String sql = "insert into PASSENGER(passenger_id,passen_name,address,dateob,gender,city,cnumber,emailid,password) values(?,?,?,?,?,?,?,?,?)"; 
				try{
					PreparedStatement pst;
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement(sql);
					pst.setInt(1,pass_id);
					pst.setString(2,pass_name);
					pst.setString(3,addr);
					pst.setString(4,dateob);
					pst.setString(5,gender);
					pst.setString(6,pcity);
					pst.setString(7,pnumber);
					pst.setString(8,emailId);
					pst.setString(9,ppassword);
					pst.executeQuery();
					JOptionPane.showMessageDialog(btnRegister, "Registration successfully : ");
					
					PassengerLogin.main(new String[]{});
					frame.dispose();
				} catch (Exception exception) {
					exception.printStackTrace();
				
			}
			}
		});
		btnRegister.setBounds(238, 400, 89, 23);
		panel.add(btnRegister);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(138, 212, 69, 14);
		panel.add(lblGender);
		
		cnumber = new JTextField();
		cnumber.setBounds(362, 287, 163, 20);
		panel.add(cnumber);
		cnumber.setColumns(20);
		
		JLabel lblPassengerRegistration = new JLabel("Passenger Registration");
		lblPassengerRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerRegistration.setBounds(262, 11, 200, 20);
		panel.add(lblPassengerRegistration);
		
		JLabel lblPassengerId = new JLabel("Passenger ID");
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassengerId.setBounds(138, 47, 81, 17);
		panel.add(lblPassengerId);
		
		JLabel lblNewLabel = new JLabel("Passenger Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(138, 79, 110, 14);
		panel.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(138, 126, 69, 14);
		panel.add(lblAddress);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailId.setBounds(138, 321, 69, 14);
		panel.add(lblEmailId);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNumber.setBounds(138, 290, 91, 14);
		panel.add(lblContactNumber);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setBounds(138, 170, 91, 14);
		panel.add(lblDateOfBirth);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(138, 352, 69, 14);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(362, 349, 163, 20);
		panel.add(password);
		
		city = new JTextField();
		city.setBounds(362, 248, 163, 20);
		panel.add(city);
		city.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCity.setBounds(138, 251, 69, 14);
		panel.add(lblCity);
		
		JButton btnAlreadyRegisteredSign = new JButton("Already Registered? Sign in");
		btnAlreadyRegisteredSign.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlreadyRegisteredSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerLogin.main(new String[]{});
				frame.dispose();
			}
		});
		btnAlreadyRegisteredSign.setBounds(415, 400, 244, 23);
		panel.add(btnAlreadyRegisteredSign);
		
		dateofbirth = new JDateChooser();
		dateofbirth.getCalendarButton().setBackground(Color.ORANGE);
		dateofbirth.setBounds(362, 164, 163, 20);
		panel.add(dateofbirth);
		
		address = new JTextArea();
		address.setBounds(362, 115, 161, 38);
		panel.add(address);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passenger_id.setText("");
				passen_name.setText("");
				email.setText("");;
				cnumber.setText("");;
				password.setText("");;
				city.setText("");;
				//dateofbirth.;
				address.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(118, 400, 89, 23);
		panel.add(btnReset);
	}
}
