
package br.edu.ifsc.database.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EntityManagerUtil {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityManagerUtil instance;

    public EntityManagerUtil() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ifsc");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManagerUtil getInstance() {
        if (instance == null) {
            instance = new EntityManagerUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    

}
