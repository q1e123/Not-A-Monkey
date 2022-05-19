package controller;

import jakarta.persistence.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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

    public void add(Object entity){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void delete(Object entity){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void update(Object entity){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public <T> T get(Integer id, Class<T> table){
        T entity = (T) entityManager.find(table, id);
        return entity;
    }
    public List execute(Query query){
        List resultList = query.getResultList();
        return resultList;
    }

    public Query getQuery(String hql, Hashtable<String, String> parameterTable){
        Query query = entityManager.createQuery(hql);
        for (Map.Entry<String, String> entry: parameterTable.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
