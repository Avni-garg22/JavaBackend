package com.Fintect;

import javax.persistence.*;

public class JPAUtil {

	private static final EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("postgres");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		emf.close();
	}
}
