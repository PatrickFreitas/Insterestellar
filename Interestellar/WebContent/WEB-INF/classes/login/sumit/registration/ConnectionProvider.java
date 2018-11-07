package login.sumit.registration;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
	static Connection con = null;
	
	public static Connection getCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(conUrl, username, password);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		return con;
	}
}
