package com.onetomany;

import java.util.*;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Collegee e=em.find(Collegee.class, 2);
		System.out.println(e);
		
//		Studentt s1 = new Studentt();
//		s1.setStudent_id(109);
//		s1.setBranch("CSE");
//		s1.setName("Allen");
//		
//		Studentt s2 = new Studentt();
//		s2.setStudent_id(108);
//		s2.setBranch("ECE");
//		s2.setName("Miller");
//		
//		Studentt s3 = new Studentt();
//		s3.setStudent_id(107);
//		s3.setBranch("Mech");
//		s3.setName("Eve");
//		
//		Collegee c = new Collegee();
//		
//		c.setId(2);
//		c.setName("ABC");
//		c.setLocation("Delhi");
//		c.setPincode("0001");
//		
//		List<Studentt> list = new ArrayList<>();
//		list.add(s1);
//		list.add(s2);
//		list.add(s3);
//		c.setS(list);
//		
//		et.begin();
//		em.persist(c);
//		em.persist(s1);
//		em.persist(s2);
//		em.persist(s3);
//		et.commit();
//		emf.close();
//		
		
	}
	
}