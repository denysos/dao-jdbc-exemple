package fr.digi.d16.bo;

public class Article {
	
	private int id;
	private String reference;
	
	public Article() {
	}
	
	public Article( int id, String reference ) {
		this.id = id;
		this.reference = reference;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference( String reference ) {
		this.reference = reference;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "Article{" );
		sb.append( "id=" ).append( id );
		sb.append( ", reference='" ).append( reference ).append( '\'' );
		sb.append( '}' );
		return sb.toString();
	}
}
