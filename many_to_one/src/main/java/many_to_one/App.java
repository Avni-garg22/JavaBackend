package many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Department e=em.find(Department.class, 11);
    	System.out.println(e);

//        et.begin();
//
//        Department dept = new Department();
    //    dept.setId(11);
//        dept.setName("IT");
//        dept.setMgrname("Mr Sharma");
//        dept.setTotemp(12);
//
//        Employee e1 = new Employee();
//        e1.setId(111);
//        e1.setName("Avni");
//        e1.setSal(50000);
//        e1.setDesg("Developer");
//        e1.setDepartment(dept);
//
//        Employee e2 = new Employee();
//        e2.setId(112);
//        e2.setName("Shubhi");
//        e2.setSal(60000);
//        e2.setDesg("Tester");
//        e2.setDepartment(dept);
//
//        em.persist(dept);
//        em.persist(e1);
//        em.persist(e2);
//
//        et.commit();
//
//        em.close();
//        emf.close();
//
//        System.out.println("Data Inserted Successfully");
        
    }
}
