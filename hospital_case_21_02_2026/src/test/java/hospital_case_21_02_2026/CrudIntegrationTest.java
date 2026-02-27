package hospital_case_21_02_2026;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CrudIntegrationTest {

    private static DepartmentService deptSvc;
    private static DoctorService docSvc;
    private static PatientService patSvc;
    private static AppointmentService appSvc;

    @BeforeAll
    public static void setup() {
        deptSvc = new DepartmentService();
        docSvc = new DoctorService();
        patSvc = new PatientService();
        appSvc = new AppointmentService();
    }

    @AfterAll
    public static void tearDown() {
        HibernateUtil.getFactory().close();
    }

    @Test
    public void fullCrudFlow() {
        // create department
        Department dep = new Department("TestDept");
        deptSvc.create(dep);
        assertNotNull(dep.getId());

        // create doctor and assign
        Doctor doc = new Doctor("Doc1");
        dep.addDoctor(doc);
        docSvc.create(doc);
        assertNotNull(doc.getId());

        // create patient
        Patient pat = new Patient("Pat1", LocalDate.now(), "A+", "12345");
        patSvc.create(pat);
        assertNotNull(pat.getId());

        // relate doctor & patient
        doc.addPatient(pat);
        docSvc.update(doc);
        Doctor loadedDoc = docSvc.find(doc.getId());
        assertTrue(loadedDoc.getPatients().contains(pat));

        // then remove relationship
        loadedDoc.removePatient(pat);
        docSvc.update(loadedDoc);
        assertFalse(docSvc.find(doc.getId()).getPatients().contains(pat));

        // schedule appointment
        Appointment appt = new Appointment(LocalDateTime.now(), "OPEN");
        appt.setDoctor(loadedDoc);
        appt.setPatient(pat);
        pat.addAppointment(appt);
        loadedDoc.addAppointment(appt);
        appSvc.create(appt);
        assertNotNull(appt.getId());

        // update appointment status
        appt.setStatus("COMPLETED");
        appSvc.update(appt);
        assertEquals("COMPLETED", appSvc.find(appt.getId()).getStatus());

        // modify patient
        pat.setPhone("54321");
        patSvc.update(pat);
        assertEquals("54321", patSvc.find(pat.getId()).getPhone());

        // delete doctor and cascade appointments
        docSvc.delete(doc.getId());
        assertNull(docSvc.find(doc.getId()));
        // appointment should have been removed by orphanRemoval
        assertNull(appSvc.find(appt.getId()));

        // cleaning up
        patSvc.delete(pat.getId());
        deptSvc.delete(dep.getId());
    }
}