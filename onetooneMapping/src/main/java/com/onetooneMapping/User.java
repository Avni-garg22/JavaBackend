package com.onetooneMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {
	public static void main(String[] args) {
	//	findByCarId();
		
		deleteEngineByCarId();
		}
			
		private static void findByCarId() {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			Car c=em.find(Car.class, 1);
			System.out.println(c.getEngine().getCc());  //engine object ref it will give use geting cc
		
	}
		
		public static void deleteEngineByCarId() {

		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		    EntityManager em = emf.createEntityManager();
		    EntityTransaction et = em.getTransaction();
  
		    Query updateQuery=em.createNativeQuery("Update car set engine_id=null where engine_id=?1");
		    		updateQuery.setParameter(1,100);
		    		Query deleteQuery=em.createNativeQuery("Delete From engine where id=?1");
		    		deleteQuery.setParameter(1, 100);
		    		et.begin();
		    		updateQuery.executeUpdate();
		    		deleteQuery.executeUpdate();
		    		et.commit();
		    		
		   
		    }
		



public static void insertCarAndEngine() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		
		Engine e=new Engine();
		e.setId(100);
		e.setType("V9");
		e.setFuelType("Diesel");
		e.setMileage("13");
		e.setCc("3000");
		
		
		Car c=new Car();
		c.setId(1);
		c.setModelYear("dt10");
		c.setBrand("volkswagen");
		c.setModelYear("2019");
		c.setPrice(10000000);
		c.setEngine(e);
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
		
		

	
	}

}