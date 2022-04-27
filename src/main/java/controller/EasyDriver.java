package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EasyDriver {
    protected WebDriver webDriver;

    public EasyDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void goTo(String url){
        webDriver.get(url);
    }

    protected void sendKeys(String xPath, CharSequence ... keys){
        WebElement webElement = find(xPath);
        webElement.sendKeys(keys);
    }

    protected void click(String xPath){
        WebElement webElement = find(xPath);
        webElement.click();
    }

    protected String getText(String xPath){
        WebElement webElement = find(xPath);
        String text = webElement.getText();
        return text;
    }

    private WebElement find(String xPath){
        WebElement webElement = webDriver.findElement(new By.ByXPath(xPath));
        return webElement;
    }

    protected String getAttribute(String xPath, String attribute){
        WebElement webElement = find(xPath);
        String attributeValue = webElement.getAttribute(attribute);
        return attributeValue;
    }

    protected Boolean isSelected(String xPath){
        WebElement webElement = find((xPath));
        return webElement.isSelected();
    }

    protected void closeBrowser(){
        webDriver.close();
    }
}
