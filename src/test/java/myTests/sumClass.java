package myTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sumClass {
    pageClass page = new pageClass();
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = page.setup();
        driver.manage().window().maximize();
    }

    @Test(description= "testcase from second class", priority = 2)
    public void get_sum(){
        int num1 = Integer.parseInt(page.enterInput(driver.findElement(By.id("sum1")),"7"));
        int num2 = Integer.parseInt(page.enterInput(driver.findElement(By.id("sum2")),"7"));
        page.clickElement(driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")));
        int sum = Integer.parseInt(page.getText(driver.findElement(By.id("displayvalue"))));

        Assert.assertEquals(sum,num1+num2);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
