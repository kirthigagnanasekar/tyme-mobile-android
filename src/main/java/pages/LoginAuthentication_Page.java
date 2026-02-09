package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginAuthentication_Page {

    protected AndroidDriver driver;

    public LoginAuthentication_Page(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='otp-input']")
    private WebElement otpInputs;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Resend OTP']")
    private WebElement resendOtp;

    @AndroidFindBy(accessibility = "Verify")
    private WebElement verifyButton;

    public void enterOTP(String otp) {

        // Step 1: Tap OTP container to focus
        otpInputs.click();

        // Step 2: Enter each digit via KeyEvent
        for (char digit : otp.toCharArray()) {
            driver.pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + digit)));
        }
    }

    public void resendOtp() {
        resendOtp.click();
    }

    public  void verifyButton() {
        verifyButton.click();
    }

}


