package com.hibernate_practice_self;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		
		Alienname an=new Alienname();
		an.setFname("gudda");
		an.setLname("guddi");
		an.setMname("bevkuf");
		
		
		// for saving the data
		Alien a = new Alien();
		a.setAid(102);
		a.setColor("dogla");
		a.setAname(an);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// for save
	em.persist(a);

		// for fetching
//	Alien a=em.find(Alien.class,101);

		tx.commit();
//		System.out.println(a);
		em.close();
		emf.close();

	}
}
