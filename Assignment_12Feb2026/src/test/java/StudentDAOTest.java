
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import dao.StudentDAO;
import student_entity.Student;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentDAOTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private StudentDAO dao;

    @BeforeAll
    void setupFactory() {
        emf = Persistence.createEntityManagerFactory("studentPU");
    }

    @AfterAll
    void closeFactory() {
        if (emf != null) {
            emf.close();
        }
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        dao = new StudentDAO(em);
    }

    @AfterEach
    void close() {
        if (em != null) {
            em.close();
        }
    }

    @Test
    void testSaveStudent() {
        Student s = new Student("Krish", "krish1@gmail.com", 85);
        dao.saveStudent(s);

        assertNotEquals(0, s.getId());
    }

    @Test
    void testFindStudentById() {
        Student s = new Student("Aman", "aman1@gmail.com", 90);
        dao.saveStudent(s);

        Student found = dao.findStudentById(s.getId());

        assertNotNull(found);
        assertEquals("Aman", found.getName());
    }

    @Test
    void testFindAllStudents() {
        dao.saveStudent(new Student("Ravi", "ravi1@gmail.com", 70));

        List<Student> list = dao.findAllStudents();

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    void testUpdateStudent() {
        Student s = new Student("Raj", "raj1@gmail.com", 60);
        dao.saveStudent(s);

        s.setMarks(95);
        dao.updateStudent(s);

        Student updated = dao.findStudentById(s.getId());

        assertEquals(95, updated.getMarks());
    }

    @Test
    void testDeleteStudent() {
        Student s = new Student("Delete", "delete1@gmail.com", 50);
        dao.saveStudent(s);

        dao.deleteStudent(s.getId());

        Student deleted = dao.findStudentById(s.getId());

        assertNull(deleted);
    }

    @Test
    void testStudentCount() {
        dao.saveStudent(new Student("Test1", "test1@gmail.com", 80));
        dao.saveStudent(new Student("Test2", "test2@gmail.com", 75));

        List<Student> list = dao.findAllStudents();

        assertTrue(list.size() >= 2);
    }
}