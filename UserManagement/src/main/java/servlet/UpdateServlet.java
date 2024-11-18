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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		UserDAO dao = new UserDAO();
		int i = Integer.parseInt(id);
		int rows = dao.updateUser(i, name, email, password);
		if(rows == 1) {
			response.getWriter().print("<em><strong>Updated Successfully</strong></em>");
			User updateUser = dao.getUser(email, password);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateUser);
			} else {
			response.getWriter().print("<em><strong>Updation Failed</strong></em>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("userhome");
		rd.include(request, response);
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
