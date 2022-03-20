package persistance;

import mediatek2022.Document;

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

    /**
     * Retourne un document à partir de l'identifiant fourni
     * @param id l'id du document qu'on cherche a obtenir
     * @return l'objet Document recherché
     */
    public PersistantDocument getDocumentByID(int id) {
        PersistantDocument fetchedDocument = null;
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
                fetchedDocument = new PersistantDocument(id, titre, auteur, dispo, type, proprietaire);
            }
            System.out.println(fetchedDocument);
            return fetchedDocument;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retourne un Utilisateur a partir de son login et mot de passe
     * @param login le login de l'Utilisateur
     * @param password le mot de passe de l'Utilisateur
     * @return l'objet Utilisateur
     */
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

    /**
     * Retourne une List de tous les documents qui ne sont pas actuellement empruntés par quelqu'un
     * @return La List en question
     * @throws Exception
     */
    public List<Document> getDocumentsDispo() throws Exception {
        List<Document> docs = new ArrayList<>();

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
            docs.add(new PersistantDocument(id, titre, auteur, dispo, type, proprietaire));
        }
        return docs;
    }

    /**
     * Permet de retoutner un document, il ne se passe rien si le document est empruntable
     */
    public void retournerDocument() {
        try {
            Statement stmt = conn.createStatement();
            String request = "UPDATE Document SET Disponible = 1, Propriétaire = NULL";
            int res = stmt.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cette fonction permet à l'Utilisateur d'emprunter un Document
     * @param d le document à emprunter
     * @param u l'utilisateur qui emprunte
     */
    public void emprunt(PersistantDocument d, Utilisateur u) {
        try {
            String request = "UPDATE Document SET Disponible = 0, Propriétaire = ? WHERE id = ?";
            System.out.println(request);
            System.out.println(u.name());
            PreparedStatement pstm = conn.prepareStatement(request);
            pstm.setString(1,u.name());
            pstm.setInt(2,d.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cette méthode permet aux bibliothecaires d'ajouter un document à la base
     * @param titre le titre du document
     * @param auteur l'auteur du document
     * @param type le type du document (cd ou livre)
     * @param description la description du document
     */
    public void addDocument(String titre, String auteur, int type, String description) {
        try {
            String request = "INSERT INTO `document` (`Titre`, `Auteur`, `Type`, `Propriétaire`, `Description`) VALUES (?, ?, ?, NULL, ?)";
            PreparedStatement pstm = conn.prepareStatement(request);
            pstm.setString(1,titre);
            pstm.setString(2,auteur);
            pstm.setInt(3,type);
            pstm.setString(4,description);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}