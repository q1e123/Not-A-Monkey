package controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver getDriver(String path, String browserType){
        if (browserType == "GOOGLE_CHROME"){
            WebDriver driver = getChrome(false, false, path);
        }
        return null;
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
