package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // To catch the driver send by the LoginTest Page
    public LoginPage(WebDriver driver){ // Like String username
        this.driver = driver;
    }



    // Cannot open another browser. Use only one driver. Send this driver to another page.

    // New chrome driver garyo bhane naya chrome feri kholchha. Bhitra jadeina.
    // Aaba parameterized Constructor Pathaunu parchha.

    // Methods and Locators

    // Locators



    public By userNameLocator= By.name("username");
    public By passwordLocator= By.name("password");
    public By loginButtonLocator= By.tagName("button");
    public By invalidCredentialsLocator= By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    public By RequiredLocatorForUsername = By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]");
    public By RequiredLocatorForPassword = By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]") ;

    // Needs to move from Login To DashBoard Page becuase acc to POM , page details should be in specific page.
    public By dashBoardPage = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']");

    // Methods

    public void LoginToApp(String username, String password){
        driver.findElement(userNameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

}
