package hospital_case_21_02_2026;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Simple seeder class that can be run to populate the database with dummy data.
 * Execute this class (it has its own main) or call {@link #seed()} from other
 * code (e.g. tests) to insert departments, doctors, patients, appointments and
 * prescriptions.
 */
public class DataSeeder {

    public static void main(String[] args) {
        System.out.println("Running data seeder...");
        seed();
        HibernateUtil.getFactory().close();
        System.out.println("Seeding complete.");
    }

    public static void seed() {
        DepartmentService deptSvc = new DepartmentService();
        DoctorService docSvc = new DoctorService();
        PatientService patSvc = new PatientService();
        AppointmentService appSvc = new AppointmentService();

        // create departments
        Department cardiology = new Department("Cardiology");
        Department oncology = new Department("Oncology");
        deptSvc.create(cardiology);
        deptSvc.create(oncology);

        // create doctors
        Doctor drJones = new Doctor("Laura Jones");
        Doctor drKim = new Doctor("Michael Kim");
        cardiology.addDoctor(drJones);
        oncology.addDoctor(drKim);
        docSvc.create(drJones);
        docSvc.create(drKim);

        // create patients with medical records
        Patient p1 = new Patient("Alice Brown", LocalDate.of(1990, 3, 22), "A+", "555-0101");
        MedicalRecord m1 = new MedicalRecord(LocalDate.of(2025, 1, 10), "Hypertension", "Needs regular monitoring");
        p1.setMedicalRecord(m1);
        patSvc.create(p1);

        Patient p2 = new Patient("Bob Smith", LocalDate.of(1985, 7, 14), "B-", "555-0202");
        MedicalRecord m2 = new MedicalRecord(LocalDate.of(2025, 2, 5), "Diabetes", "Prescribed insulin");
        p2.setMedicalRecord(m2);
        patSvc.create(p2);

        // relate patients and doctors
        drJones.addPatient(p1);
        drJones.addPatient(p2);
        drKim.addPatient(p2);
        docSvc.update(drJones);
        docSvc.update(drKim);

        // schedule appointments with prescriptions
        Appointment a1 = new Appointment(LocalDateTime.now().plusDays(1), "SCHEDULED");
        a1.setDoctor(drJones);
        a1.setPatient(p1);
        Prescription pres1 = new Prescription("Lisinopril", LocalDate.now());
        a1.setPrescription(pres1);
        drJones.addAppointment(a1);
        p1.addAppointment(a1);
        appSvc.create(a1);

        Appointment a2 = new Appointment(LocalDateTime.now().plusDays(2), "SCHEDULED");
        a2.setDoctor(drKim);
        a2.setPatient(p2);
        Prescription pres2 = new Prescription("Metformin", LocalDate.now());
        a2.setPrescription(pres2);
        drKim.addAppointment(a2);
        p2.addAppointment(a2);
        appSvc.create(a2);

        System.out.println("Inserted " + deptSvc.getAll().size() + " departments, "
                + docSvc.getAll().size() + " doctors, "
                + patSvc.getAll().size() + " patients, "
                + appSvc.getAll().size() + " appointments.");
    }
}
