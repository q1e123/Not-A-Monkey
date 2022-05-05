package controller;

import model.ActionArgumentEntity;
import model.ActionEntity;

public class ActionManager extends DatabaseEntityManager {
    private static ActionManager actionManager;

    private ActionManager(){
        super();
    }

    public ActionManager getInstance(){
        if (ActionManager.actionManager == null){
            actionManager = new ActionManager();
        }
        return actionManager;
    }
    public void addGoTo(Integer routineId, String url){
        ActionEntity actionEntity = new ActionEntity("GO_TO", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("URL", url, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }

    public void addSendKeys(Integer routineId, String xPath, String keys){
        ActionEntity actionEntity = new ActionEntity("SEND_KEYS", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntityXPath = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        ActionArgumentEntity actionArgumentEntityKeys = new ActionArgumentEntity("KEYS", keys, actionEntity.getId());
        databaseManager.add(actionArgumentEntityXPath);
        databaseManager.add(actionArgumentEntityKeys);
    }

    public void addClick(Integer routineId, String xPath){
        ActionEntity actionEntity = new ActionEntity("CLICK", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }

    public void addGetText(Integer routineId, String xPath){
        ActionEntity actionEntity = new ActionEntity("GET_TEXT", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }

    public void addGetAttribute(Integer routineId, String xPath, String attribute){
        ActionEntity actionEntity = new ActionEntity("GET_ATTRIBUTE", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntityXPath = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        ActionArgumentEntity actionArgumentEntityAttribute = new ActionArgumentEntity("ATTRIBUTE", attribute, actionEntity.getId());
        databaseManager.add(actionArgumentEntityXPath);
        databaseManager.add(actionArgumentEntityAttribute);
    }

    public void addIsSelected(Integer routineId, String xPath) {
        ActionEntity actionEntity = new ActionEntity("IS_SELECTED", routineId);
        databaseManager.add(actionEntity);
        ActionArgumentEntity actionArgumentEntity = new ActionArgumentEntity("XPATH", xPath, actionEntity.getId());
        databaseManager.add(actionArgumentEntity);
    }

    public void addCloseBrowser(Integer routineId) {
        ActionEntity actionEntity = new ActionEntity("CLOSE_BROWSER", routineId);
        databaseManager.add(actionEntity);
    }
}
