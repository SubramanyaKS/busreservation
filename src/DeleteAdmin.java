import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAdmin {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAdmin window = new DeleteAdmin();
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
	public DeleteAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 785, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(426, 73, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAdminId = new JLabel("Admin ID");
		lblAdminId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdminId.setBounds(196, 76, 90, 14);
		frame.getContentPane().add(lblAdminId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String admin_id=textField.getText();
				if(admin_id==null||admin_id.trim().equals("")){
					JOptionPane.showMessageDialog(btnDelete,"Id can't be blank");
				}else {
					int id=Integer.parseInt(admin_id);
					int i=AdminDao.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(btnDelete,"Record deleted successfully!");
					}else{
						JOptionPane.showMessageDialog(btnDelete,"Unable to delete given Admin id!");
					}
				}
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(283, 172, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}
