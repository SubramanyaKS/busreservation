import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Payment {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtMmyy;
	private JPasswordField passwordField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					String v = args[1];
					Payment window = new Payment(u,v);
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
	public Payment(String u, String v) {
		initialize(u,v);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize( String u, String v) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 445, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(238, 141, 145, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 180, 145, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtMmyy = new JTextField();
		txtMmyy.setForeground(Color.GRAY);
		txtMmyy.setText("mm/yy");
		txtMmyy.setBounds(101, 224, 96, 20);
		frame.getContentPane().add(txtMmyy);
		txtMmyy.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText(u);
		textField_2.setBounds(238, 267, 145, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBackground(new Color(192, 192, 192));
		passwordField.setBounds(278, 224, 105, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblAmountInRs = new JLabel("Amount in Rs");
		lblAmountInRs.setBounds(35, 282, 72, 14);
		frame.getContentPane().add(lblAmountInRs);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setBounds(220, 227, 48, 14);
		frame.getContentPane().add(lblCvv);
		
		JLabel lblNewLabel = new JLabel("Expiry date");
		lblNewLabel.setBounds(24, 224, 54, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCardNumber = new JLabel("Card  Number");
		lblCardNumber.setBounds(24, 144, 83, 14);
		frame.getContentPane().add(lblCardNumber);
		
		JLabel lblCardHolderName = new JLabel("Card Holder Name");
		lblCardHolderName.setBounds(24, 183, 91, 14);
		frame.getContentPane().add(lblCardHolderName);
		
		JLabel lblOnlinePayment = new JLabel("ONLINE PAYMENT");
		lblOnlinePayment.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
		lblOnlinePayment.setBounds(122, 22, 212, 25);
		frame.getContentPane().add(lblOnlinePayment);
		
		JButton btnPay = new JButton("PAY");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long cardnum=Long.parseLong(textField.getText());
				if(Cardvalidation.isValid(cardnum)){
					try {
					DBConnection con = new DBConnection();
					PreparedStatement pst;
					long card_number=Long.parseLong(textField.getText());
		            String card_name = textField_1.getText();
		            int amount = Integer.parseInt(textField_2.getText());
					String query = "insert into PAYDETAILS(card_number, card_name, amount,reserve_id ) values(?,?,?,?)";
					pst = con.mkDataBase().prepareStatement(query);
					pst.setLong(1,card_number);
					pst.setString(2,card_name);
					pst.setInt(3,amount);
					pst.setString(4,v);
					pst.executeQuery();
					frame.dispose();
					}catch(Exception exception){
						exception.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(btnPay, "Sorry, please check your card number");
					textField.setText("");
					textField_1.setText("");
					passwordField.setText("");
					txtMmyy.setText("");
					textField_2.setText("");
				}
				
				
			}
		});
		btnPay.setBounds(81, 412, 89, 23);
		frame.getContentPane().add(btnPay);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				passwordField.setText("");
				txtMmyy.setText("");
				textField_2.setText("");
				
			}
		});
		btnNewButton.setBounds(294, 412, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\visa.jpg"));
		label.setBounds(313, 329, 83, 53);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\rupay1.jpg"));
		label_1.setBounds(223, 329, 93, 57);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\mastercard.jpg"));
		label_2.setBounds(130, 329, 83, 57);
		frame.getContentPane().add(label_2);
		
		
		
		
	}
}
