package ServletPagePackage;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOClasses.CategoryDAO;
import DAOClasses.EmployeeDAO;
import DAOClasses.QuestionDAO;
import EntityClassesPackage.Category;
import EntityClassesPackage.Employee;

/**
 * Servlet implementation class ItAddQuestion
 */
public class ItAddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String question=request.getParameter("question");
        CategoryDAO cdao=new CategoryDAO();
        Category c=cdao.getCategory("IT");
        HttpSession session= request.getSession();
    	int emp_id=(int) session.getAttribute("id");
    	
        QuestionDAO qdao=new QuestionDAO();
        int count=0;
		try {
			count = qdao.addQuestion(c, question,emp_id);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("ItServlet");
		rd.forward(request, response);
	}

	

}
