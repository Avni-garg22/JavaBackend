package com.Fintect;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

    static Scanner sc = new Scanner(System.in);
    static CustomerDAO customerDAO = new CustomerDAO();
    static BankAccountDAO accountDAO = new BankAccountDAO();
    static TransactionDAO txnDAO = new TransactionDAO();
    static CardDAO cardDAO = new CardDAO();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Link Account to Customer");
            System.out.println("4. Add Transaction");
            System.out.println("5. Issue Card");
            System.out.println("6. Assign Card to Customer");
            System.out.println("0. Exit");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    customerDAO.save(new Customer(name, email, phone));
                    break;

                case "2":
                    System.out.print("Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Type: ");
                    String type = sc.nextLine();
                    System.out.print("Balance: ");
                    BigDecimal bal = new BigDecimal(sc.nextLine());

                    accountDAO.save(new BankAccount(accNo, type, bal));
                    break;

                case "3":
                    System.out.print("Account ID: ");
                    Long accId = Long.parseLong(sc.nextLine());
                    System.out.print("Customer ID: ");
                    Long custId = Long.parseLong(sc.nextLine());
                    accountDAO.linkToCustomer(accId, custId);
                    break;

                case "4":
                    System.out.print("Account ID: ");
                    Long aId = Long.parseLong(sc.nextLine());
                    System.out.print("Type (CREDIT/DEBIT): ");
                    String t = sc.nextLine();
                    System.out.print("Amount: ");
                    BigDecimal amt = new BigDecimal(sc.nextLine());
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Reference: ");
                    String ref = sc.nextLine();

                    txnDAO.save(new Transaction(t, amt, desc, ref), aId);
                    break;

                case "5":
                    System.out.print("Account ID: ");
                    Long acc = Long.parseLong(sc.nextLine());
                    System.out.print("Card Number: ");
                    String cno = sc.nextLine();
                    System.out.print("Card Type: ");
                    String ctype = sc.nextLine();
                    System.out.print("Network: ");
                    String net = sc.nextLine();
                    System.out.print("Expiry (yyyy-mm-dd): ");
                    LocalDate exp = LocalDate.parse(sc.nextLine());

                    cardDAO.issueCard(new Card(cno, ctype, net, exp), acc);
                    break;

                case "6":
                    System.out.print("Card ID: ");
                    Long cardId = Long.parseLong(sc.nextLine());
                    System.out.print("Customer ID: ");
                    Long cid = Long.parseLong(sc.nextLine());
                    cardDAO.assignCardToCustomer(cardId, cid);
                    break;

                case "0":
                    JPAUtil.close();
                    System.exit(0);
            }
        }
    }
}