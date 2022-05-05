package controller;

public class EntityManager {
    DatabaseManager databaseManager = null;

    public EntityManager(){
        databaseManager = DatabaseManager.getInstance();
    }
}
