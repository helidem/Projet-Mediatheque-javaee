package persistance;

public class Abonné extends Utilisateur {
	
	
	
	public Abonné(String login, String password) {
		super(login, password);
	}

	@Override
	public boolean isBibliothecaire() {
		return false;
	}

	@Override
	public Object[] data() {
		// TODO Auto-generated method stub
		return null;
	}

}
