package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class Dashboard_Page {

    protected AppiumDriver driver;

    public Dashboard_Page(AppiumDriver driver) {
        this.driver=(AppiumDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TyMe Services']")
    private WebElement tymeServicesHeading;

    public boolean isTymeServicesHeadingVisible() {
        try {
            return tymeServicesHeading.isDisplayed();
        } catch (Exception e) {
            // Element not found or not visible
            return false;
        }
    }

    //Bottom Navigation Bar
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uDB82\uDF55\"]")
    private WebElement myAccountsIcon;

    public void clickMyAccountsIcon() {
        try {
            myAccountsIcon.click();
        } catch (RuntimeException e) {
            System.out.println("My accounts icon could not be clicked");
        }
    }

}


