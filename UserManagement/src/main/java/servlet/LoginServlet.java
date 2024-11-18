package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
	//	request.getRequestDispatcher("AdminHome.html").forward(request, response);
		
		//Login validation of empty fields
		if (password.isBlank() || !Validation.isValid(email)) {
			System.out.println("Enter Valid email and password.");
			response.getWriter().println("<em>Email or password cannot be blank.</em>");			
		} else {

			UserDAO dao = new UserDAO();
			User user = dao.getUser(email, password);
			
			if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
			
				RequestDispatcher rd = request.getRequestDispatcher("userhome");
				rd.forward(request, response);
		}
		else if(email.equals("admin@gmail.com") && (password.equals("Admin@123"))) {
			response.getWriter().println("<em>You Logged in as Admin</em>");
			response.getWriter().println("<a href='AdminHome.html'>Go To Admin Home</a>");
		} 
		else {
//				response.getWriter().println("Welcome....<br>");
//				response.getWriter().print("Email: " + email + "<br><br>");
//				response.getWriter().print("Password: " + password  + "<br><br>");
			
			System.out.println("user not found");
			response.getWriter().print("Login Failed");
			response.getWriter().print("Try again");
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
		
				//response.getWriter().println("<a href='userhome?email="+email +"&password="+password+"'>Welcome to User Home");				
		}
		}
		}
		

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}


}
