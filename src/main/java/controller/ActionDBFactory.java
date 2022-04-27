package controller;

import model.ActionArgumentEntity;
import model.ActionEntity;

public class ActionDBFactory {
    public static void addGoTo(Integer routineId, String url){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        ActionEntity actionEntity = new ActionEntity("GoTo", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("URL", url, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }
}
