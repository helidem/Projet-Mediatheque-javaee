package mediatek2022;

import java.util.List;

public interface PersistentMediatheque {
// Jean-François Brette 01/01/2022
	
	List<Document> tousLesDocumentsDisponibles();
	Document getDocument(int numDocument);
	Utilisateur getUser(String login, String password);
	void ajoutDocument(int type, Object... args );

}
