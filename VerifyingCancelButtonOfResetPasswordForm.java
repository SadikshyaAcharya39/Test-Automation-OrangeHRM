import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyingCancelButtonOfResetPasswordForm {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        // Click on Forgot Your Password Button
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        // Open Reset Password Form
        driver.findElement(By.xpath("//h6[normalize-space()='Reset Password']"));

        // Click on Cancel Button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel']")).click();

        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("Test Passed... Navigated To Login Page");
        }
        else{
            System.out.println("Test Failed...");
        }
    }
}
