import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class VerifyingLinkedInButton {
    public static void main(String[] args) {

        /*
        Test Case
        1. Click on LinkedIn button

        */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']//*[name()='svg']")).click();

        // Wait for the new tab or window to open and switch to it

//        for(String windowHandle: driver.getWindowHandles()){
//            driver.switchTo().window(windowHandle);
//        }

        // Check if the current URL is the LinkedIn page URL

//        // Wait for the new tab or window to open
//
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//        // Assuming only one new window/tab is opened


        String expectedURL = "https://www.linkedin.com/company/orangehrm";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("Test Passed: Successfully navigated to the LinkedIn Page. ");
        }
        else{
            System.out.println("Test Failed: Did not navigate to the expected LinkedIn Page. ");
        }

    }
}
