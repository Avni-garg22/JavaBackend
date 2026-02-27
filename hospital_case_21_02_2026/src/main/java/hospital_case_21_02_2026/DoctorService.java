package hospital_case_21_02_2026;

import java.util.List;

public class DoctorService {

    private DoctorDAO dao = new DoctorDAO();

    public void create(Doctor d) {
        if (d == null) throw new IllegalArgumentException("Doctor cannot be null");
        dao.save(d);
    }

    public Doctor find(Long id) {
        if (id == null) return null;
        return dao.get(id);
    }

    public List<Doctor> getAll() {
        return dao.getAll();
    }

    public void update(Doctor d) {
        if (d == null) throw new IllegalArgumentException("Doctor cannot be null");
        dao.update(d);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
