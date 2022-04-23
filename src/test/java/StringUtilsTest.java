import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringUtils;

public class StringUtilsTest {
    @Test
    @DisplayName("removeLastOccurence - Modify")
    void removeLastOccurenceModifyTest() {
        String string = "asd t asd";
        String pattern = "asd";
        String actual = StringUtils.removeLastOccurence(string, pattern);
        String expected = "asd t ";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("removeLastOccurence - Nothing to modify")
    void removeLastOccurenceNoModificationTest() {
        String string = "asd t asd";
        String pattern = "asdz";
        String actual = StringUtils.removeLastOccurence(string, pattern);
        String expected = "asd t asd";
        Assertions.assertEquals(expected, actual);
    }
}
