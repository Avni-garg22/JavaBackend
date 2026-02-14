package com.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main1 {
public static void main(String[] args) {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Collegee c= em.find(Collegee.class,2);
	
	List<Studentt> list= c.getS();

	Studentt s = new Studentt();
	s.setStudent_id(105);
	s.setBranch("IT");
	s.setName("Pankaj");
	
	list.add(s);
	c.setS(list);

	et.begin();
	em.persist(s);
	et.commit();
	
}
}
