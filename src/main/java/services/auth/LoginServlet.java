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
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// get session information
		HttpSession session = request.getSession();
		session.setAttribute("message","");
		// get login form information
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		try {
			Utilisateur u = Mediatheque.getInstance().getUser(login, password);
			if(u == null){
				session.setAttribute("message","Erreur, utilisateur inconnu !");
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

			}
			session.setAttribute("utilisateur",u); // dans le jsp getAttribute(...);
			if(u.isBibliothecaire()){
				response.sendRedirect("librarian/librarian-view.jsp");
			} else {
				response.sendRedirect("subscriber/subscriber-view.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
