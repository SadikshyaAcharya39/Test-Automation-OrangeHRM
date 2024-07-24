import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DisplayResetPasswordForm {
    public static void main(String[] args) {

        /*
        Test Case

        1.  Click on Forget Password button

        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Display Login Page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Click on Forgot Password
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        // Reset Password Form should be displayed.
        WebElement ResetPasswordForm = driver.findElement(By.xpath("//h6[normalize-space()='Reset Password']"));
        if(ResetPasswordForm.isDisplayed()){
            System.out.println("Test Passed...");
        }
        else{
            System.out.println("Test Failed...");
        }





    }
}
