import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsingCorrectUserNameAndPasswordInSmallLetter {
    public static void main(String[] args) {

        /*

        Test Case

        1. Enter correct username and password
        2. Click on Login Button

        Username: admin
        Password: admin123

        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
//        String errorText = errorMessage.getText().trim();
//
//        if(errorText.equals("Invalid credentials")){
//            System.out.println("Test Passed");
//        }
//        else{
//            System.out.println("Test Failed");
//        }

        // Wait for the dashboard or some element on the next page to ensure successful login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement dashboard = wait.until(
                    d -> d.findElement(By.xpath("//div[@class='oxd-topbar-header-title']"))
            );

            if(dashboard.isDisplayed()) {
                System.out.println("Test Failed");
            } else {
                System.out.println("Test Passed");
            }
        } catch (Exception e) {
            System.out.println("Test Passed");
        } finally {
            driver.quit();
        }
    }
}
