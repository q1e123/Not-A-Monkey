package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityManager {
    protected DatabaseManager databaseManager = null;
    protected Logger logger = null;
    public EntityManager(){
        databaseManager = DatabaseManager.getInstance();
        logger = LogManager.getLogger(EntityManager.class);
    }
}
