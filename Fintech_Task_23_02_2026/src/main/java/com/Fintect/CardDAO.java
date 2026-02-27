package com.Fintect;

import javax.persistence.*;

public class CardDAO {

    public void issueCard(Card card, Long accId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            BankAccount acc = em.find(BankAccount.class, accId);
            card.setBankAccount(acc);
            em.persist(card);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void assignCardToCustomer(Long cardId, Long custId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Card card = em.find(Card.class, cardId);
            Customer customer = em.find(Customer.class, custId);
            customer.getCards().add(card);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void deactivateCard(Long cardId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Card card = em.find(Card.class, cardId);
            card.setIsActive(false);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
