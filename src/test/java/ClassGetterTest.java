import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ClassGetter;

public class ClassGetterTest {
    @Test
    @DisplayName("getClassAsString")
    void getClassAsStringAssertion() {
        String expected = "UserEntity";
        String actual = ClassGetter.getClassAsString(UserEntity.class);
        Assertions.assertEquals(expected, actual);
    }
}
