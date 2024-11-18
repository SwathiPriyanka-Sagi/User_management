package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

/**
 * Servlet implementation class UserHomeServlet
 */
@WebServlet("/userhome")
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		PrintWriter out = response.getWriter(); 
		out.println("Welcome......");
		out.println(user.getName());
		
		out.println("<h2>Welcome to User Home</h2><br><br>");
		out.print("<h3> Check Your details and update, as you see fit.</h3><br>");
						
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		out.println("<form action='update'><input type ='hidden' name='id'value='"+user.getId()+"'>");
		
		out.println("Name: <input type='text' Value ='"+user.getName()+"' name ='name'> ");
		out.println("Email: <input type='text' Value ='"+user.getEmail()+"'name ='email'>");
		out.println("Password: <input type='text' Value ='"+user.getPassword()+"'name ='password'>");
		
		out.print("<strong>Email:</strong>" +email+ "<br><br>");
		out.println("<strong>Password:</strong>" +password + "<br><br>");
		out.println("<Button>Update Details</Button>");
		//response.getWriter().print("<em>Updated Successfully</em>");
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
