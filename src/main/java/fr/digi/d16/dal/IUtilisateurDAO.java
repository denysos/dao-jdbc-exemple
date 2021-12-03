package fr.digi.d16.dal;

import fr.digi.d16.bo.Utilisateur;

import java.net.UnknownServiceException;
import java.sql.SQLException;

public interface IUtilisateurDAO extends IDAO<Utilisateur, Integer> {
	
	public Utilisateur findByLoginAndPassword(String login, String password) throws SQLException;
}
