package CRMsalesManagement;

import javax.persistence.EntityManager;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public Customer registerCustomer(String name, String email, String phone) {
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setPhone(phone);

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

        return c;
    }

    public void addAddressToCustomer(Long customerId, Address address) {
        Customer c = em.find(Customer.class, customerId);
        em.getTransaction().begin();
        c.setAddress(address);
        em.getTransaction().commit();
    }
}
