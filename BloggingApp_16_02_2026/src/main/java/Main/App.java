package Main;


import javax.persistence.*;

import com.BloggingApp.Comment;
import com.BloggingApp.Post;
import com.BloggingApp.Users;

import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Users u1 = new Users();
        u1.setName("Avni");
        u1.setPassword("123avni");
        u1.setEmail("avi123@gmail.com");

        Post p1 = new Post();
        p1.setTitle("Java Learn");
        p1.setContent("Advance java is Interesting!!");
        p1.setCreatedAt("22-11-2025");
        p1.setUpdatedAt("16-02-2026");
        p1.setAuthor(u1);

        Comment c1 = new Comment();
        c1.setContent("great-post!");
        c1.setCreatedAt("16-02-2026");
        c1.setPost(p1);
        c1.setAuthor(u1);

        et.begin();
        em.persist(u1);
        em.persist(p1);
        em.persist(c1);
        et.commit();

        em.close();
        emf.close();
        
    }
}