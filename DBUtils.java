package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class DBUtils {

	public static Connection buildConnection() {
		// TODO Auto-generated method stub

		
		String URL = "jdbc:mysql://localhost:3306/vforum";
		
		String UID="root";
		String pwd="mysql";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL,UID,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;

			
	}

}
