package fr.digi.d16.dal.jdbc;

import fr.digi.d16.bo.Article;
import fr.digi.d16.dal.IDAO;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ArticleJDBCDAO implements IDAO<Article, Integer> {
	
	private static final String FIND_ALL_QUERY = "SELECT * FROM article";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM article WHERE id = %d";
	private static final String CREATE_QUERY = "INSERT INTO article (REF) VALUES ('%s')";
	
	@Override
	public void create( Article article ) throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		try(Statement st = connection.createStatement()) {
			st.executeUpdate( String.format( CREATE_QUERY, article.getReference()) );
		}
	}
	
	@Override
	public Article findById( Integer id ) throws SQLException {
		Article article = null;
		Connection connection = PersistenceManager.getConnection();
		try(Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery( String.format( FIND_BY_ID_QUERY, id))) {
			if (rs.next()) {
				article = new Article( rs.getInt(1),rs.getString( "REF" ) );
			}
		}
		return article;
	}
	
	@Override
	public Set<Article> findAll() throws SQLException {
		
		Set<Article> articles = new HashSet<>();
		Connection connection = PersistenceManager.getConnection();
		try( Statement st = connection.createStatement();
			 ResultSet rs = st.executeQuery( FIND_ALL_QUERY)) {
			while ( rs.next() ) {
				Article article = new Article(rs.getInt(1),rs.getString( "REF" ));
				articles.add( article );
			}
		}
		return articles;
	}
	
	@Override
	public void update( Article object ) {
		//TODO
	}
	
	@Override
	public void delete( Article object ) {
		//TODO
	}
}
