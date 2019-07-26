package DAOClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.http.HttpSession;

import DBConnection.DBUtils;
import EntityClassesPackage.Answers;
import EntityClassesPackage.Category;
import EntityClassesPackage.Employee;
import EntityClassesPackage.Questions;

public class AnswerDAO {
   
	public ArrayList<Answers> getAnswers(int ques_id)
	{
		String sqlQuery="select * from answers where ans_id=?";
		 ArrayList<Answers> list=new ArrayList<Answers>();
		try(Connection con=DBUtils.buildConnection();
				PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
		{
			pstmt.setInt(1, ques_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==false)
			{
				list=null;
			}
			else
			{
			do{
				 int ans_id=rs.getInt(1);
				 String ans_desc=rs.getString(2);
				 Date date=rs.getDate(3);
				 int emp_id=rs.getInt(4);
				 EmployeeDAO empdao=new EmployeeDAO();
				 Employee emp=empdao.getEmployee(emp_id);
				 
				 Answers ans=new Answers(ans_id,ans_desc,date,emp);
				 list.add(ans);
			}while(rs.next()) ;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int addAnswer(int ansid,String answer,int empid) throws ParseException{
		String sqlQuery="insert into answers values(?,?,?,?)";
		int count=0;
		try(Connection con=DBUtils.buildConnection();
				PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
		{
			
			pstmt.setInt(1,ansid);
			pstmt.setString(2,answer);
			long milli=System.currentTimeMillis();
			Date date=new Date(milli);
			pstmt.setDate(3,date);
			pstmt.setInt(4,empid);
			
			//index starts from 1 and move rightwards
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
