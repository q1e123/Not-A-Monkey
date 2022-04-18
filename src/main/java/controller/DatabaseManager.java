package controller;

import jakarta.persistence.*;
import model.ActionArgumentEntity;
import model.EntityFlag;
import model.UserEntity;

public class DatabaseManager {
    private static DatabaseManager databaseManager;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private DatabaseManager(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    };

    public static DatabaseManager getInstance() {
        if (DatabaseManager.databaseManager == null){
            DatabaseManager.databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    public void add(EntityFlag entity){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
