package com.Fintect;

import javax.persistence.*;
import java.util.List;

public class CustomerDAO {

    public void save(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(customer);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public List<Customer> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Customer> list =
                em.createQuery("SELECT c FROM Customer c", Customer.class)
                        .getResultList();
        em.close();
        return list;
    }

    public Customer findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Customer c = em.find(Customer.class, id);
        em.close();
        return c;
    }
}
