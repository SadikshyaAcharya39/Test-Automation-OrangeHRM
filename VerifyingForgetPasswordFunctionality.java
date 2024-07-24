import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.rmi.MarshalException;
import java.time.Duration;

public class VerifyingForgetPasswordFunctionality {
    public static void main(String[] args) {
        /*
        Test Case
        1.  Enter Correct Username
        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Click on Forgot Your Password Button
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        // Open Reset Password Form
        driver.findElement(By.xpath("//h6[normalize-space()='Reset Password']"));

        // Enter a username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        // Click on Reset Password
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//h6[normalize-space()='Reset Password link sent successfully']"));
        if(successMessage.isDisplayed()){
            System.out.println("Test Passed...");
        }
        else{
            System.out.println("Test Failed...");
        }










    }
}
