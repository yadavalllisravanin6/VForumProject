package ServletPagePackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOClasses.RegistrationDAO;
import EntityClassesPackage.Employee;

/**
 * Servlet implementation class RegistrationPage
 */
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String empid=request.getParameter("emp_id");
        String name=request.getParameter("emp_name");
        String desgn=request.getParameter("emp_designation");
        String loc=request.getParameter("locations");
        String uname=request.getParameter("user_name");
        String password=request.getParameter("password");
        int emp_id=Integer.parseInt(empid);
        Employee emp=new Employee(emp_id,name,desgn,loc,uname,password);
        RequestDispatcher dispatcher=null;
        RegistrationDAO rdao=new RegistrationDAO();
        
        if(rdao.EmployeeIdCheck(emp_id)==false){
        	out.println("<html><head></head><body onload=\"alert('Employee already exists')\"></body></html>");
        	dispatcher=request.getRequestDispatcher("Registration.html");
        	dispatcher.include(request,response);
        }
        else
        {
        	if(rdao.UserNameCheck(uname)==false){
        		out.println("<html><head></head><body onload=\"alert('User Name already exists')\"></body></html>");
        		dispatcher=request.getRequestDispatcher("Registration.html");
            	dispatcher.include(request,response);
        	}
        	
        }

        if(rdao.register(emp)!=0){
        	//out.println("<html><head></head><body onload=\"alert('Successfully registered')\"></body></html>");
        	//out.println("Successfully registered");
        	HttpSession session=request.getSession();
        	session.setAttribute("id", emp_id);
        	dispatcher=request.getRequestDispatcher("frames.html");
        	dispatcher.forward(request,response);
        }
        else
        {
        	out.println("<html><head></head><body onload=\"alert('Try again later')\"></body></html>");
        }

	}

}
