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
            if (action.equals("SEND_KEYS")){
                String xpath = argumentTable.get("XPATH");
                String keys = argumentTable.get("KEYS");
                actionList.add(new Runnable() {
                    public void run() { sendKeys(xpath, keys); }
                });
            }
            if (action.equals("CLICK")){
                String xpath = argumentTable.get("XPATH");
                actionList.add(new Runnable() {
                    public void run() { click(xpath); }
                });
            }
            if (action.equals("GET_TEXT")){
                String xpath = argumentTable.get("XPATH");
                actionList.add(new Runnable() {
                    public void run() { getText(xpath); }
                });
            }
            if (action.equals("GET_ATTRIBUTE")){
                String xpath = argumentTable.get("XPATH");
                String attribute = argumentTable.get("ATTRIBUTE");
                actionList.add(new Runnable() {
                    public void run() { getAttribute(xpath, attribute); }
                });
            }
            if (action.equals("IS_SELECTED")){
                String xpath = argumentTable.get("XPATH");
                actionList.add(new Runnable() {
                    public void run() { isSelected(xpath); }
                });
            }
            if (action.equals("CLOSE_BROWSER")){
                actionList.add(new Runnable() {
                    public void run() { closeBrowser(); }
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
