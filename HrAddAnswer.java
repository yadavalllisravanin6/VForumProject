package ServletPagePackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HrAddAnswer
 */
public class HrAddAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String postId=request.getParameter("postId");
        //System.out.println("Add answer");
        out.println("<html><body><form action='AnswerServlet' method='post'>"
        		+"<input type='textarea' name='answer' placeholder='add answer...'/>"
        		+ "<input type='hidden' name='postId' value='"+postId+"'/>"
        		+ "<input type='submit' value='Submit'/>"
        		+ "</form></body></html>");

	}
}
