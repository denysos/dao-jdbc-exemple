package fr.digi.d16.dal.jdbc;

import fr.digi.d16.bo.Utilisateur;
import fr.digi.d16.dal.IUtilisateurDAO;

import java.sql.SQLException;
import java.util.Set;

public class UilisateurJDBCDAO implements IUtilisateurDAO {
	
	//COnstantes de queries
	@Override
	public void create( Utilisateur object ) {
	
	}
	
	@Override
	public Utilisateur findById( Integer integer ) {
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
	public Utilisateur findByLoginAndPassword( String login, String password ) {
		return null;
	}
}
