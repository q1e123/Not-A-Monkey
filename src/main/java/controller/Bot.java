package controller;

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

    public Bot(WebDriver webDriver, Hashtable<String, Hashtable<String, String>> actionTable) {
        super(webDriver);
        actionList = new ArrayList<>();
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
        executor.execute(this::start);
    }

    private void run(){
        for (Runnable action : actionList) {
            action.run();
        }
    }
}
