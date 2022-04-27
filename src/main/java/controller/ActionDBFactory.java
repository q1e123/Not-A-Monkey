package controller;

import model.ActionArgumentEntity;
import model.ActionEntity;

public class ActionDBFactory {
    public static void addGoTo(Integer routineId, String url){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ActionEntity actionEntity = new ActionEntity("GO_TO", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("URL", url, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }

    public static void addSendKeys(Integer routineId, String xPath, String keys){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ActionEntity actionEntity = new ActionEntity("SEND_KEYS", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntityXPath = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        ActionArgumentEntity actionArgumentEntityKeys = new ActionArgumentEntity("KEYS", keys, actionEntity.getId());
        databaseManager.add(actionArgumentEntityXPath);
        databaseManager.add(actionArgumentEntityKeys);
    }

    public static void addClick(Integer routineId, String xPath){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ActionEntity actionEntity = new ActionEntity("CLICK", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }

    public static void addGetText(Integer routineId, String xPath){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ActionEntity actionEntity = new ActionEntity("GET_TEXT", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }

    public static void addGetAttribute(Integer routineId, String xPath, String attribute){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ActionEntity actionEntity = new ActionEntity("GET_ATTRIBUTE", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntityXPath = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        ActionArgumentEntity actionArgumentEntityAttribute = new ActionArgumentEntity("ATTRIBUTE", attribute, actionEntity.getId());
        databaseManager.add(actionArgumentEntityXPath);
        databaseManager.add(actionArgumentEntityAttribute);
    }

}
