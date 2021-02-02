import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Window.Type;
public class BusReserve {

	private JFrame frmBusReservationSystem;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					BusReserve window = new BusReserve();
					window.frmBusReservationSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Show date and time in the  page.
	 */
	public void clock() {
		Thread clock = new Thread()
		{
				public void run()
				{
					try {
						while(true)
						{
							Calendar cal = new GregorianCalendar();
							int day = cal.get(Calendar.DAY_OF_MONTH);
							int  month = (cal.get(Calendar.MONTH)+1);
							int year = cal.get(Calendar.YEAR);
							label_2.setText("Date  "+day+"  - "+month+" - "+year);
						
							int second = cal.get(Calendar.SECOND);
							int minute = cal.get(Calendar.MINUTE);
							int hour = cal.get(Calendar.HOUR);
							label_3.setText("Time  "+hour+" : "+minute+" : "+second);
							sleep(1000);
				
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
		};
		clock.start();
	}
	/**
	 * Create the application.
	 */
	public BusReserve() {
		initialize();
		clock();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBusReservationSystem = new JFrame();
		frmBusReservationSystem.setType(Type.NORMAL);
		frmBusReservationSystem.setForeground(Color.BLACK);
		frmBusReservationSystem.setBackground(Color.BLACK);
		frmBusReservationSystem.setTitle("BUS RESERVATION SYSTEM");
		frmBusReservationSystem.getContentPane().setBackground(Color.BLACK);
		frmBusReservationSystem.getContentPane().setForeground(Color.BLACK);
		frmBusReservationSystem.setBounds(100, 100, 792, 494);
		frmBusReservationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusReservationSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 11, 756, 433);
		frmBusReservationSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 140, 272, 197);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton pasButton = new JButton("Passenger Login");
		pasButton.setBounds(64, 120, 136, 46);
		panel_1.add(pasButton);
		pasButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		pasButton.setBackground(Color.LIGHT_GRAY);
		
		JButton adButton = new JButton("Admin Login");
		adButton.setBounds(64, 25, 136, 46);
		panel_1.add(adButton);
		adButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		adButton.setBackground(Color.LIGHT_GRAY);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, -11, 280, 221);
		panel_1.add(label_1);
		label_1.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\img\\bus_2.jpg"));
		adButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(adButton, "Welcome to Admin Login ");
				AdminLogin.main(new String[]{});
				frmBusReservationSystem.dispose();
			}
		});
		pasButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(pasButton, "Welcome to Passenger Login ");
				PassengerLogin.main(new String[]{});
				frmBusReservationSystem.dispose();
			}	
		});
		
		JLabel lblNewLabe = new JLabel("BUS RESERVATION SYSTEM");
		lblNewLabe.setBounds(161, 35, 463, 37);
		panel.add(lblNewLabe);
		lblNewLabe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\downloads\\java\\BusReservationSystem\\bus-icon.png"));
		label.setBounds(21, 11, 128, 85);
		panel.add(label);
		
		label_2 = new JLabel("");
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setBounds(623, 35, 112, 16);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setForeground(new Color(255, 0, 0));
		label_3.setBounds(623, 56, 106, 16);
		panel.add(label_3);
	}
}