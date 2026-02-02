package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testcases.LoginAsExistingUser;

public class ExistingLogin {

    AppiumDriver driver;
    LoginAsExistingUser loginAsExistingUser;

    public ExistingLogin() {
        this.driver = Hooks.getDriver();
        loginAsExistingUser = new LoginAsExistingUser(driver);
    }

    @Given("I launch the TyMe application")
    public void i_launch_the_tyme_application() {

        System.out.println("Launching the TyMe application");
    }

    @Then("the application opens successfully and allows a notification")
    public void the_application_opens_successfullyAndAllows_a_notification() {
        System.out.println("The application opens successfully and allows a notification");
    }

    @Then("I skipped a splash screen")
    public void i_skipped_a_splash_screen() {
        loginAsExistingUser.skipSplashScreen();
    }

    @When("lands on login page and I enter email address {string}")
    public void i_lands_on_login_page_and_enters_email(String emailAddress) {
        loginAsExistingUser.enterEmail(emailAddress);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {

        loginAsExistingUser.enterPassword(password);
    }

    @And("I tap on the Sign In button")
    public void i_tap_on_the_Sign_In_button() throws InterruptedException {
        loginAsExistingUser.clickLoginButton();
        Thread.sleep(5000);

    }

//    @When("I enter OTP {string}")
//    public void i_enter_OTP(String otp) {
//        loginAsExistingUser.enterLoginOTP(otp);
//    }

    @Then("I enter otp as {string}")
    public void i_enter_otp(String otpInput) {
        loginAsExistingUser.enterOTP(otpInput);
    }

//    @Then("I entered first otp digit as {string}")
//    public void i_entered_first_otp_digit_as(String otp) {
//        loginAsExistingUser.OtpInput1(otp);
//    }
//
//    @Then("I entered second otp digit as {string}")
//    public void i_entered_second_otp_digit_as(String otp) {
//        loginAsExistingUser.OtpInput2(otp);
//    }
//
//    @Then("I entered third otp digit as {string}")
//    public void i_entered_third_otp_digit_as(String otp) {
//        loginAsExistingUser.OtpInput3(otp);
//    }
//
//    @Then("I entered fourth otp digit as {string}")
//    public void i_entered_fourth_otp_digit_as(String otp) {
//        loginAsExistingUser.OtpInput4(otp);
//    }
//
//    @Then("I entered fifth otp digit as {string}")
//    public void i_entered_fifth_otp_digit_as(String otp) {
//        loginAsExistingUser.OtpInput5(otp);
//    }
//
//    @Then("I entered sixth otp digit as {string}")
//    public void i_entered_sixth_otp_digit_as(String otp) {
//        loginAsExistingUser.OtpInput6(otp);
//    }

    @And("I tap on the Verify button")
    public void i_tap_on_the_Verify_button() {
        loginAsExistingUser.tapVerify();
    }

    @Then("I land on the dashboard")
    public void i_land_on_the_dashboard() {
        loginAsExistingUser.dashboardLanding();
        System.out.println("I land on the dashboard");
    }

}