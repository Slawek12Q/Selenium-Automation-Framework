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



        LandingPage landingPage = new LandingPage();

        boolean isBannerAfterLoginDisplayed = landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();
/*
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();
        FooterPage footerPage = new FooterPage();*/

        assertTrue(isBannerAfterLoginDisplayed);

    }
}
