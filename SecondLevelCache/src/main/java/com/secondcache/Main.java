package com.secondcache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        
//        Product p1 = new Product();
//        p1.setName("Laptop");
//        
//        Product p2 = new Product();
//        p2.setName("Mouse");
		
		insert();
		read();
	}
	
	public static void insert() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Product p = new Product();
        p.setName("Book");
        et.begin();
        em.persist(p);
        et.commit();
	}
	
	public static void read() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction et = em1.getTransaction();
        System.out.println("========First cache=============");
        Product p1 = em1.find(Product.class, 1);
        System.out.println(p1.getName());
        em1.close();
        
        System.out.println("=========Second Cache===========");
        EntityManager em2 = emf.createEntityManager();
        Product p2 = em2.find(Product.class, 1);
        System.out.println(p2.getName());
        
        em2.close();
	}
	
}