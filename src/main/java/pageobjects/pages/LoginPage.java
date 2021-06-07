package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.BasePage;
import utils.WaitHelper;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameInputField;

    @FindBy(name = "password")
    private WebElement passwordInputField;

    @FindBy(css = ".btn-small.full")
    private WebElement submitButton;

    @FindBy(css = "[class='dropdown-project-list']")
    private WebElement projectsIcon;

    public LoginPage() {
        open(getURL());
        PageFactory.initElements(driver, this);
    }

    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void typeUsername(String username) {
        WaitHelper.getInstance().waitForElementToDisplayed(usernameInputField);
        type(usernameInputField, username);
    }

    public void typePassword(String password) {
        WaitHelper.getInstance().waitForElementToDisplayed(passwordInputField);
        type(passwordInputField, password);
    }

    public void clickOnSubmitButton() {
        WaitHelper.getInstance().waitForElementToDisplayed(submitButton);
        click(submitButton);
    }

    public boolean isLoginSuccessful() {
        init();
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(projectsIcon);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    @Override
    public String getURL() {
        return BASE_URL + "/login";
    }
}