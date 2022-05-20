package controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public static WebDriver getDriver(String path, String browserType){
        WebDriver driver = null;
        if (browserType.equals("GOOGLE_CHROME")){
            driver = getChrome(false, false, path);
            return driver;
        }
        if (browserType.equals("FIREFOX")){
            driver = getFireFox(false, false, path);
            return driver;
        }
        return null;
    }

    public static WebDriver getFireFox(Boolean incognito, Boolean headless, String path){
        System.setProperty("webdriver.firefox.driver", path);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (incognito){
            firefoxOptions.addArguments("--incognito");
        }
        if (headless){
            firefoxOptions.addArguments("--headless");
        }
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        return driver;
    }

    public static WebDriver getChrome(Boolean incognito, Boolean headless, String path){
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions chromeOptions = new ChromeOptions();
        if (incognito){
            chromeOptions.addArguments("--incognito");
        }
        if (headless){
            chromeOptions.addArguments("--headless");
        }
        WebDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}
