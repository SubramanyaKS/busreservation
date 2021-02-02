import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddBusRoute {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblDistance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBusRoute window = new AddBusRoute();
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
	public AddBusRoute() {
		initialize();
	}
	
	public void autobusroute() {
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select Max(route_id) from BUSROUTE";
			pst = con.mkDataBase().prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			rs.getString("Max(route_id)");
			if(rs.getString("Max(route_id)")==null)
			{
				textField.setText("Max(route_id)");
			}
			else {
				int id =  Integer.parseInt(rs.getString("max(route_id)"));
				id++;
				String a = Integer.toString(id);
				textField.setText(a);
			}
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 787, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(186, 85, 211));
		panel.setBounds(10, 11, 751, 428);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(449, 87, 151, 20);
		panel.add(textField);
		textField.setColumns(10);
		autobusroute();
		
		textField_1 = new JTextField();
		textField_1.setBounds(449, 135, 151, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(449, 182, 151, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(449, 230, 151, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(449, 273, 151, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblRouteId = new JLabel("Route ID");
		lblRouteId.setBounds(182, 90, 73, 14);
		panel.add(lblRouteId);
		
		JLabel lblDepartureStation = new JLabel("Departure Station");
		lblDepartureStation.setBounds(182, 138, 109, 14);
		panel.add(lblDepartureStation);
		
		JLabel lblArrivalStation = new JLabel("Arrival Station");
		lblArrivalStation.setBounds(182, 185, 112, 14);
		panel.add(lblArrivalStation);
		
		JLabel lblViaStation = new JLabel("via Station");
		lblViaStation.setBounds(182, 233, 98, 14);
		panel.add(lblViaStation);
		
		lblDistance = new JLabel("Distance");
		lblDistance.setBounds(182, 276, 73, 14);
		panel.add(lblDistance);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int route_id=Integer.parseInt(textField.getText());
	            String dstation = textField_1.getText();
	            String astation = textField_2.getText();
	            String vstation = textField_3.getText();
	            String distance = textField_4.getText();
	            String query ="Insert into BUSROUTE (route_id, dstation, astation, vstation, distance) values(?,?,?,?,?)";
				try {
					PreparedStatement pst;
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement(query);
					pst.setInt(1,route_id);
					pst.setString(2, dstation);
					pst.setString(3, astation);
					pst.setString(4, vstation);
					pst.setString(5,distance);
					pst.executeQuery();
					JOptionPane.showMessageDialog(btnAdd, "Bus Route is Successfully Added");
					frame.dispose();
				}catch(Exception exception){
					exception.printStackTrace();
				}
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(296, 367, 89, 23);
		panel.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(449, 367, 89, 23);
		panel.add(btnReset);
		
		JLabel lblAddBus = new JLabel("ADD BUS ROUTE");
		lblAddBus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAddBus.setBounds(296, 24, 253, 30);
		panel.add(lblAddBus);
	}
}
