package myTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {
    public static void main(String[] args){
        System.out.print("Hello");
        pageClass page = new pageClass();

        //Pre-req
        WebDriver driver = page.setup();

        //Test steps
        String messagetext = "Selenium Training";
        String text = page.getMessage(messagetext);

        //validation
        if(messagetext.equals(text)){
            System.out.println("It's a match!");
        }else{
            System.out.println("Something went wrong!");
        }

        //close browser
        driver.quit();
    }
}
