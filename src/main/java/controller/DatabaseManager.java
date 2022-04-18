package controller;

import jakarta.persistence.*;
import model.*;

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

    public void delete(EntityFlag entity){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public ActionArgumentEntity getActionArgumentEntity(Integer id){
        ActionArgumentEntity entity = entityManager.find(ActionArgumentEntity.class, id);
        return entity;
    }
    public ActionEntity getActionEntity(Integer id){
        ActionEntity entity = entityManager.find(ActionEntity.class, id);
        return entity;
    }
    public BrowserEntity getBrowserEntity(Integer id){
        BrowserEntity entity = entityManager.find(BrowserEntity.class, id);
        return entity;
    }
    public RoutineEntity getRoutineEntity(Integer id){
        RoutineEntity entity = entityManager.find(RoutineEntity.class, id);
        return entity;
    }
    public UserEntity getUserEntity(Integer id){
        UserEntity entity = entityManager.find(UserEntity.class, id);
        return entity;
    }
}
