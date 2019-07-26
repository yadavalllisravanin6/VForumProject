package DAOClasses;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import DBConnection.DBUtils;
import EntityClassesPackage.Category;
import EntityClassesPackage.Employee;
import EntityClassesPackage.Questions;

public class QuestionDAO {
public int addQuestion(Category cat,String question,int empid) throws ParseException{
	String sqlQuery="insert into Questions(cat_id,question_desc,emp_id,date) values(?,?,?,?)";
	int count=0;
	ArrayList<Questions> qlist=null;
	try(Connection con=DBUtils.buildConnection();
			PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
	{
		
		pstmt.setInt(1,cat.getCatId());
		pstmt.setString(2,question);
		pstmt.setInt(3,empid);
		long milli=System.currentTimeMillis();
		Date date=new Date(milli);
		pstmt.setDate(4,date);
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
HashMap<Integer,Questions> hmap=new HashMap<Integer,Questions>();
public HashMap<Integer,Questions>  getQuestions(Category cat)
{
	String sqlQuery="select * from Questions where cat_id=?";
	try(Connection con=DBUtils.buildConnection();
			PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
	{
	 pstmt.setInt(1, cat.getCatId());
	 ResultSet rs=pstmt.executeQuery();
	 while(rs.next())
	 {
		 int c_id=rs.getInt(2);
		 int q_id=rs.getInt(1);
		 String desc=rs.getString(3);
		 Date date=rs.getDate(5);
		 int emp_id=rs.getInt(4);
		 EmployeeDAO eDao=new EmployeeDAO();
		 Employee employee=eDao.getEmployee(emp_id);
		 Questions ques=new Questions(cat,desc,employee,date);
		 hmap.put(q_id, ques);
		 
	 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return hmap;
}

HashMap<Integer,Questions> qmap=new HashMap<Integer,Questions>();
public HashMap<Integer,Questions>  getAllQuestions()
{
	String sqlQuery="select * from Questions";
	try(Connection con=DBUtils.buildConnection();
			Statement pstmt=con.createStatement();)
	{
	 ResultSet rs=pstmt.executeQuery(sqlQuery);
	 while(rs.next())
	 {
		 int c_id=rs.getInt(2);
		 int q_id=rs.getInt(1);
		 String desc=rs.getString(3);
		 Date date=rs.getDate(5);
		 int emp_id=rs.getInt(4);
		 CategoryDAO cdao=new CategoryDAO();
		 Category cat=cdao.getCategoryById(c_id);
		 EmployeeDAO eDao=new EmployeeDAO();
		 Employee employee=eDao.getEmployee(emp_id);
		 Questions ques=new Questions(cat,desc,employee,date);
		 qmap.put(q_id, ques);
		 
	 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return qmap;
}
}

