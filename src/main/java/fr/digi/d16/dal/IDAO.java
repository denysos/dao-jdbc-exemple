package fr.digi.d16.dal;

import java.sql.SQLException;
import java.util.Set;

public interface IDAO <T, ID> {
	
	void save( T object );
	T findById(ID id);
	Set<T> findAll() throws SQLException;
	void update(T object);
	void delete(T object);
}
