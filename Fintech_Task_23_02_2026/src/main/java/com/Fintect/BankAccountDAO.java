package com.Fintect;

import javax.persistence.*;
import java.math.BigDecimal;

public class BankAccountDAO {

    public void save(BankAccount account) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(account);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void linkToCustomer(Long accId, Long custId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            BankAccount account = em.find(BankAccount.class, accId);
            Customer customer = em.find(Customer.class, custId);

            account.setCustomer(customer);
            customer.setBankAccount(account);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void updateBalance(Long accId, BigDecimal amount) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            BankAccount acc = em.find(BankAccount.class, accId);
            acc.setBalance(amount);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
