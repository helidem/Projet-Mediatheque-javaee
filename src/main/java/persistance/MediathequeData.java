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
        return null;
    }

    // va récupérer le User dans la BD et le renvoie
    // si pas trouvé, renvoie null
    @Override
    public Utilisateur getUser(String login, String password) {
        return null;
    }

    /**
     * @param numDocument le numéro du document
     */
    @Override
    public Document getDocument(int numDocument) {
        return null;
    }

    @Override
    public void ajoutDocument(int type, Object... args) {
        // args[0] -> le titre
        // args [1] --> l'auteur
        // etc... variable suivant le type de document
    }

}
