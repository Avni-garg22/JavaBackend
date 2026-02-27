package hospital_case_21_02_2026;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AppointmentDAO {

    public void save(Appointment a) {
        if (a == null) throw new IllegalArgumentException("Appointment cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();

        // Re-attach doctor and patient to the current session so associations are managed
        if (a.getDoctor() != null && a.getDoctor().getId() != null) {
            Doctor managedDoctor = s.get(Doctor.class, a.getDoctor().getId());
            a.setDoctor(managedDoctor);
            if (managedDoctor != null) {
                // keep in-memory model consistent
                managedDoctor.getAppointments().add(a);
            }
        }

        if (a.getPatient() != null && a.getPatient().getId() != null) {
            Patient managedPatient = s.get(Patient.class, a.getPatient().getId());
            a.setPatient(managedPatient);
            if (managedPatient != null) {
                managedPatient.getAppointments().add(a);
            }
        }

        // If prescription refers to an existing entity, reattach it to this session
        if (a.getPrescription() != null && a.getPrescription().getId() != null) {
            Prescription managedPrescription = s.get(Prescription.class, a.getPrescription().getId());
            a.setPrescription(managedPrescription);
        }

        s.persist(a);
        tx.commit();
        s.close();
    }

    public Appointment get(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Appointment a = s.get(Appointment.class, id);
        s.close();
        return a;
    }

    public List<Appointment> getAll() {
        Session s = HibernateUtil.getFactory().openSession();
        List<Appointment> list = s.createQuery("from Appointment", Appointment.class).list();
        s.close();
        return list;
    }

    public void update(Appointment a) {
        if (a == null) throw new IllegalArgumentException("Appointment cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.merge(a);
        tx.commit();
        s.close();
    }

    public void delete(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Appointment a = s.get(Appointment.class, id);
        if (a != null) s.remove(a);
        tx.commit();
        s.close();
    }
}