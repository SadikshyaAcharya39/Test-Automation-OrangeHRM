import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyingLinkedText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.cssSelector("a[href='http://www.orangehrm.com']")).click();

        String originalWindow = driver.getWindowHandle();

        Thread.sleep(1000);
        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(originalWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String expectedURL = "https://www.orangehrm.com/";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("Test Passed: ");
        }
        else{
            System.out.println("Test Failed: ");
        }
        driver.switchTo().window(originalWindow);
    }
}
