import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests {


        WebDriver webDriver;
        @BeforeMethod
        public void beforeTest() {
            System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
        }

        @Test
        public void asUserTryToLogInWithIncorrectLoginAndPassword(){

            LandingPage landingPage = new LandingPage(webDriver);
            landingPage.clickOnEnterStoreLink();

            TopMenuPage topMenuPage = new TopMenuPage(webDriver);
            topMenuPage.clickOnSignInLink();

            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.typeIntoUserNameField("NotExistingLogin");
            loginPage.typeIntoPasswordField("NotProperPassword");
            loginPage.clickOnLoginButton();
            String warningMessage = loginPage.getWarningMessage();

            assertEquals(warningMessage, "Invalid username or password. Signon failed.");
        }



        @AfterMethod
        public void afterTest(){
            webDriver.close();
            webDriver.quit();
        }


}
