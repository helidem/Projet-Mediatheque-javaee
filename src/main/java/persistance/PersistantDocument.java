package persistance;

import mediatek2022.Utilisateur;

public class PersistantDocument implements mediatek2022.Document {
    private int id;
    private String titre;
    private String auteur;
    private boolean dispo;
    private int type;
    private String proprietaire;
    private static DBManager db = DBManager.getInstance();
    public PersistantDocument(int id, String titre, String auteur, boolean dispo, int type, String proprietaire) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.dispo = dispo;
        this.type = type;
        this.proprietaire = proprietaire;
    }

    @Override
    public boolean disponible() {
        return this.dispo;
    }

    public int getId() {
        return id;
    }

    @Override
    public void emprunt(Utilisateur u) throws Exception {
        if(this.dispo == false) {
            throw new IndispoException();
        } else {
            this.dispo = false;
            db.emprunt(this, (persistance.Utilisateur) u);

        }
    }

    @Override
    public void retour() {
        try {
            if (!this.dispo) {
                this.dispo = true;
                db.retournerDocument();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "{ Titre : " + titre +
                ", Id : " + id +
                ", Disponibilité : " + dispo +
                ", Auteur : " + auteur +
                ", Type : " + type +
                ", Proprietaire : " + proprietaire +" }";
    }
}
