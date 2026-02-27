package hospital_case_21_02_2026;

import java.time.LocalDate;
import java.util.List;

public class AppointmentService {

    private AppointmentDAO dao = new AppointmentDAO();

    public void create(Appointment a) {
        if (a == null) throw new IllegalArgumentException("Appointment cannot be null");
        // ensure an appointment has a prescription; create one if missing
        if (a.getPrescription() == null) {
            Prescription pres = new Prescription("[auto-generated]", LocalDate.now());
            a.setPrescription(pres);
        }
        dao.save(a);
    }

    public Appointment find(Long id) {
        if (id == null) return null;
        return dao.get(id);
    }

    public List<Appointment> getAll() {
        return dao.getAll();
    }

    public void update(Appointment a) {
        if (a == null) throw new IllegalArgumentException("Appointment cannot be null");
        dao.update(a);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
