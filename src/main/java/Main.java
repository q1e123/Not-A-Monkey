import controller.AccountManager;
import controller.DatabaseManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.UserEntity;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        AccountManager accountManager = AccountManager.getInstance();
        //accountManager.createNewAccount("userbun", "45aaasssssssssASDs*-/s");;
        UserEntity user = accountManager.getLoggedUser("userbun", "45aaasssssssssASDs*-/s");
    }
}
