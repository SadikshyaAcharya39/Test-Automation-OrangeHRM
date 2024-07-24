import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyingDashboardPage {
    public static void main(String[] args) {

        /*
        Test Case

        1.  Enter correct username and correct password in Login Form

        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        // Click on Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String actualURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String expectedURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("Test Passed...");
        }else{
            System.out.println("Test Failed...");
        }
    }
}
