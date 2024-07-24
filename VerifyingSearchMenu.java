import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyingSearchMenu {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement sidePanel = driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']"));
        if(sidePanel.isDisplayed()){
            System.out.println("Test Passed... Side Panel is displayed.");
        }
        else {
            System.out.println("Test Failed... Side Panel is not displayed.");
        }

        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchInput.sendKeys("Directory");

        String searchInputValue = searchInput.getAttribute("value");

        if("Directory".equals(searchInputValue)){
            System.out.println("Test Passed... Search input contains 'Directory'");
        }
        else {
            System.out.println("Test Failed... Search input does not contain 'Directory'");
        }

        driver.findElement(By.xpath("//span[normalize-space()='Directory']")).click();
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-left']")).click();

        WebElement page = driver.findElement(By.xpath("//h6[normalize-space()='Directory']"));
        String pageText = page.getText();

        if(page.equals(pageText)){
            System.out.println("Test Passed... Page header is 'Directory'");
        }else{
            System.out.println("Test Failed... Page header is not 'Directory'");
        }





    }
}
