import java.sql.*;

import javax.swing.JOptionPane;
public class PassengerDao {
	public static boolean validate(int pass_id,String uname,String password) {
		PreparedStatement pst;
		boolean status=false;
		try{
			DBConnection con=new DBConnection();
			pst = con.mkDataBase().prepareStatement("select * from PASSENGER where passenger_id =? and passen_name=? and password=?");
			pst.setInt(1,pass_id);
			pst.setString(2,uname);
			pst.setString(3,password);
			ResultSet rs=pst.executeQuery();
			status=rs.next();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			DBConnection con=new DBConnection();
			PreparedStatement ps=con.mkDataBase().prepareStatement("delete from PASSENGER where passenger_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static boolean forgot(int pass_id,String email,String phonenumber) {
		 PreparedStatement pst;
 		boolean status=false;
 		try{
 			DBConnection con=new DBConnection();
 			pst = con.mkDataBase().prepareStatement("select * from PASSENGER where emailid =? and cnumber=? and passenger_id=?");
 			pst.setString(1,email);
 			pst.setString(2,phonenumber);
 			pst.setInt(3,pass_id);
 			ResultSet rs=pst.executeQuery();
 			status=rs.next();
 		}catch(Exception e){System.out.println(e);}
 		return status;
	}
	public static boolean getpass(int pass_id,String email,String phonenumber) {
		 PreparedStatement pst;
		boolean status=false;
		try{
			DBConnection con=new DBConnection();
			pst = con.mkDataBase().prepareStatement("select password from PASSENGER where emailid =? and cnumber=? and passenger_id=?");
			pst.setString(1,email);
			pst.setString(2,phonenumber);
			pst.setInt(3,pass_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				
				JOptionPane.showMessageDialog(null,"Your Password is"+rs.getString("password")+"Please change it.");
			}
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
