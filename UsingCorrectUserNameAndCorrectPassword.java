import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsingCorrectUserNameAndCorrectPassword {
    public static void main(String[] args) {

        /*
        Test Case:

        1. Enter correct username and password
        2. Click on Login Button

        Username = Admin
        Password = admin123

        */

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement dashboard = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']"));
        if(dashboard.isDisplayed()){
            System.out.println("Test Passed...");
        }
        else {
            System.out.println("Test Failed...");
        }
    }
}
