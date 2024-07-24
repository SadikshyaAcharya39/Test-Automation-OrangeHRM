import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyLoginUsingIncorrectUsernameAndIncorrectPassword {
    public static void main(String[] args) {
        /*

        Test Cases
        1. Open the browser.
        2. Hit the url.
(https://opensource-demo.orangehrmlive.com/web/index.php/auth/login )

         3. Enter incorrect username and incorrect password

         Test Data:
         Username: Sadikshya
         Password: Sadikshya

         */

        WebDriver driver = new ChromeDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // To maximize the window
//        driver.manage().window().maximize();

        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));

        usernameField.sendKeys("Sadikshya");
        passwordField.sendKeys("Sadikshya");

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
        String errorText = errorMessage.getText().trim();

        if(errorText.equals("Invalid credentials")){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

        System.out.println("Error Message Text: " + errorText);

    }
}
