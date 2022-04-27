package controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver getChrome(Boolean incognito, Boolean headless){
        System.setProperty("webdriver.chrome.driver", "D:/Workshop/Utils/chromedriver-88.exe");
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
