package ServletPagePackage;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOClasses.AnswerDAO;

/**
 * Servlet implementation class HrAnswerServlet
 */
public class HrAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer=request.getParameter("answer");
        HttpSession session= request.getSession(false);
    	int emp_id=(int) session.getAttribute("id");
    	int postId=Integer.parseInt(request.getParameter("postId"));
//    	int answerpostId=(int)session.getAttribute("questionId");
    	//System.out.println("Add answer post id"+answerpostId);
        
        AnswerDAO adao=new AnswerDAO();
        int count=0;
		try {
			count = adao.addAnswer(postId, answer, emp_id);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("HrServlet");
		rd.include(request, response);
	}

}
