package dao;
import javax.persistence.*;

import student_entity.Student;

import java.util.List;

public class StudentDAO {

    private EntityManager em;

    public StudentDAO(EntityManager em) {
        this.em = em;
    }

    public void saveStudent(Student student) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
    }

    public Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAllStudents() {
        return em.createQuery("FROM Student", Student.class)
                .getResultList();
    }

    public void updateStudent(Student student) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(student);
        tx.commit();
    }

    public void deleteStudent(int id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        tx.commit();
    }

    // Bonus
    public List<Student> findStudentsWithMarksAbove80() {
        return em.createQuery(
                "SELECT s FROM Student s WHERE s.marks > 80",
                Student.class
        ).getResultList();
    }
}