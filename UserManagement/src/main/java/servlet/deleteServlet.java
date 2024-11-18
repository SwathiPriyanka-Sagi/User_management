package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String name = request.getParameter("name");
		        String email = request.getParameter("email");
		        String password = request.getParameter("password");

		        UserDAO userDao = new UserDAO();
		        boolean isDeleted = userDao.deleteUser(name, email, password);

		        response.setContentType("text/html");
		        if (isDeleted) {
		            response.getWriter().println("<em>User deleted successfully!</em>");
		        } else {
		            response.getWriter().println("<em>User deletion failed! Please check your credentials.</em>");
		        }
		    }

		    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // Redirect to the delete form or show an error
		    	doGet(request, response);
		    }
}
