package controller;

public class ActionManager {
    static private ActionManager actionManager;

    private DatabaseManager databaseManager;

    private ActionManager(){
        databaseManager = DatabaseManager.getInstance();
    }
}
