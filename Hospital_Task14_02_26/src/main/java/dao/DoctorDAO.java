package dao;

import entity.Doctor;
import javax.persistence.*;

public class DoctorDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public Doctor saveDoctor(Doctor doctor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Doctor saved = em.merge(doctor);
		em.getTransaction().commit();
		em.close();
		return saved;
	}
}