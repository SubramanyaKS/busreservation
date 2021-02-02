import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class EditAdminProfile {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					EditAdminProfile window = new EditAdminProfile(u);
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
	public EditAdminProfile(String u) {
		initialize(u);
	}
	
	public  void getAdmin(String u) {
		try {
		PreparedStatement pst;
		DBConnection con=new DBConnection();
		pst = con.mkDataBase().prepareStatement("select admin_id,email,anumber from ADMIN where admin_Name=?");
		pst.setString(1,u);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
		
			textField.setText(rs.getString("admin_id"));
			textField_1.setText(u);
			textField_3.setText(rs.getString("email"));
			textField_4.setText(rs.getString("anumber"));
		}
		}catch(Exception e){System.out.println(e);}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 452, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(252, 68, 123, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(252, 120, 123, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(252, 205, 123, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(252, 271, 123, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		getAdmin(u);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textField_3.setEditable(true);
				textField_4.setEditable(true);
			}
		});
		btnEdit.setBounds(91, 365, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int admin_id=Integer.parseInt(textField.getText());
                String admin_name = textField_1.getText();
                String  email =textField_3.getText();
                String number = textField_4.getText();
                String sql = "update  ADMIN set admin_name=?,email = ?,anumber=? where admin_id = ?"; 
				try{
					PreparedStatement pst;
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement(sql);
					
					pst.setString(1,admin_name);
					pst.setString(2,email);
					pst.setString(3,number);
					pst.setInt(4,admin_id);
					pst.executeQuery();
					JOptionPane.showMessageDialog(btnSave, "Admin Updated successfully : ");
					frame.dispose();
				} catch (Exception exception) {
					exception.printStackTrace();
				
			}
			}
		});
		btnSave.setBounds(271, 365, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JLabel lblAdminId = new JLabel("Admin Id");
		lblAdminId.setBounds(91, 71, 69, 14);
		frame.getContentPane().add(lblAdminId);
		
		JLabel lblAdminName = new JLabel("Admin Name");
		lblAdminName.setBounds(91, 123, 89, 14);
		frame.getContentPane().add(lblAdminName);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(88, 208, 48, 14);
		frame.getContentPane().add(lblEmailId);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(91, 274, 93, 14);
		frame.getContentPane().add(lblContactNumber);
		
		JLabel lblEditAdminProfile = new JLabel("Edit Admin Profile");
		lblEditAdminProfile.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEditAdminProfile.setBounds(173, 21, 149, 14);
		frame.getContentPane().add(lblEditAdminProfile);
	}
}
