package hospital_case_21_02_2026;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;
    private String bloodGroup;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "med_record_id")
    private MedicalRecord medicalRecord;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    public Patient() {}

    public Patient(String name, LocalDate dob, String bloodGroup, String phone) {
        this.name = name;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDob() { return dob; }
    public String getBloodGroup() { return bloodGroup; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    // relationship helpers
    public List<Doctor> getDoctors() { return doctors; }
    public void addDoctor(Doctor d) {
        if (!doctors.contains(d)) {
            doctors.add(d);
            d.addPatient(this);
        }
    }

    public void removeDoctor(Doctor d) {
        if (doctors.remove(d)) {
            d.getPatients().remove(this);
        }
    }

    public List<Appointment> getAppointments() { return appointments; }
    public void addAppointment(Appointment a) {
        if (!appointments.contains(a)) {
            appointments.add(a);
            a.setPatient(this);
        }
    }

    public void removeAppointment(Appointment a) {
        if (appointments.remove(a)) {
            a.setPatient(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient other = (Patient) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}