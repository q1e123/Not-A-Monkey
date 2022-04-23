import controller.CryptoManager;
import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CryptoManagerTest {
    @Test
    void getClassAsStringAssertion() {
        String expected = "688787d8ff144c502c7f5cffaafe2cc588d86079f9de88304c26b0cb99ce91c6";
        String actual = CryptoManager.getSHA256("asd");
        Assertions.assertEquals(expected, actual);
    }
}
