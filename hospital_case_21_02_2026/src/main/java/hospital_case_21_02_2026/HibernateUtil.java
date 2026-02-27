package hospital_case_21_02_2026;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static final SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // debug: list persistence.xml resources on classpath
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.util.Enumeration<java.net.URL> resources = cl.getResources("META-INF/persistence.xml");
            System.out.println("Searching for persistence.xml on classpath...");
            while (resources.hasMoreElements()) {
                java.net.URL url = resources.nextElement();
                System.out.println(" found: " + url);
                try (java.io.InputStream is = url.openStream()) {
                    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
                    if (s.hasNext()) {
                        String content = s.next();
                        System.out.println(" persistence.xml content:\n" + content);
                    }
                } catch (Exception e) {
                    System.err.println(" unable to read resource: " + e);
                }
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
            return emf.unwrap(SessionFactory.class);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
