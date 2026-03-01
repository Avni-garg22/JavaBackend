package com.ecommerce;

import javax.persistence.*;

public class UserDAOImpl implements UserDAO {

    public void saveUser(User u) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }

    public User findUser(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public void deleteUser(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    public void updateUser(User u) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
    }
}