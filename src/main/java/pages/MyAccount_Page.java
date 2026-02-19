package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Page {

    AppiumDriver driver;

    public MyAccount_Page(AppiumDriver driver) {
        this.driver=(AppiumDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    WebElement myAccountPageHeading;

        @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Profile']")
    private WebElement myProfileOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Subscription']")
    private WebElement mySubscriptionOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Help & Contact Support']")
    private WebElement helpAndSupportOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preferences']")
    private WebElement preferencesOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign out']")
    private WebElement signOutOption;

    public void myAccountPageHeading(){
        myAccountPageHeading.isDisplayed();
    }

    public void clickProfileOption(){
        myProfileOption.click();
    }

    public void clickSubscriptionOption(){
        mySubscriptionOption.click();
    }

    public void clickHelpAndSupportOption(){
        helpAndSupportOption.click();
    }

    public void clickPreferencesOption(){
        preferencesOption.click();
    }

    public void clickSignOutOption(){
        signOutOption.click();
    }


}
