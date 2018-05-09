package service;

import java.util.List;


import dao.ManagerDaoImpl;
import entities.Trademark;

public class TrademarkService extends ManagerDaoImpl<Trademark, Integer> {
	
	public List<Trademark> getAll(){
   	 List<Trademark> listTrademark = findAll(Trademark.class, Trademark.GETALL);
   	 return listTrademark;
    }
	
	/*public List<Product> getListProductByStatus(String status){
		EntityManager em = getEntityManager();
      	 List<Product> list = em.createQuery("FROM Product e WHERE e.status= :status",Product.class)
      			 .setParameter("status", status)
      			 .getResultList();
       	em.close();
       	return list;
	}
	
	public List<Product> getListProductByStatus(String status, String status2){
		EntityManager em = getEntityManager();
      	 List<Product> list = em.createQuery("FROM Product e WHERE e.status= :status OR e.status= :status2 ORDER BY e.id ASC",Product.class)
      			 .setParameter("status", status)
      			 .setParameter("status2", status2)
      			 .getResultList();
       	em.close();
       	return list;
	}
	
	public List<Product> getFindByAssin(String assin){
		EntityManager em = getEntityManager();
      	 List<Product> list = em.createQuery("FROM Product e WHERE e.assin= :assin",Product.class)
      			 .setParameter("assin", assin).getResultList();
       	em.close();
       	return list;
	}*/
}
