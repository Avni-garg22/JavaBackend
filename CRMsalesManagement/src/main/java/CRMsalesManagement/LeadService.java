package CRMsalesManagement;

import javax.persistence.EntityManager;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    public Lead createLead(String name, String source, String contactInfo) {
        Lead l = new Lead();
        l.setName(name);
        l.setSource(source);
        l.setContactInfo(contactInfo);
        l.setStatus("NEW");

        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();

        return l;
    }

    public void assignLeadToEmployee(Long leadId, Long employeeId) {
        Lead lead = em.find(Lead.class, leadId);
        SalesEmployee emp = em.find(SalesEmployee.class, employeeId);

        em.getTransaction().begin();
        lead.setEmployee(emp);
        em.getTransaction().commit();
    }

    public Customer convertLeadToCustomer(Long leadId) {
        Lead lead = em.find(Lead.class, leadId);

        Customer customer = new Customer();
        customer.setName(lead.getName());
        customer.setEmail(lead.getContactInfo());

        em.getTransaction().begin();
        em.persist(customer);
        lead.setCustomer(customer);
        lead.setStatus("CONVERTED");
        em.getTransaction().commit();

        return customer;
    }
}