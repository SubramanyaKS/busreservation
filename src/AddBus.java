import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddBus {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String choose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBus window = new AddBus();
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
	public AddBus() {
		initialize();
		
	}
	
	public void autobus() {
		try {
			DBConnection con = new DBConnection();
			PreparedStatement pst;
			String query = "select Max(bus_id) from BUS";
			pst = con.mkDataBase().prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			rs.next();
			rs.getString("Max(bus_id)");
			if(rs.getString("Max(bus_id)")==null)
			{
				textField.setText("Max(bus_id)");
			}
			else {
				int id =  Integer.parseInt(rs.getString("max(bus_id)"));
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
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 785, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(483, 83, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		autobus();
		
		textField_2 = new JTextField();
		textField_2.setBounds(483, 163, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBusId = new JLabel("Bus ID");
		lblBusId.setBounds(178, 86, 48, 14);
		frame.getContentPane().add(lblBusId);
		

		JLabel lblNumberOfSeats = new JLabel("Number of Seats");
		lblNumberOfSeats.setBounds(144, 166, 96, 14);
		frame.getContentPane().add(lblNumberOfSeats);
		
		ButtonGroup bu = new ButtonGroup();
		
		JLabel lblBusType = new JLabel("Bus Type");
		lblBusType.setBounds(126, 211, 89, 14);
		frame.getContentPane().add(lblBusType);
		
		
		JRadioButton rdbtnAc = new JRadioButton("A/C");
		rdbtnAc.setBackground(new Color(135, 206, 250));
		rdbtnAc.setBounds(347, 202, 67, 23);
		bu.add(rdbtnAc);
		frame.getContentPane().add(rdbtnAc);
		
		
		JRadioButton rdbtnNonAc = new JRadioButton("Non A/C");
		rdbtnNonAc.setBackground(new Color(135, 206, 250));
		rdbtnNonAc.setBounds(440, 202, 89, 23);
		bu.add(rdbtnNonAc);
		frame.getContentPane().add(rdbtnNonAc);
		
		
		JRadioButton rdbtnSleeperAc = new JRadioButton("Sleeper A/c");
		rdbtnSleeperAc.setBackground(new Color(135, 206, 250));
		rdbtnSleeperAc.setBounds(531, 202, 93, 23);
		bu.add(rdbtnSleeperAc);
		frame.getContentPane().add(rdbtnSleeperAc);
		
		JRadioButton rdbtnSleeperNonAc = new JRadioButton("Sleeper Non A/c");
		rdbtnSleeperNonAc.setBackground(new Color(135, 206, 250));
		rdbtnSleeperNonAc.setBounds(626, 202, 122, 23);
		bu.add(rdbtnSleeperNonAc);
		frame.getContentPane().add(rdbtnSleeperNonAc);
		
		JLabel lblAddBus = new JLabel("Add Bus");
		lblAddBus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAddBus.setBounds(347, 21, 130, 23);
		frame.getContentPane().add(lblAddBus);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAc.isSelected()) { 
					  
                    choose = "A/c"; 
                } 
				else if (rdbtnNonAc.isSelected()) { 
					choose = "Non A/c"; 
                }
                else if(rdbtnSleeperAc.isSelected()) {
            	     choose = "Sleeper A/c";
                 }
                else {
                	 choose = "Non Sleeper A/c";
                }
				int bus_id=Integer.parseInt(textField.getText());
	            int route_id = Integer.parseInt(textField_1.getText());
	            int noofseat = Integer.parseInt(textField_2.getText());
	            String dtime = textField_3.getText();
	            String atime = textField_4.getText();
	            String price = textField_5.getText();
	            String query ="Insert into BUS (bus_id, route_id, noofseat, bustype, dep_time, ar_time,price ) values(?,?,?,?,?,?,?)";
				try {
					PreparedStatement pst;
					DBConnection con=new DBConnection();
					pst = con.mkDataBase().prepareStatement(query);
					pst.setInt(1,bus_id);
					pst.setInt(2,route_id);
					pst.setInt(3,noofseat);
					pst.setString(4,choose);
					pst.setString(5,dtime);
					pst.setString(6,atime);
					pst.setString(7,price);
					pst.executeQuery();
					JOptionPane.showMessageDialog(btnSave, "Bus Added successfully : ");
					frame.dispose();
					}catch(Exception exception){
						exception.printStackTrace();
					}
					
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(278, 419, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
	            textField_2.setText("");
	             textField_3.setText("");
	            textField_4.setText("");
	            textField_5.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(440, 419, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JLabel lblRouteId = new JLabel("Route ID");
		lblRouteId.setBounds(166, 129, 75, 14);
		frame.getContentPane().add(lblRouteId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(483, 126, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(262, 270, 96, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(581, 260, 96, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDestinationTime = new JLabel("Destination Time");
		lblDestinationTime.setBounds(114, 273, 100, 14);
		frame.getContentPane().add(lblDestinationTime);
		
		JLabel lblArivalTime = new JLabel("Arrival Time");
		lblArivalTime.setBounds(470, 273, 89, 14);
		frame.getContentPane().add(lblArivalTime);
		
		textField_5 = new JTextField();
		textField_5.setBounds(483, 332, 96, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(166, 335, 48, 14);
		frame.getContentPane().add(lblPrice);
		
	}
}
