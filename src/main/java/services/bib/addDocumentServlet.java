package services.bib;

import mediatek2022.Mediatheque;
import persistance.DBManager;
import persistance.MediathequeData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class addDocumentServlet extends HttpServlet {


    public addDocumentServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        System.out.println("DANS LE doGet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get session information
        HttpSession session = request.getSession();
        session.setAttribute("message", "");
        // get document registration form information
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String type = request.getParameter("type");
        String description = request.getParameter("description");

        try {
            if (titre == "" || auteur == "" || type == "") {
                session.setAttribute("message", "Erreur, informations manquantes !");
                this.getServletContext().getRequestDispatcher("/librarian/librarian-view.jsp").forward(request, response);
            }
            if(type == "livre")
                type = "1";
            else
                type = "2";
            Mediatheque.getInstance().ajoutDocument(Integer.parseInt(type), titre, auteur, description);
            System.out.println("titre : " + titre + ", auteur : " + auteur + ", type : " + type + ", description : " + description);
            session.setAttribute("message", "Opération réussie !");

            response.sendRedirect("librarian/librarian-view.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response); // il faut le mettre plus tôt
    }
}
