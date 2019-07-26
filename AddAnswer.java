package ServletPagePackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAnswer
 */
public class AddAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
