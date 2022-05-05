import controller.AccountManager;
import controller.DatabaseManager;
import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ClassGetter;

public class DatabaseManagerTest {
    @Test
    @DisplayName("get - Good")
    void getAssertion() {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        UserEntity user = databaseManager.get(2, UserEntity.class);
        Assertions.assertNotNull(user);
    }
    @Test
    @DisplayName("get - Null")
    void getNullAssertion() {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        UserEntity user = databaseManager.get(-1, UserEntity.class);
        Assertions.assertNull(user);
    }

    @Test
    @DisplayName("get - Not a table")
    void getNoTableAssertion() {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    ClassGetter classGetter = databaseManager.get(-1, ClassGetter.class);
                }
        );
    }
    @Test
    void updateAssertion() {
        AccountManager accountManager = AccountManager.getInstance();
        String user = "TEST_USER";
        String password = "45aaasssssssssASDs*-/s";
        accountManager.createNewAccount(user, password);
        UserEntity userEntity = accountManager.getLoggedUser(user, password);
        userEntity.setUsername("NEW_USERNAME");
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        databaseManager.update(userEntity);
        UserEntity updated = databaseManager.get(userEntity.getId(), UserEntity.class);
        Assertions.assertEquals("NEW_USERNAME", updated.getUsername());

    }
}
