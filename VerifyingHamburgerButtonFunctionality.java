import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyingHamburgerButtonFunctionality {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Dashboard Page
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");


//      driver.findElement(By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();
        WebElement sidePanel = driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']"));

        if(sidePanel.isDisplayed()){
            System.out.println("Test Passed... Side Panel is displayed.");
        }else{
            System.out.println("Test Failed... Side Panel is not displayed.");
        }
    }
}
