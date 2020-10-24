package myTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testClass {
    pageClass page = new pageClass();
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = page.setup();
        driver.manage().window().maximize();
    }

    @Test(description = "test1", priority = 1)
    public void verify_message(){
        String messagetext = "Selenium Training";
        String text = page.getMessage(messagetext);

        //validation
        //Assert.assertEquals(messagetext,text);
        Assert.assertTrue(messagetext.equals(text));
    }

    @Test(description= "test2", priority = 2)
    public void get_sum(){
        int num1 = Integer.parseInt(page.enterInput(driver.findElement(By.id("sum1")),"5"));
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
