package hospital_case_21_02_2026;

import java.time.LocalDate;
import java.util.List;

public class PatientService {

    private PatientDAO dao = new PatientDAO();

    public void create(Patient p) {
        if (p == null) throw new IllegalArgumentException("Patient cannot be null");
        // ensure every patient has a medical record; create a default one if missing
        if (p.getMedicalRecord() == null) {
            MedicalRecord mr = new MedicalRecord(LocalDate.now(), "Initial record", "");
            p.setMedicalRecord(mr);
        }
        dao.save(p);
    }

    public Patient find(Long id) {
        if (id == null) return null;
        return dao.get(id);
    }

    public List<Patient> getAll() {
        return dao.getAll();
    }

    public void update(Patient p) {
        if (p == null) throw new IllegalArgumentException("Patient cannot be null");
        dao.update(p);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}