package persistance;

import jdk.jshell.execution.Util;
import mediatek2022.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager{
	private Connection conn;
	
	public DBManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:50000/mediatek", "root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// getfromDocumentid
	public Document getDocumentByID(int id) {

		try {
			Statement stmt = conn.createStatement();
			String request = "SELECT * FROM DOCUMENT WHERE Id=" + id;
			ResultSet res = stmt.executeQuery(request);
			while (res.next()) {
				boolean dispo = res.getBoolean("Disponible");
				String titre = res.getString("Titre");
				String auteur = res.getString("Auteur");
				int type = res.getInt("Type");
				String proprietaire = res.getString("Propriétaire");
				Document fetchedDocument = new persistance.Document(id,titre,auteur,dispo,type,proprietaire);
				System.out.println(fetchedDocument);
				return fetchedDocument;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// connect
	public Utilisateur getUser(String login, String password) {
		try {
			Statement stmt = conn.createStatement();
			String request = "SELECT * FROM Utilisateur WHERE Login=\"" + login + "AND Password=\"" + password + "\"";
			ResultSet res = stmt.executeQuery(request);
			while (res.next()) {

				String userLogin = res.getString("login");
				String userPassword = res.getString("password");
				Utilisateur fetchedUser = new persistance.Abonné(login, password);
				System.out.println(fetchedUser);
				return fetchedUser;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// getDocumentsDispo
	public List<Document> getDocumentsDispo() throws Exception{
		List<Document> docs = new ArrayList<>();

		// requete sql
		String req = "SELECT * FROM Document WHERE Disponible = 1";
		Statement stmt = conn.createStatement();

		// On recupere le resultat et on le parcourt pour ajouter dans la liste
		ResultSet res = stmt.executeQuery(req);
		while (res.next()){
			int id = res.getInt("Id");
			boolean dispo = res.getBoolean("Disponible");
			String titre = res.getString("Titre");
			String auteur = res.getString("Auteur");
			int type = res.getInt("Type");
			String proprietaire = res.getString("Propriétaire");
			docs.add(new persistance.Document(id,titre,auteur,dispo,type,proprietaire));
		}
		return docs;
	}
	
	// getAllUsers
	
	// returnDocument

}
// ne pas regarder en bas c degeu
/*
        // on configule le driver
        Class.forName("oracle.jdbc.OracleDriver");

        // on se connecte à la base
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "etudiant", "ETUDIANT");

        /* exo 1
        // on crée la requete
        String req1 = "SELECT matricule, nom, age from pilote";
        Statement stmt = conn.createStatement();

        // on recupere le resultat et on le parcourt
        ResultSet res = stmt.executeQuery(req1);
        while(res.next()){
            int matricule = res.getInt("matricule");
            String nom = res.getString("nom");
            int age = res.getInt("age");
            System.out.println("Nom : " + nom + ", age : " + age + ", matricule : " + matricule);
        }*/

	// exo 2
        /*
        Scanner scanner = new Scanner( System.in );
        System.out.println("Entre la ville pour voir ses vols");
        String ville = scanner.nextLine();
        String req2 = "select numvol, villearrivee from vol where villedepart='" + ville + "'";
        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery(req2);


        if(!res.next())
            System.out.println("pas de vos partant de cette ville");
        else do {
            String numvol = res.getString("numvol");
            String villearrivee = res.getString("villearrivee");
            System.out.println(numvol + " -> " + villearrivee);
        } while (res.next());*/

	// exo 3 c'est presque la mm chose mais avec les prepared statement
        /*
        Scanner scanner = new Scanner( System.in );
        System.out.println("Entre la ville pour voir ses vols");
        String ville = scanner.nextLine();
        String req3 = "select numvol, villearrivee from vol where villedepart=?";
        PreparedStatement pstm = conn.prepareStatement(req3);

        pstm.setString(1,ville);
        ResultSet res = pstm.executeQuery();


        if(!res.next())
            System.out.println("pas de vos partant de cette ville");
        else do {
            String numvol = res.getString("numvol");
            String villearrivee = res.getString("villearrivee");
            System.out.println(numvol + " -> " + villearrivee);
        } while (res.next());*/

