import controller.EasyDriver;
import controller.QueryBuilder;
import controller.WebDriverFactory;
import model.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Hashtable;

public class EasyDriverTest {
    @Test
    void gotoClickGetTest() {
        WebDriver driver = WebDriverFactory.getChrome(false, false, "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        EasyDriver bot = new EasyDriver(driver);
        bot.goTo("http://knightrobert.com/");
        bot.click("//*[@id=\"cs-content\"]/div/div/div/div/div[2]/div/div[2]/a/div/div/span");
        String expected = "Professional";
        String actual = bot.getText("//*[@id=\"post-30\"]/div/div/header/h1");
        Assertions.assertEquals(expected, actual);
    }

}
