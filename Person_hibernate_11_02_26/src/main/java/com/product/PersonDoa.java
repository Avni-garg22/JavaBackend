package com.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersonDoa {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public String insertPerson(Person p) {
		EntityTransaction et = em.getTransaction();
		if(p!= null) {
			et.begin();
			em.persist(p);
			et.commit();
			return "Data inserted";
		}else {
			return "Illegal Argument";
		}
	}
	
	public String deletePerson(int id) {
		Person p = em.find(Person.class, id);
		if(p!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(p);
			et.commit();
			return "Data deleted";
		}else {
			return "Data not found";
		}
	}
	
	public String updatePerson(Person p) {
		EntityTransaction et = em.getTransaction();
		if(p!= null) {
			et.begin();
			em.merge(p);
			et.commit();
			return "Data updated";
		}else {
			return "Data not found";
		}
	}
	
	public Person findPerson(int id) {
		Person p = em.find(Person.class, id);
		if (p == null) {
            throw new IllegalArgumentException("Person not found with id : " + id);
        }
        return p;
	}
	
	public List<Person> findAllPersons() {
        Query q = em.createQuery("SELECT p FROM Person p");
        return q.getResultList();
    }
}