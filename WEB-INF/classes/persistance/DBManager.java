package persistance;

import java.sql.*;

public class DBManager{
	private Connection conn;
	
	public DBManager()
	
	// Connexion
	
	public void Connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:50000/mediatek", "root","root");
		}
	
	// Userinsertion

	// getbyUserid
	
	// getbyDocumentid
	
	// deleteUser
	
	// deleteDocument
	
	// connect

	// getAllDocuments
	
	// getAllUsers
	
	// returnDocument

}
