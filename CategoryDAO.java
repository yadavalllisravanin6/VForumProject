package DAOClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBUtils;
import EntityClassesPackage.Category;

public class CategoryDAO {
 public Category getCategory(String name){
	 String sqlQuery="Select * from category where cate_name= ?";
	 int id=0;
	 String cat_name="";
	 Category c=null;
	 try(Connection con=DBUtils.buildConnection();
				PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
		{
			
			pstmt.setString(1,name);          //index starts from 1 and move rightwards
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
			 id=rs.getInt(1);
			 cat_name=rs.getString(2);
			 c= new Category(id,cat_name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
 
 public Category getCategoryById(int cat_id){
	 String sqlQuery="Select * from category where catId= ?";
	 int id=0;
	 String cat_name="";
	 Category c=null;
	 try(Connection con=DBUtils.buildConnection();
				PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
		{
			
			pstmt.setInt(1,cat_id);          //index starts from 1 and move rightwards
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
			 id=rs.getInt(1);
			 cat_name=rs.getString(2);
			 c= new Category(id,cat_name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
 
 public String getCategoryByQuestionId(int quesid){
	 String sqlQuery="Select cate_name from category where catId= (select cat_id from Questions where ques_id=?";
	 
	 String cat_name="";
	 Category c=null;
	 try(Connection con=DBUtils.buildConnection();
				PreparedStatement pstmt=con.prepareStatement(sqlQuery);)
		{
			
			pstmt.setInt(1,quesid);          //index starts from 1 and move rightwards
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
			 cat_name=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat_name;
	}
 }

