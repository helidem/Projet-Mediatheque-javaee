package persistance;

public abstract class Utilisateur implements mediatek2022.Utilisateur{
	private String login;
	private String password;
	private Object[] data;
	
	public Utilisateur( String login, String password) {

		this.login = login;
		this.password = password;
	}

	@Override
	public String name() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	


}
