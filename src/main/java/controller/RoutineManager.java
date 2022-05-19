package controller;

import model.ActionArgumentEntity;
import model.ActionEntity;
import model.BrowserEntity;
import model.RoutineEntity;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Hashtable;

public class RoutineManager extends DatabaseEntityManager {
    static private RoutineManager routineManager;
    private RoutineManager(){
        super();
    }

    static public RoutineManager getInstance(){
        if (RoutineManager.routineManager == null){
            RoutineManager.routineManager = new RoutineManager();
        }
        return  routineManager;
    }

    public void addRoutine(String name, Integer browserId, Integer userId){
        RoutineEntity routineEntity = new RoutineEntity(name, browserId, userId);
        databaseManager.add(routineEntity);
        logger.info("New routine - " + name);
    }

    public WebDriver getBrowserForRoutine(Integer routineId){
        RoutineEntity routineEntity = databaseManager.get(routineId, RoutineEntity.class);
        BrowserEntity browserEntity = databaseManager.get(routineEntity.getBrowserId(), BrowserEntity.class);
        WebDriver webDriver = WebDriverFactory.getDriver(browserEntity.getDriverPath(), browserEntity.getBrowserType());
        return  webDriver;
    }

    public Hashtable<String, Hashtable<String, String>> getActionsForRoutine(Integer routineId){
        Hashtable<String, Hashtable<String, String>> actionTable = new Hashtable<>();
        ArrayList<ActionEntity> actionEntityList = (ArrayList<ActionEntity>) databaseManager.get("id", routineId, ActionEntity.class);
        for (ActionEntity action: actionEntityList) {
            ArrayList<ActionArgumentEntity> argumentList =  (ArrayList<ActionArgumentEntity>) databaseManager.get("actionId", action.getId(), ActionArgumentEntity.class);
            Hashtable<String, String> argumentTable = new Hashtable<>();
            for (ActionArgumentEntity argumentEntity : argumentList) {
                argumentTable.put(argumentEntity.getType(), argumentEntity.getValue());
            }
            actionTable.put(action.getName(), argumentTable);
        }
        return actionTable;
    }


}
