package CRMsalesManagement;

import javax.persistence.EntityManager;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public SupportTicket raiseTicket(Long orderId, String issueDescription) {
        Order order = em.find(Order.class, orderId);

        SupportTicket t = new SupportTicket();
        t.setOrder(order);
        t.setIssue(issueDescription);
        t.setStatus("OPEN");

        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

        return t;
    }
}
