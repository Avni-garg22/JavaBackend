package hospital_case_21_02_2026;

import java.util.List;

public class DepartmentService {

    private DepartmentDAO dao = new DepartmentDAO();

    public void create(Department d) {
        if (d == null) throw new IllegalArgumentException("Department cannot be null");
        dao.save(d);
    }

    public Department find(Long id) {
        if (id == null) return null;
        return dao.get(id);
    }

    public List<Department> getAll() {
        return dao.getAll();
    }

    public void update(Department d) {
        if (d == null) throw new IllegalArgumentException("Department cannot be null");
        dao.update(d);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
