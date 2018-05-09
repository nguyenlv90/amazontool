package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import until.Constance;


public class ManagerDaoImpl<T, ID> implements ManagerDao<T, ID> {
	
	private static EntityManagerFactory emf;
	
	
	//===========================Get-Set=======================================
	
	static {
		emf  = Persistence.createEntityManagerFactory(Constance.PERSISTENCENAME);
	}
	

	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	
	//==================================================
	
	@Override
	public void add(T entity) {
		EntityManager em = getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
	}
	
	@Override
	public <T> T update(T entity) {
		EntityManager em = getEntityManager();
		try{
			em.getTransaction().begin();
			entity = em.merge(entity);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return entity;
	}

	@Override
	public void delete(T entity) {
		EntityManager em = getEntityManager();
		try{
			em.getTransaction().begin();
			if(entity != null) {
				em.remove(em.contains(entity)? entity : em.merge(entity));
				em.getTransaction().commit();
			}
		} finally {
			em.close();
		}
	}

	@Override
	public <T> T findByID(Class<T> entityClass, int iD) {
		EntityManager em = getEntityManager();
		try{			
			em.getTransaction().begin();
			T ent = em.find(entityClass, iD);
			return ent;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entityClass,String query) {
		List<T> entities;
		EntityManager em = getEntityManager();
		try{
			em.getTransaction().begin();
			entities = em.createQuery(query).getResultList();
		} finally {
			em.close();
		}
		return entities;
	}

	@Override
	public <T> T findByID(Class<T> entityClass, String iD) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
