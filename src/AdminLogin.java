import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

public class AdminLogin {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 798, 494);
		frame.setTitle("BUS RESERVATION SYSTEM>>>ADMIN LOGIN");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(94, 31, 594, 393);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.CYAN);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
		textField.setBounds(381, 113, 131, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.CYAN);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
		textField_1.setBounds(381, 174, 131, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel aidLabel = new JLabel("Admin ID");
		aidLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		aidLabel.setBounds(113, 115, 96, 17);
		panel.add(aidLabel);
		
		JLabel aunLabel_1 = new JLabel("User Name");
		aunLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		aunLabel_1.setBounds(113, 176, 96, 17);
		panel.add(aunLabel_1);
		
		JLabel apasLabel_2 = new JLabel("Password");
		apasLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		apasLabel_2.setBounds(113, 230, 96, 17);
		panel.add(apasLabel_2);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnLogin.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				int admin_id=Integer.parseInt(textField.getText());
				String name=textField_1.getText();
				String password=String.valueOf(passwordField.getPassword());
					if(AdminDao.validate(admin_id,name, password)){
						JOptionPane.showMessageDialog(btnLogin, " Welcome "+textField_1.getText());
					AdminSuccess.main(new String[]{textField_1.getText()});
					frame.dispose();
					}else{
						
						JOptionPane.showMessageDialog(btnLogin,AdminLogin.this, "Sorry, Username or Password Error Login Error!",JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						textField_1.setText("");
						passwordField.setText("");
					}
			}
		});
		btnLogin.setBounds(288, 292, 96, 25);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
		passwordField.setBackground(Color.CYAN);
		passwordField.setBounds(381, 228, 131, 25);
		panel.add(passwordField);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblAdminLogin.setBounds(197, 26, 240, 41);
		panel.add(lblAdminLogin);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1 .setText("");
				passwordField.setText("");
			}
			
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(422, 353, 90, 25);
		panel.add(btnReset);
		
		JButton bbutton = new JButton("<---  Back");
		bbutton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		bbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusReserve.main(new String[]{});
				frame.dispose();
			}
			});
		bbutton.setBounds(10, 355, 89, 23);
		panel.add(bbutton);
		
		JButton btnForgotPassword = new JButton("Forgot Password ?");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPassword.main(new String[]{"a"});
			}
		});
		btnForgotPassword.setBackground(new Color(0, 255, 255));
		btnForgotPassword.setForeground(Color.RED);
		btnForgotPassword.setBounds(94, 292, 131, 23);
		panel.add(btnForgotPassword);
	}
}