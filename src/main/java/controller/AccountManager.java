package controller;

import model.UserEntity;

import java.util.Hashtable;
import java.util.List;

public class AccountManager extends DatabaseEntityManager {
    private static AccountManager accountManager;

    private AccountManager(){
        super();
    }
    public static AccountManager getInstance() {
        if (AccountManager.accountManager == null){
            accountManager = new AccountManager();
        }
        return accountManager;
    }

    public void createNewAccount(String username, String password) throws InsecurePasswordException {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        databaseManager.add(user);
        logger.info("New account creation - " + username);
    }

    public UserEntity getLoggedUser(String username, String password){
        Hashtable<String,String> conditionTable = getLoginConditionTable(username, password);
        List userList = databaseManager.get(conditionTable, UserEntity.class);
        if (userList.size() == 0) {
            logger.info("Login failed - " + username);
            return null;
        }
        UserEntity user = (UserEntity) userList.get(0);
        logger.info("Login successful - " + username);
        return user;
    }

    private Hashtable<String,String> getLoginConditionTable(String username, String password) {
        String hashedPassword = CryptoManager.getSHA256(password);
        Hashtable<String,String> conditionTable = new Hashtable<>();
        conditionTable.put("username", username);
        conditionTable.put("password", hashedPassword);
        return conditionTable;
    }
}
