package testcases;

import io.appium.java_client.AppiumDriver;
import pages.Dashboard_Page;
import pages.Login_Page;
import pages.LoginAuthentication_Page;
import pages.SplashScreen_Page;

public class LoginAsExistingUser {
    AppiumDriver driver;
    SplashScreen_Page splashScreenPage;
    Login_Page loginPage;
    LoginAuthentication_Page loginAuthenticationPage;
    Dashboard_Page dashboardPage;

    public LoginAsExistingUser(AppiumDriver driver) {
        this.driver = driver;
        splashScreenPage = new SplashScreen_Page(driver);
        loginPage = new Login_Page(driver);
        loginAuthenticationPage = new LoginAuthentication_Page(driver);
        dashboardPage = new Dashboard_Page(driver);
    }

    public void skipSplashScreen() {

        splashScreenPage.skipButtonSplashScreen();
    }

    public void enterEmail(String email) {

        loginPage.emailAddressTextBox(email);
    }

    public void enterPassword(String password) {
        loginPage.password(password);
    }

    public void clickLoginButton() {
        loginPage.signInButton();
    }

    public void enterOTP(String otp) {
        loginAuthenticationPage.enterOTP(otp);
    }

    public void tapVerify() {
        loginAuthenticationPage.verifyButton();
    }

    public void dashboardLanding(){
        dashboardPage.isTymeServicesHeadingVisible();
    }
}

