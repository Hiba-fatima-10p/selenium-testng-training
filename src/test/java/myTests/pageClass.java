package myTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pageClass {

    public WebDriver driver;

    public WebDriver setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
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
}