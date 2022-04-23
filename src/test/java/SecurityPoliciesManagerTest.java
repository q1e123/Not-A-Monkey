import controller.InsecurePasswordException;
import controller.SecurityPoliciesManager;
import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ClassGetter;

public class SecurityPoliciesManagerTest {
    @Test
    void weekLengthPasswordAssertion() {
        SecurityPoliciesManager securityPoliciesManager = SecurityPoliciesManager.getInstance();
        Assertions.assertThrows(
            InsecurePasswordException.class, () -> {
                securityPoliciesManager.checkPassword("asd");
            }
        );
    }
    @Test
    void weekNoDigitPasswordAssertion() {
        SecurityPoliciesManager securityPoliciesManager = SecurityPoliciesManager.getInstance();
        Assertions.assertThrows(
                InsecurePasswordException.class, () -> {
                    securityPoliciesManager.checkPassword("aaaaasssssssssASDs*-/s");
                }
        );
    }
    @Test
    void weekNoUppercasePasswordAssertion() {
        SecurityPoliciesManager securityPoliciesManager = SecurityPoliciesManager.getInstance();
        Assertions.assertThrows(
                InsecurePasswordException.class, () -> {
                    securityPoliciesManager.checkPassword("45aaasssssssssasds*-/s");
                }
        );
    }
    @Test
    void weekNoLowercasePasswordAssertion() {
        SecurityPoliciesManager securityPoliciesManager = SecurityPoliciesManager.getInstance();
        Assertions.assertThrows(
                InsecurePasswordException.class, () -> {
                    securityPoliciesManager.checkPassword("45AAAAAAAAAAAAAAAAAAAA*-/s");
                }
        );
    }
    @Test
    void weekNoSymbolsPasswordAssertion() {
        SecurityPoliciesManager securityPoliciesManager = SecurityPoliciesManager.getInstance();
        Assertions.assertThrows(
                InsecurePasswordException.class, () -> {
                    securityPoliciesManager.checkPassword("45AAAAAAAAAAAAAAAAAAAAAAAs");
                }
        );
    }
    @Test
    void goodPasswordAssertion() {
        SecurityPoliciesManager securityPoliciesManager = SecurityPoliciesManager.getInstance();
        Assertions.assertDoesNotThrow(() -> securityPoliciesManager.checkPassword("45aaasssssssssASDs*-/s"));
    }
}
