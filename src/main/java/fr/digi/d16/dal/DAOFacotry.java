package fr.digi.d16.dal;

import fr.digi.d16.bo.Article;
import fr.digi.d16.dal.jdbc.ArticleJDBCDAO;
import fr.digi.d16.dal.jdbc.UilisateurJDBCDAO;
import fr.digi.d16.dal.jpa.ArticleJPADAO;
import fr.digi.d16.dal.jpa.UtilisateurJPADAO;

import java.util.ResourceBundle;

public final class DAOFacotry {
	
	
	private static final String STORE_MODE;
	
	static {
		ResourceBundle resourceBundle = ResourceBundle.getBundle( "db" );
		STORE_MODE = resourceBundle.getString( "store.mode" );
	}
	
	private DAOFacotry() {
	}
	
	public static IDAO<Article, Integer> getArticleDAO() {
		
		IDAO<Article, Integer> dao = null;
		switch ( STORE_MODE ) {
			case "JDBC" :
				dao = new ArticleJDBCDAO();
				break;
			case "JPA":
				dao = new ArticleJPADAO();
				break;
		}
		return dao;
	}
	
	public static IUtilisateurDAO getUtilisateurDAO() {
		IUtilisateurDAO dao = null;
		switch ( STORE_MODE ) {
			case "JDBC" :
				dao = new UilisateurJDBCDAO();
				break;
			case "JPA":
				dao = new UtilisateurJPADAO();
				break;
		}
		return dao;
	}
}
