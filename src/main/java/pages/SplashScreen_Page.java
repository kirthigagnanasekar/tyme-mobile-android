package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SplashScreen_Page {

    protected AppiumDriver driver;
    private WebDriverWait wait;

    public SplashScreen_Page(AppiumDriver driver) {
        this.driver = (AppiumDriver) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /* Notification Access Management */
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowButton_Notification;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement denyButton_Notification;

    /* Splash Screen */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]")
    private WebElement dot1;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]")
    private WebElement dot2;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]")
    private WebElement dot3;

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement getStartedButton;


    public void allowButton_Notification() {
        allowButton_Notification.click();
    }

    public void denyButton_Notification() {
        denyButton_Notification.click();
    }

    public void skipButtonSplashScreen() {
        wait.until(ExpectedConditions.visibilityOf(skipButton)).click();
    }

    public void dot1Button() {
        dot1.click();
    }

    public void dot2Button() {
        dot2.click();
    }

    public void dot3Button() {
        dot3.click();
    }

    public void clickGetStartedButton() {
        getStartedButton.click();
    }

}