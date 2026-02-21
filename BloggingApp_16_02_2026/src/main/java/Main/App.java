package Main;


import javax.persistence.*;

import com.BloggingApp.Comment;
import com.BloggingApp.Post;
import com.BloggingApp.User;

import java.util.List;
import java.util.Scanner;

public class App {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== BLOG MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Create Post");
            System.out.println("3. Add Comment");
            System.out.println("4. View All Posts");
            System.out.println("5. View Comments of Post");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    registerUser(sc);
                    break;
                case 2:
                    createPost(sc);
                    break;
                case 3:
                    addComment(sc);
                    break;
                case 4:
                    viewPosts();
                    break;
                case 5:
                    viewComments(sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        em.close();
        emf.close();
    }

    

    private static void registerUser(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = new User(name, password, email);

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        System.out.println("Registered Successfully!");
    }

    private static void createPost(Scanner sc) {
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        User user = em.find(User.class, userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter content: ");
        String content = sc.nextLine();

        Post post = new Post(title, content, user);

        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();

        System.out.println("Post Created!");
    }

    private static void addComment(Scanner sc) {
        System.out.print("Enter Post ID: ");
        int postId = sc.nextInt();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        Post post = em.find(Post.class, postId);
        User user = em.find(User.class, userId);

        if (post == null || user == null) {
            System.out.println("Invalid Post or User!");
            return;
        }

        System.out.print("Enter comment: ");
        String content = sc.nextLine();

        Comment comment = new Comment(content, post, user);

        em.getTransaction().begin();
        em.persist(comment);
        em.getTransaction().commit();

        System.out.println("Comment Added!");
    }

    private static void viewPosts() {
        List<Post> posts = em.createQuery("from Post", Post.class)
                             .getResultList();

        for (Post p : posts) {
            System.out.println("\nPost ID: " + p.getId());
            System.out.println("Title: " + p.getTitle());
        }
    }

    private static void viewComments(Scanner sc) {
        System.out.print("Enter Post ID: ");
        int postId = sc.nextInt();

        List<Comment> comments = em.createQuery(
                "from Comment where post.id = :pid", Comment.class)
                .setParameter("pid", postId)
                .getResultList();

        for (Comment c : comments) {
            System.out.println("Comment: " + c.getContent());
        }
    }
}
