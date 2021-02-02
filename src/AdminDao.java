import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class AdminDao {
	public static boolean validate(int admin_id,String name,String password) {
		PreparedStatement pst;
		boolean status=false;
		try{
			DBConnection con=new DBConnection();
			pst = con.mkDataBase().prepareStatement("select * from ADMIN where admin_id =? and admin_Name=? and password=?");
			pst.setInt(1,admin_id);
			pst.setString(2,name);
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
			PreparedStatement ps=con.mkDataBase().prepareStatement("delete from ADMIN where admin_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static boolean forgot(int admin_id,String email,String phonenumber) {
		 PreparedStatement pst;
		boolean status=false;
		try{
			DBConnection con=new DBConnection();
			pst = con.mkDataBase().prepareStatement("select * from ADMIN where email=? and anumber=? and admin_id=?");
			pst.setString(1,email);
			pst.setString(2,phonenumber);
			pst.setInt(3,admin_id);
			ResultSet rs=pst.executeQuery();
			status=rs.next();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static boolean getpass(int admin_id,String email,String phonenumber) {
		 PreparedStatement pst;
		boolean status=false;
		try{
			DBConnection con=new DBConnection();
			pst = con.mkDataBase().prepareStatement("select password from ADMIN where email=? and anumber=? and admin_id=?");
			pst.setString(1,email);
			pst.setString(2,phonenumber);
			pst.setInt(3,admin_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				
				JOptionPane.showMessageDialog(null,"Your Password is"+rs.getString("password")+"Please change it.");
			}
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
