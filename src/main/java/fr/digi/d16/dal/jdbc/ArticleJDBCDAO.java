package fr.digi.d16.dal.jdbc;

import fr.digi.d16.bo.Article;
import fr.digi.d16.dal.IDAO;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ArticleJDBCDAO implements IDAO<Article, Integer> {
	
	private static final String FIND_ALL_QUERY = "SELECT * from article";
	
	@Override
	public void save( Article object ) {
	
	}
	
	@Override
	public Article findById( Integer integer ) {
		return null;
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
	
	}
	
	@Override
	public void delete( Article object ) {
	
	}
}
