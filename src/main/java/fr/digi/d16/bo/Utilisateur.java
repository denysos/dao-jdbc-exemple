package fr.digi.d16.bo;

public class Utilisateur {
	
	private int id;
	private String fullname;
	private String login;
	private String password;
	
	public Utilisateur() {
	}
	
	public Utilisateur( String fullname, String login, String password ) {
		this.fullname = fullname;
		this.login = login;
		this.password = password;
	}
	
	public Utilisateur( int id, String fullname, String login, String password ) {
		this.id = id;
		this.fullname = fullname;
		this.login = login;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public void setFullname( String fullname ) {
		this.fullname = fullname;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin( String login ) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "Utilisateur{" );
		sb.append( "id=" ).append( id );
		sb.append( ", fullname='" ).append( fullname ).append( '\'' );
		sb.append( ", login='" ).append( login ).append( '\'' );
		sb.append( ", password='" ).append( password ).append( '\'' );
		sb.append( '}' );
		return sb.toString();
	}
}
