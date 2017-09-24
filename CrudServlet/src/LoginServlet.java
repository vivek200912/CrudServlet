
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String errorMsg = "Invalid Username or Password";
		String userName = request.getParameter("uname");
		String password = request.getParameter("psw");
		
		Boolean validUser = false;
		validUser = UserDao.validateUser(userName, password);
		if (!validUser) {
			request.setAttribute("errors", errorMsg);
			RequestDispatcher RequestDispatcherObj = request
					.getRequestDispatcher("/login.jsp");
			RequestDispatcherObj.forward(request, response);
		} else {
			if(request.getParameter("rememberMe") != null){
				//HttpSession session=request.getSession();  
		        request.getSession().setAttribute("userName",userName);
		        request.getSession().setAttribute("password",password);
			}
			request.getSession().setAttribute("loggedInUser", userName);
			RequestDispatcher RequestDispatcherObj = request
					.getRequestDispatcher("/welcomeUser.jsp");
			RequestDispatcherObj.forward(request, response);
		}
	}

}
