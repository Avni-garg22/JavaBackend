package com.Fintect;

import javax.persistence.*;
import java.util.List;

public class TransactionDAO {

    public void save(Transaction txn, Long accId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            BankAccount acc = em.find(BankAccount.class, accId);
            acc.addTransaction(txn);
            em.persist(txn);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public List<Transaction> findByAccount(Long accId) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Transaction> list =
                em.createQuery(
                        "SELECT t FROM Transaction t WHERE t.bankAccount.accountId = :id",
                        Transaction.class)
                        .setParameter("id", accId)
                        .getResultList();

        em.close();
        return list;
    }
}
