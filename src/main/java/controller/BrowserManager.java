package controller;

import model.BrowserEntity;

import java.util.ArrayList;
import java.util.Hashtable;

public class BrowserManager {
    private ArrayList<String> supportedBrowserList;
    private DatabaseManager databaseManager;

    private static BrowserManager browserManager;
    private BrowserManager(){
        databaseManager = DatabaseManager.getInstance();
        buildSupportedBrowserList();
    }

    private void buildSupportedBrowserList(){
        this.supportedBrowserList = new ArrayList<>();
        supportedBrowserList.add("GOOGLE_CHROME");
    }

    static public BrowserManager getInstance(){
        if (BrowserManager.browserManager == null){
            browserManager = new BrowserManager();
        }
        return  browserManager;
    }

    public ArrayList<String> getSupportedBrowserList() {
        return supportedBrowserList;
    }

    public void addBrowser(String name, String driverPath, String browserType){
        BrowserEntity browserEntity = new BrowserEntity(name, driverPath, browserType);
        databaseManager.add(browserEntity);
    }
}
