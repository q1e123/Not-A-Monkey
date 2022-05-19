package controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.ActionArgumentEntity;
import model.ActionEntity;
import model.RoutineEntity;

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

    public RoutineEntity addRoutine(String name, Integer browserId, Integer userId){
        RoutineEntity routineEntity = new RoutineEntity(name, browserId, userId);
        databaseManager.add(routineEntity);
        logger.info("New routine - " + name);
        return routineEntity;
    }

    public Hashtable<String, Hashtable<String, String>> getActionsForRoutine(Integer routineId){
        Hashtable<String, Hashtable<String, String>> actionTable = new Hashtable<>();
        EntityManager entityManager = databaseManager.getEntityManager();
        String hql = "FROM ActionEntity a WHERE a.id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", routineId);

        ArrayList<ActionEntity> actionEntityList = (ArrayList<ActionEntity>) query.getResultList();
        for (ActionEntity action: actionEntityList) {
            hql = "";
            query = entityManager.createQuery(hql);
            query.setParameter(":action_id", action.getId());
            ArrayList<ActionArgumentEntity> argumentList =  (ArrayList<ActionArgumentEntity>) query.getResultList();
            Hashtable<String, String> argumentTable = new Hashtable<>();
            for (ActionArgumentEntity argumentEntity : argumentList) {
                argumentTable.put(argumentEntity.getType(), argumentEntity.getValue());
            }
            actionTable.put(action.getName(), argumentTable);
        }
        return actionTable;
    }


}
