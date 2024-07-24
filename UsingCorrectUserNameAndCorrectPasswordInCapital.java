import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsingCorrectUserNameAndCorrectPasswordInCapital {
    public static void main(String[] args) {

       /*

       Test Case
        1. Enter correct username and password
        2. Click on Login Button

        Username: ADMIN
        Password: ADMIN123

       */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ADMIN");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("ADMIN123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

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
