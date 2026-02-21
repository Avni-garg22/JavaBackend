package many_to_one;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main1 {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	String sql1="update employee set department_id=null where department_id=?1";
			String sql2="delete from department where id=?1";
	Query updateQuery=em.createNativeQuery(sql1);
	updateQuery.setParameter(1,11);
	
	Query deleteQuery=em.createNativeQuery(sql2);
	deleteQuery.setParameter(1,11);
	
	et.begin();
	updateQuery.executeUpdate();
	deleteQuery.executeUpdate();
	et.commit();
	em.close();
	emf.close();
}
}
