package prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTableDriver {

    public static void main(String[] args) {

        // This will automatically create the table
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("postgres"); // use your persistence-unit name

        EntityManager em = emf.createEntityManager();

        System.out.println("Table created successfully (if not exists)!");

        em.close();
        emf.close();
    }
}
