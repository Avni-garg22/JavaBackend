package hospital_case_21_02_2026;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class DoctorDAO {

    public void save(Doctor d) {
        if (d == null) throw new IllegalArgumentException("Doctor cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.persist(d);
        tx.commit();
        s.close();
    }

    public Doctor get(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Doctor d = s.get(Doctor.class, id);
        s.close();
        return d;
    }

    public List<Doctor> getAll() {
        Session s = HibernateUtil.getFactory().openSession();
        List<Doctor> list = s.createQuery("from Doctor", Doctor.class).list();
        s.close();
        return list;
    }

    public void update(Doctor d) {
        if (d == null) throw new IllegalArgumentException("Doctor cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.merge(d);
        tx.commit();
        s.close();
    }

    public void delete(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Doctor d = s.get(Doctor.class, id);
        if (d != null) s.remove(d);
        tx.commit();
        s.close();
    }
}
