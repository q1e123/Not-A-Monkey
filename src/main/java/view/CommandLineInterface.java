package view;

import controller.AccountManager;
import controller.ActionDBFactory;
import controller.InsecurePasswordException;
import model.UserEntity;

import java.util.Hashtable;
import java.util.Scanner;

public class CommandLineInterface extends UserInterfaceAbstract{
    private Hashtable<String, Runnable> commandsTable;
    private Scanner scanner;
    private UserEntity currentUser;

    public CommandLineInterface() {
        this.accountManager = AccountManager.getInstance();
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
        System.out.println("Username: ");
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
        System.out.println("Username: ");
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

    }

    @Override
    protected void executeRoutine() {

    }
}
