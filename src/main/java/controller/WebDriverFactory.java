package controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

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
        System.setProperty("webdriver.gecko.driver", path);
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        if (incognito){
            firefoxOptions.addArguments("--incognito");
        }
        if (headless){
            firefoxOptions.addArguments("--headless");
        }
        firefoxOptions.setProfile(profile);
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
