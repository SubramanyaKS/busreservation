import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ChangePassword {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private int  choose;
	public static JRadioButton rdbtnPassenger;
	private JRadioButton rdbtnAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					ChangePassword window = new ChangePassword(u);
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
	public ChangePassword(String u) {
		initialize();
		chpass(u);
	}
	public void chpass(String u)
	{
		if (u=="a"){
			rdbtnPassenger.setEnabled(false);
			rdbtnAdmin.setEnabled(true);
		}
		else {
			rdbtnPassenger.setEnabled(true);
			rdbtnAdmin.setEnabled(false);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.setBounds(100, 100, 784, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChangePassword.setBounds(270, 11, 183, 28);
		frame.getContentPane().add(lblChangePassword);
		
		textField = new JTextField();
		textField.setBounds(440, 93, 129, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		ButtonGroup bu = new ButtonGroup();
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = 1;
				
			}
		});
		rdbtnAdmin.setBackground(Color.MAGENTA);
		rdbtnAdmin.setBounds(383, 50, 57, 23);
		bu.add(rdbtnAdmin);
		frame.getContentPane().add(rdbtnAdmin);
		
		rdbtnPassenger = new JRadioButton("Passenger");
		rdbtnPassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = 0;
			}
		});
		rdbtnPassenger.setBackground(Color.MAGENTA);
		rdbtnPassenger.setBounds(494, 50, 75, 23);
		bu.add(rdbtnPassenger);
		frame.getContentPane().add(rdbtnPassenger);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DBConnection con=new DBConnection();
					PreparedStatement pst;
					int id=Integer.parseInt(textField.getText());
					String npassword = String.valueOf(passwordField_1.getPassword());
					String opassword = String.valueOf(passwordField.getPassword());
					if(choose == 0)
					{
						pst = con.mkDataBase().prepareStatement("Update PASSENGER set password = ? where passenger_id = ? and password = ?");
						pst.setString(1,npassword);
						pst.setInt(2,id);
						pst.setString(3,opassword);
						pst.executeQuery();
						JOptionPane.showMessageDialog(btnChange, "Password Changed Sussesfully successfully : "); 
						PassengerLogin.main(new String[]{});
						frame.dispose();
				     }
					else
					{
						pst = con.mkDataBase().prepareStatement("Update ADMIN set password = ? where admin_id = ? and password = ?");
						pst.setString(1,npassword);
						pst.setInt(2,id);
						pst.setString(3,opassword);
						pst.executeQuery();
						JOptionPane.showMessageDialog(btnChange, "Password Changed Sussesfully successfully : ");
						AdminLogin.main(new String[]{});
						frame.dispose();
					}
				}catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChange.setBounds(351, 247, 89, 23);
		frame.getContentPane().add(btnChange);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(232, 96, 48, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(205, 133, 70, 14);
		frame.getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(205, 158, 75, 14);
		frame.getContentPane().add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(440, 124, 129, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(440, 155, 129, 20);
		frame.getContentPane().add(passwordField_1);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show password");
		chckbxShowPassword.setBackground(new Color(255, 0, 255));
		chckbxShowPassword.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					passwordField.setEchoChar((char)0);
					passwordField_1.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
					passwordField_1.setEchoChar('*');
				}
			}
		});
		chckbxShowPassword.setBounds(383, 201, 128, 23);
		frame.getContentPane().add(chckbxShowPassword);
	}
}
