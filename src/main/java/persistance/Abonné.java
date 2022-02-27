package persistance;

public class Abonné extends Utilisateur {
	
	
	
	public Abonné(String name, String password) {
		super(name, password);
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
