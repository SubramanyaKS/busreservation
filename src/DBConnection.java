import java.sql.*;
import java.sql.DriverManager;
public class DBConnection
{
	public  Connection mkDataBase() throws SQLException
	{
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "project"; 
		String pass = "";

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Reference to connection interface 
			con = DriverManager.getConnection(url,user,pass); 
		} catch (Exception exception)
		{
			exception.printStackTrace();
        }
		return con;
	}
}
