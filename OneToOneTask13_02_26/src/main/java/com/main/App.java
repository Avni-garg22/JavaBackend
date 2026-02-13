package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entity.AadharCard;
import com.entity.HostelRoom;
import com.entity.Student;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Save AadharCard
        AadharCard aadhar = new AadharCard();
        aadhar.setAadharId(101);
        aadhar.setAadharNumber("1234-5678-9999");
        aadhar.setAddress("Delhi");
        aadhar.setIssueDate("2020");
        em.persist(aadhar);

        // Save HostelRoom
        HostelRoom room = new HostelRoom();
        room.setRoomId(201);
        room.setRoomNumber("H-12");
        room.setBlockName("A");
        room.setFloorNumber(2);
        em.persist(room);

        // Create Student and associate
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Avni");
        student.setEmail("avni@gmail.com");
        student.setBranch("MCA");
        student.setAadharCard(aadhar);
        student.setHostelRoom(room);

        em.persist(student);
        tx.commit();

        // Fetch Student
        Student s = em.find(Student.class, 1);

        s.getStudentId();
        s.getName();
        s.getEmail();
        s.getBranch();

        AadharCard a = s.getAadharCard();
        a.getAadharId();
        a.getAadharNumber();
        a.getAddress();
        a.getIssueDate();

        HostelRoom h = s.getHostelRoom();
        h.getRoomId();
        h.getRoomNumber();
        h.getBlockName();
        h.getFloorNumber();

        System.out.println(s.getName());
        System.out.println(a.getAadharNumber());
        System.out.println(h.getRoomNumber());

        // Delete Student ONLY
        tx.begin();
        em.remove(s);
        tx.commit();

        em.close();
        emf.close();
    }
}
