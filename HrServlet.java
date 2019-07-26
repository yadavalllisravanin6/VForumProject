package ServletPagePackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.AnswerDAO;
import DAOClasses.CategoryDAO;
import DAOClasses.QuestionDAO;
import EntityClassesPackage.Answers;
import EntityClassesPackage.Category;
import EntityClassesPackage.Questions;

/**
 * Servlet implementation class HrServlet
 */
public class HrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='HrPage.html'>Click here to add question</a>");
        out.println("<br/>");
        //String question=request.getParameter("question");
        CategoryDAO cdao=new CategoryDAO();
        Category c=cdao.getCategory("HR");
       
        QuestionDAO qdao=new QuestionDAO();
        
        AnswerDAO adao=new AnswerDAO();
        HashMap<Integer,Questions>hmap= qdao.getQuestions(c);
        
        for(Entry<Integer, Questions> e:hmap.entrySet())
        {
        	//out.println("<h3>"+e.getKey()+"  "+e.getValue().getQuesDesc()+"  "+e.getValue().getEmployee().getEmp_name()+
        		//	"  "+e.getValue().getDate()+"</h3>");
        	out.println("<p><b>"+e.getValue().getQuesDesc()+"</b><br/>posted by:"+e.getValue().getEmployee().getEmp_name()+" &nbsp;&nbsp;&nbsp;  Designation: "
        			+e.getValue().getEmployee().getEmp_Designation()+"   &nbsp;&nbsp;&nbsp;  Posted on: "+e.getValue().getDate()+"</p>");
      	ArrayList<Answers> ansList=adao.getAnswers(e.getKey());
        	int a=e.getKey();
        	if(ansList==null)
        	{
        		out.println("<p><b>No Answers</b></p>");
        	}
        	
        	else
        	{out.println("<p><b>Answers</b></p>");
	        	for(Answers ans:ansList)
	        	{
	        		out.println("<p style='color:#4169E1'>"+ans.getAnswer_desc()+" <br/></p><p>posted by: "
	        	        	+ans.getEmp().getEmp_name()+"    Designation: "+ans.getEmp().getEmp_Designation()+"   Posted on: "+
	        	        				ans.getDate()+"</p>");
	        		
	            	
	        	} 
	        	ansList=null;
        	}
	        out.println("<a href='HrAddAnswer?postId="+e.getKey()+"'>Click here to add Answer"+"</a>");
	        	
        }
        
        
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
