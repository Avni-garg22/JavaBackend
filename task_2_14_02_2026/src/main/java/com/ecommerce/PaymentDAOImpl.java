package com.ecommerce;

import javax.persistence.*;

public class PaymentDAOImpl implements PaymentDAO {

    public void savePayment(Payment p) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public Payment findPayment(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Payment payment = em.find(Payment.class, id);
        em.close();
        return payment;
    }
}