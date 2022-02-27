package persistance;

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
	
	// getbyUserid
	
	// getbyDocumentid
	
	// connect

	// getAllDocuments
	
	public List<Document> getAllDocuments(){
		List<Document> docs = new ArrayList<>();

		// requete sql
		String req = "SELECT * FROM DOCUMENT";
		Statement stmt = conn.createStatement();

		// On recupere le resultat et on le parcourt pour ajouter dans la liste
		ResultSet res = stmt.executeQuery(req);
		while (res.next()){

		}

		
	}
	
	// getAllUsers
	
	// returnDocument

}
