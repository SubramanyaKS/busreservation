import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class EditPassengerProfile {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
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
					EditPassengerProfile window = new EditPassengerProfile(u);
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
	public EditPassengerProfile(String u) {
		initialize(u);
	}
	
	public  void getPassenger(String u) {
		try {
		PreparedStatement pst;
		DBConnection con=new DBConnection();
		pst = con.mkDataBase().prepareStatement("select passenger_id,address,dateob,gender,city,cnumber,emailid from PASSENGER where passen_name=?");
		pst.setString(1,u);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
		
			textField.setText(rs.getString("passenger_id"));
			textField_1.setText(u);
			textField_2.setText(rs.getString("address"));
			textField_3.setText(rs.getString("dateob"));
			textField_4.setText(rs.getString("gender"));
			textField_5.setText(rs.getString("city"));
			textField_6.setText(rs.getString("cnumber"));
			textField_7.setText(rs.getString("emailid"));
		}
		}catch(Exception e){System.out.println(e);}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 424, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBackground(new Color(240, 230, 140));
		textField.setEditable(false);
		textField.setBounds(183, 50, 139, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(240, 230, 140));
		textField_1.setEditable(false);
		textField_1.setBounds(183, 89, 139, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(240, 230, 140));
		textField_2.setEditable(false);
		textField_2.setBounds(183, 129, 139, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(240, 230, 140));
		textField_3.setEditable(false);
		textField_3.setBounds(183, 168, 139, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(240, 230, 140));
		textField_4.setEditable(false);
		textField_4.setBounds(183, 203, 139, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(240, 230, 140));
		textField_5.setEditable(false);
		textField_5.setBounds(183, 245, 139, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(240, 230, 140));
		textField_6.setEditable(false);
		textField_6.setBounds(183, 288, 139, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(240, 230, 140));
		textField_7.setEditable(false);
		textField_7.setBounds(183, 319, 139, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		getPassenger(u);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
			}
		});
		btnEdit.setBounds(74, 397, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(UIManager.getColor("Button.background"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pass_id=Integer.parseInt(textField.getText());
                String pass_name = textField_1.getText();
                String addr = textField_2.getText();
                String  dateob =textField_3.getText();
                String gender = textField_4.getText();
                String pcity = textField_5.getText();
                String pnumber = textField_6.getText();
                String emailId = textField_7.getText();
                String sql = "update  PASSENGER set passen_name=?,address=?,dateob=?,gender=?,city=?,cnumber=?,emailid = ? where passenger_id = ?"; 
				try{
					PreparedStatement pst;
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement(sql);
					
					pst.setString(1,pass_name);
					pst.setString(2,addr);
					pst.setString(3,dateob);
					pst.setString(4,gender);
					pst.setString(5,pcity);
					pst.setString(6,pnumber);
					pst.setString(7,emailId);
					pst.setInt(8,pass_id);
					pst.executeQuery();
					JOptionPane.showMessageDialog(btnSave, "Updated successfully : ");
					frame.dispose();
				} catch (Exception exception) {
					exception.printStackTrace();
				
			}
			}
		});
		btnSave.setBounds(245, 397, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JLabel lblPassengerid = new JLabel("passenger_id");
		lblPassengerid.setBounds(55, 53, 78, 14);
		frame.getContentPane().add(lblPassengerid);
		
		JLabel lblPassengerName = new JLabel("passenger Name");
		lblPassengerName.setBounds(55, 92, 78, 14);
		frame.getContentPane().add(lblPassengerName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(55, 132, 48, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblDateOfBirth = new JLabel("date of birth");
		lblDateOfBirth.setBounds(55, 171, 78, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(55, 206, 48, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(55, 258, 48, 14);
		frame.getContentPane().add(lblCity);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(55, 294, 89, 14);
		frame.getContentPane().add(lblContactNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(55, 322, 48, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblEditProfilr = new JLabel("Edit Profile");
		lblEditProfilr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditProfilr.setBounds(143, 11, 150, 28);
		frame.getContentPane().add(lblEditProfilr);
	}
}
