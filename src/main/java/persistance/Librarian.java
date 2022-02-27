package persistance;

public class Librarian extends User{
	

	public Librarian(int id, String name, String password) {
		super(id, name, password);
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
