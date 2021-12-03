package fr.digi.d16.dal.jdbc;

import fr.digi.d16.bo.Utilisateur;
import fr.digi.d16.dal.IUtilisateurDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class UtilisateurJDBCDAO implements IUtilisateurDAO {
	
	private static final String AUTHENT_QUERY = "SELECT * FROM utilisateur WHERE login = ? AND password = ?";
	// private static final String AUTHENT_QUERY = "SELECT * FROM utilisateur WHERE login = '%s' AND password = '%s'";
	
	//COnstantes de queries
	@Override
	public void create( Utilisateur object ) {
	
	}
	
	@Override
	public Utilisateur findById( Integer id ) {
		return null;
	}
	
	@Override
	public Set<Utilisateur> findAll() throws SQLException {
		return null;
	}
	
	@Override
	public void update( Utilisateur object ) {
	
	}
	
	@Override
	public void delete( Utilisateur object ) {
	
	}
	
	@Override
	public Utilisateur findByLoginAndPassword( String login, String password ) throws SQLException {
		Utilisateur utilisateur = null;
		Connection connection = PersistenceManager.getConnection();
		try ( PreparedStatement pst = connection.prepareStatement( AUTHENT_QUERY ) ) {
			pst.setString( 1, login );
			pst.setString( 2, password );
			try ( ResultSet rs = pst.executeQuery() ) {
				if ( rs.next() ) {
					int id = rs.getInt( "id" );
					String fullname = rs.getString( "nom_complet" );
					String loginU = rs.getString( "login" );
					String passwordU = rs.getString( "password" );
					utilisateur = new Utilisateur( id, fullname, loginU, passwordU );
				}
			}
		}
		
		// try ( Statement st = connection.createStatement();
		// 	  ResultSet rs = st.executeQuery( String.format( AUTHENT_QUERY, login, password ).replace( "'", "''" ) ) ) {
		// 	System.out.println(String.format( AUTHENT_QUERY, login, password ));
		// 	if ( rs.next() ) {
		// 		int id = rs.getInt( "id" );
		// 		String fullname = rs.getString( "nom_complet" );
		// 		String loginU = rs.getString( "login" );
		// 		String passwordU = rs.getString( "password" );
		// 		utilisateur = new Utilisateur(id, fullname, loginU, passwordU);
		// 	}
		// }
		return utilisateur;
	}
}
