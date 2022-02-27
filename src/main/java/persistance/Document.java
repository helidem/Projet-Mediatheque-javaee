package persistance;

import mediatek2022.Utilisateur;

public class Document implements mediatek2022.Document {
    private int id;
    private String titre;
    private boolean dispo;

    public Document(int id, String titre, boolean dispo) {
        this.id = id;
        this.titre = titre;
        this.dispo = dispo;
    }

    @Override
    public boolean disponible() {
        return this.dispo;
    }

    @Override
    public void emprunt(Utilisateur u) throws Exception {
        if(!this.dispo) {
            throw new IndispoException();
        } else {
            this.dispo = false;
        }
    }

    @Override
    public void retour() {
        if(!this.dispo)
            this.dispo = true;
        // else emprunt();
    }
}
