import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeleteBus {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBus window = new DeleteBus();
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
	public DeleteBus() {
		initialize();
	}
	/**
	 * Delete  Function
	 */
	public static int brdelete(int id){
		int status=0;
		try{
			DBConnection con=new DBConnection();
			PreparedStatement ps=con.mkDataBase().prepareStatement("delete from BUSROUTE where route_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(222, 184, 135));
		frame.setBounds(100, 100, 768, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(471, 89, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String bus_id=textField.getText();
					if(bus_id==null||bus_id.trim().equals("")){
						JOptionPane.showMessageDialog(btnDelete,"Id can't be blank");
					}else {
						int id=Integer.parseInt(bus_id);
						int i=brdelete(id);
						if(i>0){
							JOptionPane.showMessageDialog(btnDelete,"Record deleted successfully!");
						}else{
							JOptionPane.showMessageDialog(btnDelete,"Unable to delete given Passenger id!");
						}
					}
					frame.dispose();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(305, 187, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblBusId = new JLabel("Bus  Id");
		lblBusId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBusId.setBounds(203, 92, 48, 14);
		frame.getContentPane().add(lblBusId);
		
		JLabel lblDeleteBus = new JLabel("Delete Bus");
		lblDeleteBus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblDeleteBus.setBounds(305, 23, 147, 23);
		frame.getContentPane().add(lblDeleteBus);
	}

}
