package controller;

public class ActionManager extends DatabaseEntityManager {
    static private ActionManager actionManager;
    private ActionManager(){
        super();
    }

    static public ActionManager getInstance(){
        if (ActionManager.actionManager == null){
            actionManager = new ActionManager();
        }
        return actionManager;
    }
}
