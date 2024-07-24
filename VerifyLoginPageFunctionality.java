import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLoginPageFunctionality {
    public static void main(String[] args) {

        /*
        Test Case

        1. Open the browser.
        2. Hit the url.

         */

        // Open the Browser
        WebDriver driver = new ChromeDriver();

        // Hit the URL (https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Close the driver
        driver.close();
    }
}
