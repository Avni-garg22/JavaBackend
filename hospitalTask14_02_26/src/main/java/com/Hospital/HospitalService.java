package com.Hospital;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

public class HospitalService {

    private PatientDAO patientDAO = new PatientDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    // 1. Register patient with medical record
    public void registerPatient(EntityManager em) {

        MedicalRecord record = new MedicalRecord();
        record.setId(101);
        record.setBloodGroup("B+");
        record.setAllergies("None");
        em.persist(record); // MANUAL persist

        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Avni");
        patient.setAge(21);
        patient.setContact("9999999999");
        patient.setMedicalRecord(record);

        patientDAO.savePatient(em, patient);
    }

    // 2. Add multiple appointments to doctor
    public void addAppointmentsToDoctor(EntityManager em) {

        Doctor doctor = new Doctor();
        doctor.setId(10);
        doctor.setName("Dr Sharma");
        doctor.setSpecialization("Cardiology");

        Appointment a1 = new Appointment();
        a1.setId(201);
        a1.setVisitDate(LocalDate.now());
        a1.setFee(500);
        em.persist(a1);

        Appointment a2 = new Appointment();
        a2.setId(202);
        a2.setVisitDate(LocalDate.now().plusDays(1));
        a2.setFee(700);
        em.persist(a2);

        doctor.getAppointments().add(a1);
        doctor.getAppointments().add(a2);

        doctorDAO.saveDoctor(em, doctor);
    }

    // 3. Assign appointment to patient
    public void assignAppointmentToPatient(EntityManager em) {

        Appointment appointment = em.find(Appointment.class, 201);
        Patient patient = em.find(Patient.class, 1);

        appointment.setPatient(patient);
    }

    // 4. Update appointment fee
    public void updateAppointmentFee(EntityManager em) {
        appointmentDAO.updateFee(em, 201, 1000);
    }

    // 5. Fetch doctor with appointments
    public List<Appointment> fetchDoctorAppointments(EntityManager em) {
        return appointmentDAO.findAppointmentByDoctor(em, 10);
    }

    // 6. Delete patient
    public void deletePatient(EntityManager em) {
    	  Appointment ap = em.find(Appointment.class, 201);
    	    if (ap != null) {
    	        ap.setPatient(null);
    	    }
        patientDAO.deletePatient(em, 1);
    }
}
