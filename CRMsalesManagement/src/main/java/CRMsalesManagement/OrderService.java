package CRMsalesManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public Order placeOrder(Long customerId, List<Long> productIds) {

        Customer customer = em.find(Customer.class, customerId);
        List<Product> products = new ArrayList<>();

        double total = 0;
        for (Long id : productIds) {
            Product p = em.find(Product.class, id);
            products.add(p);
            total += p.getPrice();
        }

        Order order = new Order();
        order.setOrderDate(LocalDate.now().toString());
        order.setCustomer(customer);
        order.setProducts(products);
        order.setTotalAmount(total);

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

        return order;
    }
}
