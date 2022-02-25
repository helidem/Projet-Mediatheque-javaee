package services.auth;

import javax.servlet.http.*;

import mediatek2022.*;

public class Login extends HttpServlet {
	
	
	public Login() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// get session information
		HttpSession session = request.getSession();
		// get login form information
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		try {
			Utilisateur u = Mediatheque.getInstance().getUser(login, password);
			
			
		} catch (Exception e) {
			
		}
	}
}
