package fr.digi.d16.dal;

import fr.digi.d16.bo.Utilisateur;

import java.net.UnknownServiceException;

public interface IUtilisateurDAO extends IDAO<Utilisateur, Integer> {
	
	public Utilisateur findByLoginAndPassword(String login, String password);
}
