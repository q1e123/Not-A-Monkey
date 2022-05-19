package controller;

import jakarta.persistence.EntityManager;
import model.UserEntity;
import org.hibernate.query.Query;

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
        UserEntity user = new UserEntity(username, password);
        databaseManager.add(user);
        logger.info("New account creation - " + username);
    }

    public UserEntity getLoggedUser(String username, String password){
        Hashtable<String,String> conditionTable = getLoginConditionTable(username, password);
        EntityManager entityManager = databaseManager.getEntityManager();
        String hql = "FROM UserEntity U WHERE U.username=:username AND U.password=:password";
        Query query = (Query) entityManager.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List userList = query.getResultList();
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
