package DAOClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBUtils;
import EntityClassesPackage.Category;
import EntityClassesPackage.Employee;

public class EmployeeDAO {

	public Employee getEmployee(int emp_id)
	{
		String sqlQuery="Select * from employee where emp_id= ?";
		 int id=0;
		 String emp_name="";
		 Employee emp=null;
		 try(Connection con=DBUtils.buildConnection();
					PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
			{
				
				pstmt.setInt(1,emp_id);          //index starts from 1 and move rightwards
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
				 id=rs.getInt(1);
				 emp_name=rs.getString(2);
				String desgination=rs.getString(3);
				String location=rs.getString(4);
				String username=rs.getString(5);
				String password=rs.getString(6);
			   emp=new Employee(id,emp_name,desgination,location,username,password);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return emp;
	}
}
