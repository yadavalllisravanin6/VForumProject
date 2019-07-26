package DAOClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBUtils;
import DBConnection.DBUtils;
public class LoginDAO {

	public String login(int emp_id)
	{
String sqlQuery="Select password from employee where emp_id= ?";
		
		String password=null;
		try(Connection con=DBUtils.buildConnection();
				PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
		{
			
			pstmt.setInt(1,emp_id);          //index starts from 1 and move rightwards
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==false)
				password=null;
			else {
				
				 password=rs.getString(1);
				//return password;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
	
	}

