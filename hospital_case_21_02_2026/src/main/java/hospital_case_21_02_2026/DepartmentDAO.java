package hospital_case_21_02_2026;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class DepartmentDAO {

    public void save(Department d) {
        if (d == null) throw new IllegalArgumentException("Department cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.persist(d);
        tx.commit();
        s.close();
    }

    public Department get(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Department d = s.get(Department.class, id);
        s.close();
        return d;
    }

    public List<Department> getAll() {
        Session s = HibernateUtil.getFactory().openSession();
        List<Department> list = s.createQuery("from Department", Department.class).list();
        s.close();
        return list;
    }

    public void update(Department d) {
        if (d == null) throw new IllegalArgumentException("Department cannot be null");
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.merge(d);
        tx.commit();
        s.close();
    }

    public void delete(Long id) {
        Session s = HibernateUtil.getFactory().openSession();
        Transaction tx = s.beginTransaction();
        Department d = s.get(Department.class, id);
        if (d != null) s.remove(d);
        tx.commit();
        s.close();
    }
}
