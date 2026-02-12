package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		//Entity Transaction - means obj to query
		EntityTransaction et = em.getTransaction();
		
		Student s=new Student();
		s.setId(2);
		s.setName("Aviii");
		s.setPercentage(80);
		et.begin();
		em.persist(s);
		et.commit();
		
		emf.close();
	}

}
