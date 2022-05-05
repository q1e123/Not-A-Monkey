package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseEntityManager {
    protected DatabaseManager databaseManager = null;
    protected Logger logger = null;
    public DatabaseEntityManager(){
        databaseManager = DatabaseManager.getInstance();
        logger = LogManager.getLogger(DatabaseEntityManager.class);
    }
}
