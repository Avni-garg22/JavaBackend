package com.Hospital;

import javax.persistence.EntityManager;

public class PatientDAO {

    public void savePatient(EntityManager em, Patient patient) {
        em.persist(patient);
    }

    public Patient findPatient(EntityManager em, int id) {
        return em.find(Patient.class, id);
    }

    public void updatePatient(EntityManager em, Patient patient) {
        em.merge(patient);
    }

    public void deletePatient(EntityManager em, int id) {
        Patient patient = em.find(Patient.class, id);
        if (patient != null) {
            em.remove(patient);
        }
    }
}
