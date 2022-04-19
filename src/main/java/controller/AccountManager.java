package controller;

import model.UserEntity;

import javax.xml.crypto.Data;

public class AccountManager {
    private static AccountManager accountManager;

    public static AccountManager getInstance() {
        if (AccountManager.accountManager == null){
            accountManager = new AccountManager();
        }
        return accountManager;
    }

    public void createNewAccount(String username, String password){
        UserEntity user = new UserEntity();
        user.setUsername(username);
        try {
            user.setPassword(password);
        } catch (InsecurePasswordException e) {
            e.printStackTrace();
        }
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        databaseManager.add(user);
    }

    public UserEntity getLoggedUser(String username, String password){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        String hashedPassword = SecurityManager.getSHA256(password);
        UserEntity user = databaseManager.getUserEntityLogin(username, hashedPassword);
        return user;
    }
}
