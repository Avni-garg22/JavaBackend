package com.ecommerce;

import javax.persistence.*;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ecommerce-unit");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
