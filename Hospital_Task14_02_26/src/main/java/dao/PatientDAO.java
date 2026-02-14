package dao;

import entity.Patient;
import javax.persistence.*;

public class PatientDAO {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public Patient savePatient(Patient patient) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Patient saved = em.merge(patient);
		em.getTransaction().commit();
		em.close();
		return saved;
	}

	public Patient findPatient(int id) {
		EntityManager em = emf.createEntityManager();
		Patient p = em.find(Patient.class, id);
		em.close();
		return p;
	}
}