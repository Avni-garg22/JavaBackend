package com.ecommerce;

import java.util.List;

public class EcommerceService {

    private UserDAOImpl userDAO = new UserDAOImpl();
    private OrderDAOImpl orderDAO = new OrderDAOImpl();
    private PaymentDAOImpl paymentDAO = new PaymentDAOImpl();

    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    public void addOrdersToUser(Long userId, List<PurchaseOrder> orders) {
        User user = userDAO.findUser(userId);
        user.setOrders(orders);
        userDAO.updateUser(user);
    }

    public void addPaymentToOrder(Long orderId, Payment payment) {
        PurchaseOrder order = orderDAO.findOrder(orderId);
        payment.setOrder(order);
        paymentDAO.savePayment(payment);
    }

    public User fetchUser(Long id) {
        return userDAO.findUser(id);
    }

    public void updateOrderAmount(Long orderId, double amount) {
        PurchaseOrder order = orderDAO.findOrder(orderId);
        order.setTotalAmount(amount);
        orderDAO.saveOrder(order);
    }

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
