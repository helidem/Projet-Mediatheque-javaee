package services.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import mediatek2022.*;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
	
	
	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		// System.out.println("DANS LE DOGET");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// get session information
		HttpSession session = request.getSession();
		System.out.println("doPost");
		// get login form information
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		try {
			Utilisateur u = Mediatheque.getInstance().getUser(login, password);
			System.out.println(u);
			session.setAttribute("utilisateur",u);

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
