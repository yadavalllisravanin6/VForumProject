package ServletPagePackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOClasses.LoginDAO;

/**
 * Servlet implementation class DBConnect
 */
public class ServletPage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//GetConnection gcon=new GetConnection();
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String empid=request.getParameter("fname");
        String password=request.getParameter("fpwd");
        int emp_id=Integer.parseInt(empid);
        RequestDispatcher dispatcher=null;
        LoginDAO loginDAO=new LoginDAO();
       String id= loginDAO.login(emp_id);
        out.println("hi");
        if(id==null){
        	out.println("<html><head></head><body onload=\"alert('Employee does not exists')\"></body></html>");
        	dispatcher=request.getRequestDispatcher("HomePage.html");
        	dispatcher.include(request,response);
        }
        else if (id.equals(password)){
        	HttpSession session=request.getSession();
        	session.setAttribute("id", emp_id);
        	dispatcher=request.getRequestDispatcher("frames.html");
        	dispatcher.forward(request,response);
        }
        else
        {
        	out.println("<html><head></head><body onload=\"alert('Invalid Password')\"></body></html>");
        	dispatcher=request.getRequestDispatcher("HomePage.html");
        	dispatcher.include(request,response);
        	
        }
	}

}
