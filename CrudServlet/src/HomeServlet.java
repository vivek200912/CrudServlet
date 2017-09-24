

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(description = "This servlet will get invoke on click of home button in the application", urlPatterns = { "/HomeServlet" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Here first check whether user is already logged in.
		// If user is already logged in then navigate user to welcomeUser.jsp
		// Otherwise navigate user to index.jsp
		if(request.getSession().getAttribute("loggedInUser") == null){
			RequestDispatcher RequestDispatcherObj = request.getRequestDispatcher("/index.jsp");
			RequestDispatcherObj.forward(request, response);
		} else {
			RequestDispatcher RequestDispatcherObj = request.getRequestDispatcher("/welcomeUser.jsp");
			RequestDispatcherObj.forward(request, response);
		}
	}

}
