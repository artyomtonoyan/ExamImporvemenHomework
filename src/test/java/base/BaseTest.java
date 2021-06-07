package base;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.pages.DiscoverPage;

import static setup.DriverSetup.getWebDriver;

public class BaseTest {
    @BeforeMethod
    public void start() {
        new DiscoverPage();
        getWebDriver().manage().addCookie(new Cookie("cookieConsent", "1"));
        getWebDriver().navigate().refresh();
    }

    @AfterMethod
    public void exit() {
//        getWebDriver().quit();
    }
}