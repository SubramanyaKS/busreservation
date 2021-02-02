import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeleteBusroute {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBusroute window = new DeleteBusroute();
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
	public DeleteBusroute() {
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
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setBounds(100, 100, 748, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(453, 70, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblRouteId = new JLabel("Route ID");
		lblRouteId.setBounds(248, 73, 48, 14);
		frame.getContentPane().add(lblRouteId);
		
		JLabel lblDeleteBusRoute = new JLabel("Delete Bus Route");
		lblDeleteBusRoute.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDeleteBusRoute.setBounds(289, 11, 147, 32);
		frame.getContentPane().add(lblDeleteBusRoute);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String route_id=textField.getText();
				if(route_id==null||route_id.trim().equals("")){
					JOptionPane.showMessageDialog(btnDelete,"Id can't be blank");
				}else {
					int id=Integer.parseInt(route_id);
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
		btnDelete.setBounds(324, 166, 89, 23);
		frame.getContentPane().add(btnDelete);
		
	}
}
