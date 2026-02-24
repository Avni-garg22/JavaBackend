package CRMsalesManagement;

import javax.persistence.EntityManager;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public Product addProduct(String name, double price) {
        Product p = new Product();
        p.setProductName(name);
        p.setPrice(price);

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        return p;
    }
}