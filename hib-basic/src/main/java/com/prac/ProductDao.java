package com.prac;

import java.util.List;
import javax.persistence.*;

public class ProductDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();

    // 1️ INSERT Product
    public String insertProduct(Product p) {
        EntityTransaction et = em.getTransaction();
        if(p!=null) {
        et.begin();
        em.persist(p);
        et.commit();
        return "data inserted";
        }else
        {
        	return "Illegal Argument" ;
        }
		
    }

    // 2️ DELETE Product by ID
    public void deleteProduct(int id) {//1,2,3
        Product p = em.find(Product.class, id);
        if (p != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(p);
            et.commit();
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // 3️ UPDATE Product
    public void updateProduct(Product p) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(p);
        et.commit();
        System.out.println("Product updated successfully.");
    }

    // 4️ FIND Product by ID
    public Product findProduct(int id) {
        return em.find(Product.class, id);
    }

    // 5️ FIND ALL Products
    public List<Product> findAllProducts() {
        Query q = em.createQuery("SELECT p FROM Product p");
        return q.getResultList();
    }

}