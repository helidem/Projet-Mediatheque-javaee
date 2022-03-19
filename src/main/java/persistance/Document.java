package persistance;

import mediatek2022.Mediatheque;
import mediatek2022.Utilisateur;

import javax.print.attribute.standard.Media;

public class Document implements mediatek2022.Document {
    private int id;
    private String titre;
    private String auteur;
    private boolean dispo;
    private int type;
    private String proprietaire;

    public Document(int id, String titre, String auteur, boolean dispo, int type, String proprietaire) {
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

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public boolean isDispo() {
        return dispo;
    }

    public int getType() {
        return type;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    @Override
    public void emprunt(Utilisateur u) throws Exception {
        if(this.dispo == false) {
            throw new IndispoException();
        } else {
            this.dispo = false;
            Mediatheque.getInstance().emprunt(this, u);
        }
        // TODO: mettre a jour dans la base
    }

    @Override
    public void retour() {
        if(!this.dispo)
            this.dispo = true;
        // else emprunt();
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
