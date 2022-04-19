import controller.AccountManager;
import controller.DatabaseManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("Application has started");
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        AccountManager accountManager = AccountManager.getInstance();
        UserEntity user = accountManager.getLoggedUser("userbun", "45aaasssssssssASDs*-/s");
        logger.info("Application has ended");
    }
}
