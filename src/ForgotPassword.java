import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class ForgotPassword {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int choose;
	private JRadioButton rdbtnPassenger;
	private JRadioButton rdbtnAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u= args[0];
					ForgotPassword window = new ForgotPassword(u);
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
	public ForgotPassword(String u) {
		initialize();
		forg(u);
	}
	public void forg(String u) {
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
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 548, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBounds(312, 101, 127, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(312, 177, 127, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(312, 246, 127, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =  Integer.parseInt(textField.getText());
                String pnumber = textField_2.getText();
                String emailId = textField_1.getText();
               if(choose == 0) {
                if(PassengerDao.forgot(id,emailId, pnumber)){
                	PassengerDao.getpass(id,emailId, pnumber);
					JOptionPane.showMessageDialog(btnEnter, "Please Change Password  ");
				ChangePassword.main(new String[] {"p"});
				frame.dispose();
				}else{
					JOptionPane.showMessageDialog(btnEnter, "Sorry, Try again");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
			}
               else {
            	   if(AdminDao.forgot(id,emailId, pnumber)){
                   	AdminDao.getpass(id,emailId, pnumber);
   					JOptionPane.showMessageDialog(btnEnter, "Please Change Password  ");
   				ChangePassword.main(new String[] {"a"});
   				frame.dispose();
   				}else{
   					JOptionPane.showMessageDialog(btnEnter, "Sorry, Try again");
   					textField.setText("");
   					textField_1.setText("");
   					textField_2.setText("");
   				}
               }
			}
		});
		btnEnter.setBounds(117, 322, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(85, 104, 48, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(73, 180, 48, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(73, 262, 103, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		ButtonGroup bu = new ButtonGroup();
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBackground(new Color(0, 255, 255));
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = 1;
			}
		});
		rdbtnAdmin.setBounds(186, 42, 109, 23);
		bu.add(rdbtnAdmin);
		frame.getContentPane().add(rdbtnAdmin);
		
		rdbtnPassenger = new JRadioButton("Pasenger");
		rdbtnPassenger.setBackground(new Color(0, 255, 255));
		rdbtnPassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = 0;
			}
		});
		rdbtnPassenger.setBounds(296, 42, 109, 23);
		bu.add(rdbtnPassenger);
		frame.getContentPane().add(rdbtnPassenger);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
				textField_1.setText(" ");
				textField_2.setText(" ");
			}
		});
		btnReset.setBounds(277, 322, 89, 23);
		frame.getContentPane().add(btnReset);
	}
}