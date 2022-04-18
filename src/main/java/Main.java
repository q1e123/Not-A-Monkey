import controller.DatabaseManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.UserEntity;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        UserEntity user = new UserEntity();
        user.setUsername("test123sec");
        user.setPassword("AA!45aaasssssssssss");
        databaseManager.update(user);
    }
}
