package persistance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    static {
        instance = new DBManager();
    }
    public static DBManager getInstance(){
        return instance;
    }
    private static DBManager instance;
    private Connection conn;

    public DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/mediatek", "root", "");
        } catch (Exception e) {
            System.out.println("J'ARRIVE PAS A ACCEDER A LA BASE");
            e.printStackTrace();
        }
    }

    // getfromDocumentid
    public Document getDocumentByID(int id) {
        Document fetchedDocument = null;
        try {
            String request = "SELECT * FROM DOCUMENT WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(request);
            pstm.setInt(1, id);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                boolean dispo = res.getBoolean("Disponible");
                String titre = res.getString("Titre");
                String auteur = res.getString("Auteur");
                int type = res.getInt("Type");
                String proprietaire = res.getString("Propriétaire");
                fetchedDocument = new persistance.Document(id, titre, auteur, dispo, type, proprietaire);
            }
            System.out.println(fetchedDocument);
            return fetchedDocument;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // connect
    public Utilisateur getUser(String login, String password) {
        Utilisateur fetchedUser = null;
        try {
            // String request = "SELECT * FROM Utilisateur WHERE Login='"+login+"' AND Password='"+password+"'";
            String request = "SELECT * FROM Utilisateur WHERE Login=? AND Password=?";
            PreparedStatement pstm = conn.prepareStatement(request);
            pstm.setString(1, login);
            pstm.setString(2, password);
            // Statement stmt = conn.createStatement();
            // ResultSet res = stmt.executeQuery(request);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                boolean isBibliothecaire = res.getBoolean("Bib");
                String userLogin = res.getString("login");
                String userPassword = res.getString("password");
                if (isBibliothecaire) {
                    fetchedUser = new persistance.Bibliothécaire(userLogin, userPassword);
                } else {
                    fetchedUser = new persistance.Abonné(userLogin, userPassword);
                }
            }
            return fetchedUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // getDocumentsDispo
    public List<mediatek2022.Document> getDocumentsDispo() throws Exception {
        List<mediatek2022.Document> docs = new ArrayList<>();

        // requete sql
        String req = "SELECT * FROM Document WHERE Disponible = 1";
        Statement stmt = conn.createStatement();

        // On recupere le resultat et on le parcourt pour ajouter dans la liste
        ResultSet res = stmt.executeQuery(req);
        while (res.next()) {
            int id = res.getInt("Id");
            boolean dispo = res.getBoolean("Disponible");
            String titre = res.getString("Titre");
            String auteur = res.getString("Auteur");
            int type = res.getInt("Type");
            String proprietaire = res.getString("Propriétaire");
            docs.add(new persistance.Document(id, titre, auteur, dispo, type, proprietaire));
        }
        return docs;
    }

    // returnDocument
    public void retournerDocument() {
        try {
            Statement stmt = conn.createStatement();
            String request = "UPDATE Document SET Disponible = 1 AND Propriétaire = 'NULL'";
            ResultSet res = stmt.executeQuery(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // emprunt
    public void emprunt(Document d, Utilisateur u) {
        try {
            Statement stmt = conn.createStatement();
            String request = "UPDATE Document SET Disponible = 0 AND Propriétaire = '" + u.name() + "'WHERE id ="+ d.getId();
            int res = stmt.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDocument(String titre, String auteur, int type, String description) {
        try {
            Statement stmt = conn.createStatement();
            String request = "INSERT INTO `document` (`Titre`, `Auteur`, `Type`, `Propriétaire`, `Description`) VALUES ('" + titre + "', '" + auteur + "', '" + type + "', NULL, '" + description + "')";
            System.out.println(request);
            int res = stmt.executeUpdate(request);
            System.out.println("Document '" + titre + "' de '" + auteur + "' ajouté");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}