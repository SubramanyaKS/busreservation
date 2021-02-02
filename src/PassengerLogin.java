import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class PassengerLogin {
	private JFrame frame;
	private JTextField textField;
	private JTextField utextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerLogin window = new PassengerLogin();
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
	public PassengerLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 791, 494);
		frame.setTitle("BUS RESERVATION SYSTEM>>>PASSENGER LOGIN");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(93, 41, 588, 377);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setCaretColor(Color.RED);
		textField.setBackground(Color.CYAN);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(369, 66, 149, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		utextField = new JTextField();
		utextField.setBackground(Color.CYAN);
		utextField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		utextField.setBounds(369, 123, 149, 29);
		panel.add(utextField);
		utextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pass_id=Integer.parseInt(textField.getText());
				String uname=utextField.getText();
				String password=String.valueOf(passwordField.getPassword());
					if(PassengerDao.validate(pass_id,uname, password)){
						JOptionPane.showMessageDialog(btnNewButton, "welcome  "+utextField.getText());
					PassengerSuccess.main(new String[] {utextField.getText()});
					//	PassengerSuccess ps=new PassengerSuccess(utextField.getText());
					frame.dispose();
					}else{
						JOptionPane.showMessageDialog(btnNewButton, PassengerLogin.this, "Sorry, Username or Password Error Login Error!", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						utextField.setText("");
						passwordField.setText("");
					}
			}
		});
		btnNewButton.setBounds(296, 257, 109, 29);
		panel.add(btnNewButton);
		
		JButton btnNewRegistration = new JButton("New Registration");
		btnNewRegistration.setForeground(new Color(65, 105, 225));
		btnNewRegistration.setBackground(new Color(0, 255, 255));
		btnNewRegistration.setBorder(null);
		btnNewRegistration.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerRegister.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewRegistration.setBounds(87, 282, 135, 26);
		panel.add(btnNewRegistration);
		
		JLabel lblPassengerId = new JLabel("Passenger  ID");
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId.setBounds(117, 64, 105, 26);
		panel.add(lblPassengerId);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(117, 122, 105, 26);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(117, 176, 105, 19);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBackground(Color.CYAN);
		passwordField.setBounds(369, 173, 149, 29);
		//passwordField.setEchoChar((char)0);
		panel.add(passwordField);
		
		JLabel lblPassengerLogin = new JLabel("PASSENGER LOGIN");
		lblPassengerLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblPassengerLogin.setBounds(149, 11, 335, 39);
		panel.add(lblPassengerLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				utextField.setText("");
				passwordField.setText("");
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(466, 331, 90, 26);
		panel.add(btnReset);
		
		JButton bbutton = new JButton("<---  Back");
		bbutton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		bbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusReserve.main(new String[]{});
				frame.dispose();
			}
			});
		bbutton.setBounds(30, 327, 98, 30);
		panel.add(bbutton);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnForgotPassword.setForeground(new Color(255, 0, 0));
		btnForgotPassword.setBorder(null);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPassword.main(new String[]{"p"});
			}
			
		});
		btnForgotPassword.setBackground(new Color(0, 255, 255));
		btnForgotPassword.setBounds(87, 248, 117, 23);
		panel.add(btnForgotPassword);
	}
}