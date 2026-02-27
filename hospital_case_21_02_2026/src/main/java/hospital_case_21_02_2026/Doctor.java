package hospital_case_21_02_2026;

import javax.persistence.*;
import java.util.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "patient_doctors",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients = new ArrayList<>();

    public Doctor() {}

    public Doctor(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addPatient(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
            p.addDoctor(this);
        }
    }

    public void removePatient(Patient p) {
        if (patients.remove(p)) {
            p.getDoctors().remove(this);
        }
    }

    // accessors
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public List<Appointment> getAppointments() { return appointments; }
    public List<Patient> getPatients() { return patients; }

    public void addAppointment(Appointment a) {
        if (!appointments.contains(a)) {
            appointments.add(a);
            a.setDoctor(this);
        }
    }

    public void removeAppointment(Appointment a) {
        if (appointments.remove(a)) {
            a.setDoctor(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor other = (Doctor) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
