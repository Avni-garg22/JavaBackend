package com.prac;

import java.util.List;
import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDao dao = new ProductDao();

        while (true) {
            System.out.println("\n===== PRODUCT MANAGEMENT =====");
            System.out.println("1. Insert Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Product");
            System.out.println("4. Find Product by ID");
            System.out.println("5. Find All Products");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

            case 1:
                Product p1 = new Product();
                System.out.print("Enter Id: ");
                p1.setId(sc.nextInt());
                System.out.print("Enter Name: ");
                p1.setName(sc.next());
                System.out.print("Enter Quantity: ");
                p1.setQuantity(sc.nextInt());
                System.out.print("Enter Price: ");
                p1.setPrice(sc.nextInt());
                dao.insertProduct(p1);
                break;

            case 2:
                System.out.print("Enter Product ID to Delete: ");
                int delId = sc.nextInt();
                dao.deleteProduct(delId);
                break;

            case 3:
                Product p2 = new Product();
                System.out.print("Enter ID (existing): ");
                p2.setId(sc.nextInt());
                System.out.print("Enter New Name: ");
                p2.setName(sc.next());
                System.out.print("Enter New Quantity: ");
                p2.setQuantity(sc.nextInt());
                System.out.print("Enter New Price: ");
                p2.setPrice(sc.nextInt());
                dao.updateProduct(p2);
                break;

            case 4:
                System.out.print("Enter Product ID: ");
                Product p = dao.findProduct(sc.nextInt());
                if (p != null)
                    System.out.println(p);
                else
                    System.out.println("Product not found.");
                break;

            case 5:
                List<Product> list = dao.findAllProducts();
                list.forEach(System.out::println);
                break;

            case 6:
                System.out.println("Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice!");
            }
        }
    }
}
