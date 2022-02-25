package persistance;

public abstract class User implements mediatek2022.Utilisateur{
	private int id;
	private String name;
	private String password;
	private Object[] data;
	
	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	@Override
	public String name() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getId() {
		return this.id;
	}

}
