import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyLoginUsingIncorrectUsernameAndCorrectPassword {
    public static void main(String[] args) {
        /*
        Test Cases

      1. Enter incorrect username and correct password
      2. Click on Login Button

        */

        // Launch the Browser
        WebDriver driver = new ChromeDriver();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Hit the URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Enter incorrect username and correct password
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin1");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin123");


        // Click on Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Error Message
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class= 'oxd-text oxd-text--p oxd-alert-content-text']"));
        String errorText = errorMessage.getText().trim();


        if(errorText.equals("Invalid credentials")){
            System.out.println("Test Passed...");
        }
        else{
            System.out.println("Test Failed...");
        }

        System.out.println("Error Message: " + errorText);


    }
}
