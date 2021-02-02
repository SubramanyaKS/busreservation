import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Feedback {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String u = args[0];
					Feedback window = new Feedback(u);
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
	public Feedback(String u) {
		initialize(u);
	}
	
	public void pid(String u) {
		try {
			PreparedStatement pst;
			DBConnection con=new DBConnection();
			pst = con.mkDataBase().prepareStatement("select passenger_id from PASSENGER where passen_name=?");
			pst.setString(1,u);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			
				textField.setText(rs.getString("passenger_id"));
			}
			}catch(Exception e){System.out.println(e);}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u) {
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(446, 66, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		pid(u);
		
		textArea = new JTextArea();
		textArea.setBounds(440, 155, 222, 108);
		frame.getContentPane().add(textArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int passenger_id=Integer.parseInt(textField.getText());
	            String feedback = textArea.getText();
	            String query ="Insert into FEEDBACK (passenger_id, pfeedback ) values(?,?)";
	            try {
					PreparedStatement pst;
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement(query);
					pst.setInt(1,passenger_id);
					pst.setString(2,feedback);
					pst.executeQuery();
					JOptionPane.showMessageDialog(btnSubmit, "Thank you for your valuable Feedback : ");
					frame.dispose();
					}catch(Exception exception){
						JOptionPane.showMessageDialog(btnSubmit, "Sorry please give another Feedback : ");
					}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(308, 267, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMessage.setBounds(141, 205, 108, 14);
		frame.getContentPane().add(lblMessage);
		
		JLabel lblPassengerId = new JLabel("Passenger ID");
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassengerId.setBounds(141, 69, 108, 14);
		frame.getContentPane().add(lblPassengerId);
		
		JLabel lblFeedback = new JLabel("FEEDBACK");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblFeedback.setBounds(279, 11, 170, 24);
		frame.getContentPane().add(lblFeedback);
	}
}
