package view;

import controller.AccountManager;
import controller.ActionManager;
import controller.BrowserManager;
import controller.InsecurePasswordException;
import model.UserEntity;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class CommandLineInterface extends UserInterfaceAbstract{
    private Hashtable<String, Runnable> commandsTable;
    private Scanner scanner;
    private UserEntity currentUser;

    public CommandLineInterface() {
        this.accountManager = AccountManager.getInstance();
        this.browserManager = BrowserManager.getInstance();
        this.actionManager = ActionManager.getInstance();
        this.scanner = new Scanner(System.in);
        buildCommandsTable();
    }

    @Override
    public void run() {
        while (true){
            String command = scanner.next();
            if (this.commandsTable.containsKey(command)) {
                Runnable function = commandsTable.get(command);
                function.run();
            } else {
                System.out.println("Command not found");
            }
        }
    }

    private void buildCommandsTable(){
        commandsTable = new Hashtable<>();
        commandsTable.put("signup", new Runnable() {
            public void run() { createNewAccount(); }
        });
        commandsTable.put("login", new Runnable() {
            public void run() { login(); }
        });
        commandsTable.put("whoami", new Runnable() {
            public void run() { whoami(); }
        });
    }

    private void whoami(){
        System.out.println("You are: " + currentUser.getUsername());
    }

    @Override
    protected void createNewAccount() {
        System.out.println("*** Create new account ***");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        try {
            this.accountManager.createNewAccount(username, password);
        } catch (InsecurePasswordException e) {
            System.out.println(e.getMessage());
        }
        currentUser = accountManager.getLoggedUser(username, password);
    }

    @Override
    protected void login() {
        System.out.println("*** Login ***");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        currentUser = accountManager.getLoggedUser(username, password);
        if (currentUser == null){
            System.out.println("Try again");
        }
    }

    @Override
    protected void addRoutine() {

    }

    @Override
    protected void addBrowser() {
        if (isUserLogged()) {
            System.out.println("*** Add Browser ***");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Driver path: ");
            String driverPath = scanner.next();
            System.out.println("Browser type: ");
            System.out.println("1. Google Chrome");
            String browserType = getBrowserType();
            browserManager.addBrowser(name, driverPath, browserType);
        } else {
            System.out.println("You must be logged to perform this action");
        }
    }

    private String getBrowserType(){
        ArrayList<String> supportedBrowserList = browserManager.getSupportedBrowserList();
        Integer selectedBrowser = null;
        while (selectedBrowser < 0 && selectedBrowser >= supportedBrowserList.size()){
            System.out.println("Select a browser:");
            for (int i = 0; i < supportedBrowserList.size(); ++i){
                System.out.println(i + ". " + supportedBrowserList.get(i));
            }
            selectedBrowser = scanner.nextInt();
        }
        return supportedBrowserList.get(selectedBrowser);
    }
    @Override
    protected void executeRoutine() {

    }

    private boolean isUserLogged(){
        return this.currentUser != null;
    }

}
