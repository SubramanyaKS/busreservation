import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeletePassenger {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePassenger window = new DeletePassenger();
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
	public DeletePassenger() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 255, 47));
		frame.setBounds(100, 100, 758, 282);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(418, 70, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassengerId = new JLabel("Passenger ID");
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassengerId.setBounds(180, 73, 105, 14);
		frame.getContentPane().add(lblPassengerId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passen_id=textField.getText();
				if(passen_id==null||passen_id.trim().equals("")){
					JOptionPane.showMessageDialog(btnDelete,"Id can't be blank");
				}else {
					int id=Integer.parseInt(passen_id);
					int i=PassengerDao.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(btnDelete,"Record deleted successfully!");
					}else{
						JOptionPane.showMessageDialog(btnDelete,DeletePassenger.this,"Unable to delete given Passenger id!",JOptionPane.ERROR_MESSAGE);
					}
				}
				frame.dispose();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(300, 165, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}
