package task_2_14_02_2026;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import com.ecommerce.EcommerceService;
import com.ecommerce.Payment;
import com.ecommerce.Profile;
import com.ecommerce.PurchaseOrder;
import com.ecommerce.User;

public class EcommerceTest {

    EcommerceService service = new EcommerceService();

    @Test
    public void fullWorkflowTest() {

        Profile profile = new Profile();
        profile.setPhone("9999999999");
        profile.setAddress("Delhi");

        User user = new User();
        user.setName("Krish");
        user.setEmail("krish@gmail.com");
        user.setProfile(profile);

        service.registerUser(user);

        PurchaseOrder o1 = new PurchaseOrder();
        o1.setOrderDate(LocalDate.now());
        o1.setTotalAmount(5000);

        PurchaseOrder o2 = new PurchaseOrder();
        o2.setOrderDate(LocalDate.now());
        o2.setTotalAmount(3000);

        service.addOrdersToUser(user.getId(), Arrays.asList(o1, o2));

        User fetched = service.fetchUser(user.getId());
        assertEquals(2, fetched.getOrders().size());

        Payment payment = new Payment();
        payment.setMode("UPI");
        payment.setAmount(5000);

        service.addPaymentToOrder(o1.getId(), payment);

        service.updateOrderAmount(o1.getId(), 7000);

        service.deleteUser(user.getId());
    }
}
