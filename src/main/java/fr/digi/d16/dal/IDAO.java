package fr.digi.d16.dal;

import java.sql.SQLException;
import java.util.Set;

public interface IDAO <T, ID> {
	
	void create( T object ) throws SQLException;
	T findById(ID id) throws SQLException;
	Set<T> findAll() throws SQLException;
	void update(T object);
	void delete(T object);
}
