

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet(description = "This will log out user and redirect to home page", urlPatterns = { "/LogOutServlet" })
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Directly Navigate to home page i.e. index.jsp
		String msg = null;
		String loggedInUser = (String) request.getSession().getAttribute("loggedInUser");
		if(!loggedInUser.isEmpty()){
			msg = loggedInUser + ", You have successfully logged out from the system.";
		} else {
			msg = "You have successfully logged out from the system.";
		}
		request.setAttribute("msgOnLogOut", msg);
		request.getSession().invalidate();
		RequestDispatcher RequestDispatcherObj = request.getRequestDispatcher("/index.jsp");
		RequestDispatcherObj.forward(request, response);
	}

}
