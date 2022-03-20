package services.auth;

import mediatek2022.Mediatheque;
import mediatek2022.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {


    public LoginServlet() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mediatheque m = Mediatheque.getInstance();
        // get session information
        HttpSession session = request.getSession();
        session.setAttribute("message", "");
        // get login form information
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            Utilisateur u = m.getUser(login, password);
            if (u == null) {
                session.setAttribute("message", "Erreur, utilisateur inconnu !");
                this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                session.setAttribute("utilisateur", u); // dans le jsp getAttribute(...);
                if (u.isBibliothecaire()) {
                    response.sendRedirect("librarian/librarian-view.jsp");
                } else {
                    response.sendRedirect("subscriber/subscriber-view.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
