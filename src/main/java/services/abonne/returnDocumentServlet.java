package services.abonne;

import mediatek2022.Document;
import mediatek2022.Mediatheque;
import mediatek2022.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class returnDocumentServlet extends HttpServlet {


    public returnDocumentServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        System.out.println("DANS LE doGet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get session information
        HttpSession session = request.getSession();
        Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
        System.out.println(u);
        session.setAttribute("messageEmprunt", "");
        session.setAttribute("messageRetour", "");
        // get document registration form information
        String numeroDocument = request.getParameter("documentARetourner");
        Document documentARetourner = Mediatheque.getInstance().getDocument(Integer.parseInt(numeroDocument));
        System.out.println("Document : " + documentARetourner);
        try {
            Mediatheque.getInstance().retour(documentARetourner, u);
            session.setAttribute("messageRetour", "Document N°" + numeroDocument + " retourné !");
        } catch (Exception e) {
            session.setAttribute("messageRetour", "Vous n'êtes pas en possession du document N°" + numeroDocument + " !");
            response.sendRedirect("subscriber/subscriber-view.jsp");
        }
        // this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response); // il faut le mettre plus tôt
    }
}
