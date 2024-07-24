import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyLoginUsingCorrectUsernameAndIncorrectPassword {
    public static void main(String[] args) {

        /*
        Test Cases

        1. Enter incorrect username and incorrect password
        2. Click on Login Button

         */

        WebDriver driver = new ChromeDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder= 'Password']")).sendKeys("Admin");

        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String errorText = errorMessage.getText().trim();

        if(errorText.equals("Invalid credentials")){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }


    }
}
