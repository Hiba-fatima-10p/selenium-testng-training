package myTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigUtil;

import java.util.Properties;

public class pageClass {

    public WebDriver driver;

    public static Properties myProp;

    static {
        myProp = ConfigUtil.getConfig("/home/hiba/Desktop/myTestProject/src/test/ProjectResources/data.properties");
    }

    public WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        String URL = myProp.getProperty("URL");
        driver.get(URL);
        return driver;
    }

    public String getMessage(String message){
        WebElement messageText = driver.findElement(By.id("user-message"));
        messageText.sendKeys(message);
        WebElement button = driver.findElement(By.className("btn-default"));
        clickElement(button);
        WebElement currentText = driver.findElement(By.id("display"));
        String text = getText(currentText);
        return text;
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String enterInput(WebElement element, String input){
        element.sendKeys(input);
        return input;
    }

}