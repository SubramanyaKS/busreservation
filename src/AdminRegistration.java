import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class AdminRegistration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegistration window = new AdminRegistration();
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
	public AdminRegistration() {
		initialize();
	}
	public void autoadminid() {
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select Max(admin_id) from ADMIN";
			pst = con.mkDataBase().prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			rs.getString("Max(admin_id)");
			if(rs.getString("Max(admin_id)")==null)
			{
				textField.setText("Max(admin_id)");
			}
			else {
				int id =  Integer.parseInt(rs.getString("Max(admin_id)"));
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
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 788, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(10, 11, 752, 427);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.YELLOW);
		textField.setEditable(false);
		textField.setBounds(452, 91, 129, 20);
		panel.add(textField);
		textField.setColumns(10);
		autoadminid();
		
		textField_1 = new JTextField();
		textField_1.setBounds(452, 141, 129, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(452, 233, 129, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
	
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int admin_id=Integer.parseInt(textField.getText());
            String admin_name = textField_1.getText();
            String email = textField_2.getText();
            String anumber = textField_3.getText();
            String password = String.valueOf(passwordField.getPassword());
            String query ="Insert into ADMIN (admin_id, admin_Name, email, anumber, password ) values(?,?,?,?,?)";
			try {
				PreparedStatement pst;
				DBConnection con=new DBConnection();
				pst = con.mkDataBase().prepareStatement(query);
				pst.setInt(1,admin_id);
				pst.setString(2,admin_name);
				pst.setString(4,email);
				pst.setString(5,anumber);
				pst.setString(6,password);
				pst.executeQuery();
				JOptionPane.showMessageDialog(btnRegister, "Admin Added successfully : ");
				AdminSuccess.main(new String[]{});
				frame.dispose();
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBounds(452, 393, 89, 23);
		panel.add(btnRegister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_3.setText("");;
				passwordField.setText("");;
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(287, 393, 89, 23);
		panel.add(btnReset);
		
		JButton button = new JButton("<--Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		button.setBounds(10, 394, 89, 23);
		panel.add(button);

		
		JLabel lblAdminRegistration = new JLabel("Admin Registration");
		lblAdminRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdminRegistration.setBounds(269, 22, 224, 20);
		panel.add(lblAdminRegistration);
		
		JLabel lblAdminid = new JLabel("Admin_ID");
		lblAdminid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdminid.setBounds(179, 94, 82, 14);
		panel.add(lblAdminid);
		
		JLabel lblAdminname = new JLabel("Admin_Name");
		lblAdminname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdminname.setBounds(179, 144, 96, 14);
		panel.add(lblAdminname);
		
		textField_3 = new JTextField();
		textField_3.setBounds(452, 280, 129, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(452, 324, 129, 20);
		panel.add(passwordField);
		
		JLabel lblEmaidId = new JLabel("Emaid ID");
		lblEmaidId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmaidId.setBounds(179, 236, 63, 14);
		panel.add(lblEmaidId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(179, 327, 82, 14);
		panel.add(lblPassword);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNumber.setBounds(179, 283, 103, 14);
		panel.add(lblContactNumber);
	}
}
