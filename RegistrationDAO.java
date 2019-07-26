package DAOClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBUtils;
import EntityClassesPackage.Employee;

public class RegistrationDAO {
	public Boolean EmployeeIdCheck(int emp_id)
	{
      String sqlQuery="Select * from employee where emp_id= ?";
      boolean b=false;
		try(Connection con=DBUtils.buildConnection();
				PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
		{
			
			pstmt.setInt(1,emp_id);          //index starts from 1 and move rightwards
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==false)
				b=true;
			else {
				b=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public Boolean UserNameCheck(String user_name){
		 String sqlQuery="Select * from employee where user_name= ?";
	      boolean b=false;
			try(Connection con=DBUtils.buildConnection();
					PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
			{
				
				pstmt.setString(1,user_name);          //index starts from 1 and move rightwards
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()==false)
					b=true;
				else {
					b=false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
		
	}
	public int register(Employee emp){
		
		 String sqlQuery="insert into employee values(?,?,?,?,?,?)";
	     int count=0;
	   
			try(Connection con=DBUtils.buildConnection();
					PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
			{
					pstmt.setInt(1, emp.getEmp_id());
					pstmt.setString(2,emp.getEmp_name());
					pstmt.setString(3,emp.getEmp_Designation());
					pstmt.setString(4,emp.getEmp_Location());
					pstmt.setString(5,emp.getUser_name());
					pstmt.setString(6,emp.getPassword());
					 count=pstmt.executeUpdate();
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
		
	}
	
}
