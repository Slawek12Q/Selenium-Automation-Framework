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

            webDriver.findElement(By.cssSelector("#Content a")).click();
            webDriver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']")).click();
            webDriver.findElement(By.name("username")).sendKeys("Login");
            webDriver.findElement(By.name("password")).sendKeys("Paswd");
            webDriver.findElement(By.name("signon")).click();
            assertEquals(webDriver.findElement(By.cssSelector("#Content ul[class='messages'] li")).getText(), "Invalid username or password. Signon failed.");
        }



        @AfterMethod
        public void afterTest(){
            webDriver.close();
            webDriver.quit();
        }


}
