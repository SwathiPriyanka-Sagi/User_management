package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String ReEnterPassword = request.getParameter("ReEnterPassword");
		
		response.setContentType("text/html");
		
		if (username.isBlank() || !Validation.isValid(email) || password.isBlank() || ReEnterPassword.isBlank() ) {
			//System.out.println("Enter Valid details.");
			response.getWriter().println("Enter Valid details..");
		
		} else if(!password.equals(ReEnterPassword)) {
			//System.out.println("Enter Valid email and password.");
			response.getWriter().println("<em>Email or password cannot be blank.</em>");
		} else {
			UserDAO dao = new UserDAO();
			
		  int rows = dao.insertUser(username, email, password);
		  if(rows == 1)
		  {
			  response.getWriter().print("<em><strong>Registered Successfully !</strong></em><br><br>"); 
			  RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			  rd.include(request, response);
		  }
		  else
		  {
			  response.getWriter().print("<em><strong>Registration Failed !</strong></em>"); 
		  }
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	   // String word = "Program";
	   // String term = "gram";
	    
	   // if(word.substring(3).equals(term)) {
	   //     System.out.println("same");
	   // } else {
	   //     System.out.println("Not Same");
	   // }
	   // System.out.println(word.substring(0, 4));
	   
//	   String str1 = "java";
//	   String str2 = "java 11";
//	   String str3 = str1.substring(0);
//	   String str4 = str2.substring(0,4);
//	   System.out.println(str4);
//	   System.out.println(str3 == str4);
//	   System.out.println(str3.equals(str4));
//	   System.out.println(str1 == str3);
//	   System.out.println(str1.equals(str3));

}
