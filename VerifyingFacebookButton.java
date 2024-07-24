import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyingFacebookButton {
    public static void main(String[] args) {

        /*
        Test Case:

        1. Click on Facebook button

        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']//*[name()='svg']")).click();

        // Wait for new window or tab to open

        String originalWindow = driver.getWindowHandle();
        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(originalWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String expectedURL = "https://www.facebook.com/OrangeHRM/";
        String actualURL= driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("Test Passed: Navigated to Facebook Page");
        }
        else{
            System.out.println("Test Failed: Did not navigated to the Facebook Page");
        }

        driver.switchTo().window(originalWindow);
    }
}
