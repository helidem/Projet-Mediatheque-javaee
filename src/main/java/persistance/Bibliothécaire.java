package persistance;

public class Bibliothécaire extends Utilisateur {
	

	public Bibliothécaire(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isBibliothecaire() {
		return true;
	}

	@Override
	public Object[] data() {
		// TODO Auto-generated method stub
		return null;
	}

}
