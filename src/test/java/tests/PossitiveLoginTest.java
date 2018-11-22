package tests;

import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertTrue;

public class PossitiveLoginTest extends BaseTest {

    @Test
    public void asUserLoginUsingValidLoginAndPassword(){



        LandingPage landingPage = new LandingPage(webDriver);
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage(webDriver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();
        FooterPage footerPage = new FooterPage(webDriver);

        assertTrue(footerPage.isBannerAfterLoginDisplayed());

    }
}
