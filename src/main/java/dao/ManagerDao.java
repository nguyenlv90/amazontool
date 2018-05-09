package dao;

import java.util.List;

public interface ManagerDao<T, ID>  {
	public void add(T entity);
	public <T> T update(T entity);
	public void delete(T entity);
	public <T> T findByID(Class<T> entityClass, int iD);
	public <T> T findByID(Class<T> entityClass, String iD);
	public List<T> findAll(Class<T> entityClass,String query);
	
}
