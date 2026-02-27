package hospital_case_21_02_2026;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PatientDAO {

    public void save(Patient p) {
        if (p == null) throw new IllegalArgumentException("Patient cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.persist(p);
        tx.commit();
        s.close();
    }

    public Patient get(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Patient p = s.get(Patient.class, id);
        s.close();
        return p;
    }

    public List<Patient> getAll() {
        Session s = HibernateUtil.getFactory().openSession();
        List<Patient> list = s.createQuery("from Patient", Patient.class).list();
        s.close();
        return list;
    }

    public void update(Patient p) {
        if (p == null) throw new IllegalArgumentException("Patient cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.merge(p);
        tx.commit();
        s.close();
    }

    public void delete(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Patient p = s.get(Patient.class, id);
        if (p != null) s.remove(p);
        tx.commit();
        s.close();
    }

	
}
