package mockitopractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDao {
	//only crud operation in userDao not main no calculations
EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
EntityManager em=emf.createEntityManager();

public void insertUsers() {
	EntityTransaction et=em.getTransaction();
	User user=new User();
	user.setId(1);
	user.setName("Avni");
	user.setBalance(2000);
	
	et.begin();
	em.persist(user);
	et.commit();
	
}

public User findById(int id) {
	return em.find(User.class,1);
}

}
