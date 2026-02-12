package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Page {

    protected AppiumDriver driver;
    private WebDriverWait wait;

    public Login_Page(AppiumDriver driver) {
        this.driver = (AppiumDriver) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your email address']")
    private WebElement emailAddressTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password']")
    private WebElement passwordTextBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sign In']")
    private WebElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
    private WebElement forgotPassword;

    @AndroidFindBy(accessibility = "Create Account")
    private WebElement createAccountButton;

    public void emailAddressTextBox(String email) {

        emailAddressTextBox.sendKeys(email);
    }

    public void password(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void signInButton() {
        signInButton.click();
    }

    public void forgotPassword() {
        forgotPassword.click();
    }

    public void createAccountButton() {
        createAccountButton.click();
    }

}