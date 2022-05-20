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

    @Test
    void firefoxTest(){
        WebDriver driver = WebDriverFactory.getFireFox(false, false, "C:\\Users\\user\\Downloads\\geckodriver.exe");
        EasyDriver bot = new EasyDriver(driver);
        bot.goTo("http://knightrobert.com/");
        bot.click("//*[@id=\"cs-content\"]/div/div/div/div/div[2]/div/div[2]/a/div/div/span");
        String expected = "Professional";
        String actual = bot.getText("//*[@id=\"post-30\"]/div/div/header/h1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void torTest(){
        WebDriver driver = WebDriverFactory.getTor(false, false, "C:\\Users\\user\\Downloads\\geckodriver.exe");
        EasyDriver bot = new EasyDriver(driver);
        bot.goTo("https://whatismyipaddress.com/");
        String expected = "Romania";
        String actual = bot.getText("//*[@id=\"fl-post-111\"]/div/div/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[4]/div/p[4]/span[2]");
        Assertions.assertNotEquals(expected, actual);
    }
}
