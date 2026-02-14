package com.Hospital;

import java.util.List;

import javax.persistence.EntityManager;



public class AppointmentDAO {

    public void saveAppointment(EntityManager em, Appointment appointment) {
        em.persist(appointment);
    }

    public List<Appointment> findAppointmentByDoctor(EntityManager em, int doctorId) {
        return em.createQuery(
                "SELECT a FROM Doctor d JOIN d.appointments a WHERE d.id = :id",
                Appointment.class)
                .setParameter("id", doctorId)
                .getResultList();
    }

    public void updateFee(EntityManager em, int appointmentId, double fee) {
        Appointment appointment = em.find(Appointment.class, appointmentId);
        appointment.setFee(fee);
    }
}

