package controller;

import model.RoutineEntity;

public class RoutineManager extends EntityManager{
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

    public void addVRoutine(String name, Integer browserId, Integer userId){
        RoutineEntity routineEntity = new RoutineEntity(name, browserId, userId);
        databaseManager.add(routineEntity);
    }
}
