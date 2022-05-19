package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Bot extends EasyDriver{
    private Hashtable<String, Hashtable<String, String>> actionTable;
    private ArrayList<Runnable> actionList;

    private Logger logger;

    public Bot(WebDriver webDriver, Hashtable<String, Hashtable<String, String>> actionTable) {
        super(webDriver);
        actionList = new ArrayList<>();
        logger = LogManager.getLogger(Bot.class);
        this.actionTable = actionTable;
        buildActionList();
    }

    private void buildActionList(){
        for (String action : actionTable.keySet()) {
            Hashtable<String, String> argumentTable = actionTable.get(action);
            if (action.equals("GO_TO")){
                String url = argumentTable.get("URL");
                actionList.add(new Runnable() {
                    public void run() { goTo(url); }
                });
            }
        }
    }
    public void start(){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(this::run);
        logger.info("A routine thread has strated");
    }

    private void run(){
        logger.info("A routine has started");
        for (Runnable action : actionList) {
            action.run();
        }

    }
}
