package fr.digi.d16.dal.jpa;

import fr.digi.d16.bo.Article;
import fr.digi.d16.dal.IDAO;

import java.sql.SQLException;
import java.util.Set;

public class ArticleJPADAO implements IDAO<Article, Integer> {
	@Override
	public void create( Article object ) {
	
	}
	
	@Override
	public Article findById( Integer integer ) {
		return null;
	}
	
	@Override
	public Set<Article> findAll() throws SQLException {
		return null;
	}
	
	@Override
	public void update( Article object ) {
	
	}
	
	@Override
	public void delete( Article object ) {
	
	}
}
