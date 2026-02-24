package Main;


import javax.persistence.*;

import com.BloggingPractice.Comment;
import com.BloggingPractice.Post;
import com.BloggingPractice.Users;

import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Users u1 = new Users();
        u1.setName("Yash");
        u1.setPassword("12Yash34");
        u1.setEmail("yash@gmail.com");

        Post p1 = new Post();
        p1.setTitle("My Life");
        p1.setContent("Learning advance java now-a-days!!");
        p1.setCreatedAt("01-01-2023");
        p1.setUpdatedAt("16-02-2026");
        p1.setAuthor(u1);

        Comment c1 = new Comment();
        c1.setContent("Interesting one!");
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