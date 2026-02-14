package com.Hospital;

import javax.persistence.EntityManager;

public class DoctorDAO {

    public void saveDoctor(EntityManager em, Doctor doctor) {
        em.persist(doctor);
    }

    public Doctor findDoctor(EntityManager em, int id) {
        return em.find(Doctor.class, id);
    }
}

