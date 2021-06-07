import base.BaseTest;
import org.testng.annotations.Test;
import pageobjects.pages.DiscoverPage;
import pageobjects.pages.LoginPage;
import utils.ApiHelper;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getWebDriver;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithAPIPositiveCase() throws IOException {
        DiscoverPage homePage = new DiscoverPage();
        homePage.setItemInLocalStorage("token", String.valueOf(ApiHelper.login("artyomtest","artyomtest").get("auth_token")));
        homePage.setItemInLocalStorage("userInfo", String.valueOf(ApiHelper.login("artyomtest","artyomtest")));
        getWebDriver().navigate().refresh();
        assertTrue(homePage.isSupportIconAppear(), "Login Unsuccessful");
    }

    @Test
    public void loginWithAPINegativeCase() throws IOException {
        DiscoverPage homePage = new DiscoverPage();
        homePage.setItemInLocalStorage("token", String.valueOf(ApiHelper.login("artyomtestt","artyomtest").get("auth_token")));
        homePage.setItemInLocalStorage("userInfo", String.valueOf(ApiHelper.login("artyomtestt","artyomtest")));
        getWebDriver().navigate().refresh();
        assertFalse(homePage.isSupportIconAppear(), "Login Successful, should be unsuccessful");
    }

    @Test
    public void loginByUIPositiveCase() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("artyomtest");
        loginPage.typePassword("artyomtest");
        loginPage.clickOnSubmitButton();
        assertTrue(loginPage.isLoginSuccessful(), "Login Unsuccessful");
    }

    @Test
    public void loginByUINegativeCaseEmptyCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("");
        loginPage.typePassword("");
        loginPage.clickOnSubmitButton();
        assertFalse(loginPage.isLoginSuccessful(), "Login Unsuccessful");
    }

    @Test
    public void loginByUINegativeCaseWrongUsername() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("artyomtestt");
        loginPage.typePassword("artyomtest");
        loginPage.clickOnSubmitButton();
        assertFalse(loginPage.isLoginSuccessful(), "Login Unsuccessful");
    }

    @Test
    public void loginByUINegativeCaseWrongPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeUsername("artyomtest");
        loginPage.typePassword("artyomtestt");
        loginPage.clickOnSubmitButton();
        assertFalse(loginPage.isLoginSuccessful(), "Login Unsuccessful");
    }
}