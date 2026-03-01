package com.ecommerce;

import javax.persistence.*;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    public void saveOrder(PurchaseOrder o) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
        em.close();
    }

    public PurchaseOrder findOrder(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        PurchaseOrder order = em.find(PurchaseOrder.class, id);
        em.close();
        return order;
    }

    public List<PurchaseOrder> findOrdersByUser(Long userId) {
        EntityManager em = JPAUtil.getEntityManager();
        List<PurchaseOrder> list = em.createQuery(
                "SELECT o FROM User u JOIN u.orders o WHERE u.id = :id",
                PurchaseOrder.class)
                .setParameter("id", userId)
                .getResultList();
        em.close();
        return list;
    }
}