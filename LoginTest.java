import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPage;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;


public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private Properties properties;

    @BeforeEach
    public void setUp() {
        properties = new Properties();
        try (InputStream is = getClass().getResourceAsStream("application.properties")) {
            try {
                properties.load(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = new ChromeDriver();
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hit URL
        driver.get(properties.getProperty("baseURL"));
        //Maximize the Window
        driver.manage().window().maximize();
        // Sending driver to LoginPage. It is like telling use this driver to Login Page.
        loginPage = new LoginPage(driver);

        // Get CorrectUsername
        driver.get(properties.getProperty("correctUsername"));

        // Get Correct Password
        driver.get(properties.getProperty("correctPassword"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    // Login Page
    @Test
    public void VerifyLoginUsingCorrectUsernameAndIncorrectPassword() {
        loginPage.LoginToApp("Admin", "Admin");
        WebElement errorMessage = driver.findElement(loginPage.invalidCredentialsLocator);
        String errorText = errorMessage.getText().trim();

//        if(errorText.equals("Invalid credentials")){
//            System.out.println("Test Passed");
//        }else{
//            System.out.println("Test Failed");
//        }

        Assertions.assertEquals("Invalid credentials", errorText, "Error message does not match");

    }

    @Test
    public void VerifyLoginUsingIncorrectUsernameAndCorrectPassword() {
        loginPage.LoginToApp("Admin1", "Admin123");

        // Error Message
        WebElement errorMessage = driver.findElement(loginPage.invalidCredentialsLocator);
        String errorText = errorMessage.getText().trim();
        Assertions.assertEquals("Invalid credentials", errorText, "Error message does not match");
    }

    @Test
    public void VerifyLoginUsingIncorrectUsernameAndIncorrectPassword() {

        loginPage.LoginToApp("Sadikshya", "Sadikshya");
        WebElement errorMessage = driver.findElement(loginPage.invalidCredentialsLocator);
        String errorText = errorMessage.getText().trim();
        Assertions.assertEquals("Invalid credentials", errorText, "Error message does not match");

    }

    @Test
    public void VerifyLoginWithoutEnteringUserNameAndPassword() {
       loginPage.LoginToApp("", "");
        WebElement errorMessageUserName = driver.findElement(loginPage.RequiredLocatorForUsername);
        WebElement errorMessagePassword = driver.findElement(loginPage.RequiredLocatorForPassword);

        // Get the text of the error message

        String errorTextUserName = errorMessageUserName.getText().trim();
        String errorTextPassword = errorMessagePassword.getText().trim();

        // Verify Error Message
        Assertions.assertEquals("Required", errorTextUserName, "Error message does not match");
        Assertions.assertEquals("Required", errorTextPassword, "Error message does not match");

    }

        @Test
        public void UsingCorrectUserNameAndCorrectPassword () {
           loginPage.LoginToApp(properties.getProperty("correctUsername"), properties.getProperty("correctPassword"));
            WebElement dashboard = driver.findElement(loginPage.dashBoardPage);
            Assertions.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed." );
            Assertions.assertEquals("Dashboard", dashboard.getText().trim(), "Dashboard text does not match");

//                    if(dashboard.isDisplayed()){
//                        System.out.println("Test Passed...");
//                    }
//                    else {
//                        System.out.println("Test Failed...");
//                    }
        }
    }


