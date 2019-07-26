package ServletPagePackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.AnswerDAO;
import DAOClasses.QuestionDAO;
import EntityClassesPackage.Answers;
import EntityClassesPackage.Questions;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        AnswerDAO adao=new AnswerDAO();
        QuestionDAO qdao=new QuestionDAO();
        HashMap<Integer,Questions>hmap= qdao.getAllQuestions();
        ArrayList<Answers> list=new ArrayList<Answers>();
        for(Entry<Integer, Questions> e:hmap.entrySet())
        {
        	out.println("<p><b>"+e.getValue().getQuesDesc()+"</b><br/>posted by:"+e.getValue().getEmployee().getEmp_name()+"  &nbsp;&nbsp;&nbsp; Designation: "
        			+e.getValue().getEmployee().getEmp_Designation()+"   &nbsp;&nbsp;&nbsp;  Posted on: "+e.getValue().getDate()+"</p>");
        	list=adao.getAnswers(e.getKey());
        	if(list.size()==0)
        	{
        		out.println("<p><b>No Answers</b></p>");
        	}
        	else
        	{out.println("<p><b>Answers</b></p>");
	        	for(Answers ans:list)
	        	{
	        		out.println("<p style='color:#4169E1'>"+ans.getAnswer_desc()+" <br/></p><p>posted by: "
	        	        	+ans.getEmp().getEmp_name()+"    Designation: "+ans.getEmp().getEmp_Designation()+"   Posted on: "+
	        	        				ans.getDate()+"</p>");
	        		
	            	
	        	} 
        	}
	}
}
	
}
