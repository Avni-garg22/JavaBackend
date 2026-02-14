package dao;

import entity.Appointment;

import javax.persistence.*;

public class AppointmentDAO {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveAppointment(Appointment appointment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();
    }

    public Appointment findAppointment(int id) {
        EntityManager em = emf.createEntityManager();
        Appointment a = em.find(Appointment.class, id);
        em.close();
        return a;
    }

    public void updateFee(int id, double newFee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Appointment a = em.find(Appointment.class, id);
        a.setFee(newFee);
        em.getTransaction().commit();
        em.close();
    }
}