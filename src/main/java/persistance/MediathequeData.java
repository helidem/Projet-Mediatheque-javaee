package persistance;

import java.util.List;
import mediatek2022.*;

// classe mono-instance  dont l'unique instance est connue de la médiatheque
// via une auto-déclaration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
    // Jean-François Brette 01/01/2018
    static {
        Mediatheque.getInstance().setData(new MediathequeData());
    }
    
    private DBManager db;

    private MediathequeData() {
    	this.db = new DBManager();
    }

    /**
     * Obtenir la liste de tous les documents disponibles
     * @return la liste des documents disponibles
     */
    @Override
    public List<Document> tousLesDocumentsDisponibles() {
        List<Document> docs = null;
        try {
            docs =  db.getDocumentsDispo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docs;
    }

    // va récupérer le User dans la BD et le renvoie
    // si pas trouvé, renvoie null
    @Override
    public Utilisateur getUser(String login, String password) {
        return db.getUser(login,password);
    }

    /**
     * @param numDocument le numéro du document
     */
    @Override
    public PersistantDocument getDocument(int numDocument) {
       return db.getDocumentByID(numDocument);
    }

    @Override
    public void ajoutDocument(int type, Object... args) {
        db.addDocument((String) args[0],(String) args[1], type,(String) args[2]);
        // args[0] -> le titre
        // args [1] --> l'auteur
        // etc... variable suivant le type de document
    }
}
