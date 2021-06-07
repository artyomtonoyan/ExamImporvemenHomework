package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.BasePage;
import utils.WaitHelper;

public class DiscoverPage extends BasePage {

    @FindBy(css = ".topnav-dropdown-wrapper.nav-bar-support")
    private WebElement supportIcon;

    public DiscoverPage() {
        open(getURL());
        PageFactory.initElements(driver, this);
    }

    public void init() {
        PageFactory.initElements(driver, this);
    }

    public boolean isSupportIconAppear() {
        init();
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(supportIcon);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    @Override
    public String getURL() {
        return BASE_URL + "/discover";
    }
}
