package Hospital;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.Hospital.Appointment;
import com.Hospital.HospitalService;
import com.Hospital.Patient;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;



@TestMethodOrder(OrderAnnotation.class)
public class HospitalTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;

    private static HospitalService service;

    @BeforeAll
    static void setUp() {
        emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        service = new HospitalService();
    }

    // OneToOne persist test
    @Test
    @Order(1)
    void oneToOnePersistTest() {
        tx.begin();
        service.registerPatient(em);
        tx.commit();

        Patient patient = em.find(Patient.class, 1);
        assertNotNull(patient);
        assertNotNull(patient.getMedicalRecord());
    }

    // OneToMany persist test
    @Test
    @Order(2)
    void oneToManyPersistTest() {
        tx.begin();
        service.addAppointmentsToDoctor(em);
        tx.commit();

        List<Appointment> list = service.fetchDoctorAppointments(em);
        assertEquals(2, list.size());
    }

    // ManyToOne persist test
    @Test
    @Order(3)
    void manyToOnePersistTest() {
        tx.begin();
        service.assignAppointmentToPatient(em);
        tx.commit();

        Appointment ap = em.find(Appointment.class, 201);
        assertNotNull(ap.getPatient());
    }

    // DAO update test
    @Test
    @Order(4)
    void daoUpdateTest() {
        tx.begin();
        service.updateAppointmentFee(em);
        tx.commit();

        Appointment ap = em.find(Appointment.class, 201);
        assertEquals(1000, ap.getFee());
    }

    // DAO delete test
    @Test
    @Order(5)
    void daoDeleteTest() {
        tx.begin();
        service.deletePatient(em);
        tx.commit();

        Patient p = em.find(Patient.class, 1);
        assertNull(p);
    }


    @AfterAll
    static void tearDown() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }
}