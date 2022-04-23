import controller.AccountManager;
import controller.DatabaseManager;
import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ClassGetter;

public class AccountManagerTest {
    @Test
    @DisplayName("getLoggedUserAssertion - Good")
    void getLoggedUserAssertion() {
        AccountManager accountManager = AccountManager.getInstance();
        UserEntity user = accountManager.getLoggedUser("userbun", "45aaasssssssssASDs*-/s");
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("getLoggedUserAssertion - Null")
    void getLoggedUserNullAssertion() {
        AccountManager accountManager = AccountManager.getInstance();
        UserEntity userActual = accountManager.getLoggedUser("UserNonExistent", "45aaasssssssssASDs*-/s");
        UserEntity userExpected = null;
        Assertions.assertEquals(userExpected, userActual);
    }

    @Test
    void SignUpLoginAssertion() {
        AccountManager accountManager = AccountManager.getInstance();
        String user = "TEST_USER";
        String password = "45aaasssssssssASDs*-/s";
        accountManager.createNewAccount(user, password);
        UserEntity userEntity = accountManager.getLoggedUser(user, password);
        Assertions.assertNotNull(userEntity);
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        databaseManager.delete(userEntity);
    }

    @Test
    void SQLiCommentSignUpLoginAssertion() {
        AccountManager accountManager = AccountManager.getInstance();
        String user = "TEST_USER--";
        String password = "45aaasssssssssASDs*-/s";
        accountManager.createNewAccount(user, password);
        UserEntity userEntity = accountManager.getLoggedUser(user, password);
        Assertions.assertEquals(user, userEntity.getUsername());
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        databaseManager.delete(userEntity);
    }

    @Test
    void SQLiCloseStringSignUpLoginAssertion() {
        AccountManager accountManager = AccountManager.getInstance();
        String user = "TEST_USER'";
        String password = "45aaasssssssssASDs*-/s";
        accountManager.createNewAccount(user, password);
        UserEntity userEntity = accountManager.getLoggedUser(user, password);
        Assertions.assertNull(userEntity);
    }

}
