package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EasyDriver {
    public WebDriver webDriver;

    public EasyDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goTo(String url){
        webDriver.get(url);
    }

    public void sendKeys(String xPath, CharSequence ... keys){
        WebElement webElement = find(xPath);
        webElement.sendKeys(keys);
    }

    public void click(String xPath){
        WebElement webElement = find(xPath);
        webElement.click();
    }

    public String getText(String xPath){
        WebElement webElement = find(xPath);
        String text = webElement.getText();
        return text;
    }

    private WebElement find(String xPath){
        WebElement webElement = webDriver.findElement(new By.ByXPath(xPath));
        return webElement;
    }

    public String getAttribute(String xPath, String attribute){
        WebElement webElement = find(xPath);
        String attributeValue = webElement.getAttribute(attribute);
        return attributeValue;
    }

    public Boolean isSelected(String xPath){
        WebElement webElement = find((xPath));
        return webElement.isSelected();
    }

    public void closeBrowser(){
        webDriver.close();
    }
}
