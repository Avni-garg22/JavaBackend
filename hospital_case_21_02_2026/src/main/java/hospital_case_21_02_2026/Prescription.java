package hospital_case_21_02_2026;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicines;
    private LocalDate issuedDate;

    public Prescription() {}

    public Prescription(String medicines, LocalDate issuedDate) {
        this.medicines = medicines;
        this.issuedDate = issuedDate;
    }

    public Long getId() { return id; }
    public String getMedicines() { return medicines; }
    public LocalDate getIssuedDate() { return issuedDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescription)) return false;
        Prescription other = (Prescription) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
