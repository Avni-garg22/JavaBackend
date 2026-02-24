package CRMsalesManagement;

import javax.persistence.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    	EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("postgres");
            em = emf.createEntityManager();
            System.out.println("EMF Created Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return; 
        }

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        while (true) {
            System.out.println("\n================ CRM MENU ================");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");
            System.out.println("==========================================");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1: {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    Customer c = customerService.registerCustomer(name, email, phone);
                    System.out.println("Customer registered with ID: " + c.getId());
                    break;
                }

                case 2: {
                    System.out.print("Enter customer ID: ");
                    Long id = sc.nextLong();
                    sc.nextLine();

                    Address address = new Address();
                    System.out.print("Street: ");
                    address.setStreet(sc.nextLine());

                    System.out.print("City: ");
                    address.setCity(sc.nextLine());

                    System.out.print("State: ");
                    address.setState(sc.nextLine());

                    System.out.print("Zip Code: ");
                    address.setZipCode(sc.nextLine());

                    customerService.addAddressToCustomer(id, address);
                    System.out.println("Address added successfully!");
                    break;
                }

                case 3: {
                    System.out.print("Enter lead name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter contact info: ");
                    String contact = sc.nextLine();

                    Lead l = leadService.createLead(name, source, contact);
                    System.out.println("Lead created ID: " + l.getId());
                    break;
                }

                case 4: {
                    System.out.print("Enter lead ID: ");
                    Long leadId = sc.nextLong();

                    System.out.print("Enter employee ID: ");
                    Long empId = sc.nextLong();

                    leadService.assignLeadToEmployee(leadId, empId);
                    System.out.println("Lead assigned to employee!");
                    break;
                }

                case 5: {
                    System.out.print("Enter lead ID: ");
                    Long leadId = sc.nextLong();

                    Customer newCustomer = leadService.convertLeadToCustomer(leadId);
                    System.out.println("Lead converted! New Customer ID: " + newCustomer.getId());
                    break;
                }

                case 6: {
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    Product p = productService.addProduct(name, price);
                    System.out.println("Product added ID: " + p.getId());
                    break;
                }

                case 7: {
                    System.out.print("Enter customer ID: ");
                    Long customerId = sc.nextLong();

                    System.out.print("Enter number of products: ");
                    int count = sc.nextInt();

                    List<Long> pIds = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter product ID: ");
                        pIds.add(sc.nextLong());
                    }

                    Order order = orderService.placeOrder(customerId, pIds);
                    System.out.println("Order placed successfully! Order ID: " + order.getId());
                    break;
                }

                case 8: {
                    System.out.print("Enter order ID: ");
                    Long oid = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter issue description: ");
                    String issue = sc.nextLine();

                    SupportTicket t = ticketService.raiseTicket(oid, issue);
                    System.out.println("Ticket raised! Ticket ID: " + t.getId());
                    break;
                }

                case 9: {
                    System.out.print("Enter employee ID: ");
                    Long empId = sc.nextLong();

                    List<Lead> convertedLeads = reportService.getEmployeePerformance(empId);
                    System.out.println("Converted Leads by Employee:");
                    for (Lead l : convertedLeads) {
                        System.out.println("Lead ID: " + l.getId() + " | Name: " + l.getName());
                    }
                    break;
                }

                case 10:
                    System.out.println("Exiting CRM System...");
                    em.close();
                    emf.close();
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}