import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class VerifyLoginWithoutEnteringUserNameAndPassword {
    public static void main(String[] args) {

        /*
        Test Case

        1. Login without entering username and password
        2. Click on Login Button

        */

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Implicit Wait

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("");

        // Locate and Click the Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        WebElement errorMessageUserName = driver.findElement(By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]"));
        WebElement errorMessagePassword = driver.findElement(By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]"));

        // Get the text of the error message

        String errorTextUserName = errorMessageUserName.getText().trim();
        String errorTextPassword = errorMessagePassword.getText().trim();

        // Verify Error Message

        if(errorTextUserName.equals("Required") && errorTextPassword.equals("Required")){
            System.out.println("Test Passed...");
        }
        else{
            System.out.println("Test Failed...");
        }
    }
}
