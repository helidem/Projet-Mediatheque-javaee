package persistance;

public class Subsciber extends User {
	
	
	
	public Subsciber(int id, String name, String password) {
		super(id, name, password);
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
