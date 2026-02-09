package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EditProfile_Page;
import testcases.EditProfile;
import testcases.LoginAsExistingUser;

public class UserLoginProfileUpdateFlow {

    AppiumDriver driver;
    LoginAsExistingUser loginAsExistingUser;
    EditProfile editProfile;

    public UserLoginProfileUpdateFlow() {
        this.driver = Hooks.getDriver();
        loginAsExistingUser = new LoginAsExistingUser(driver);
        editProfile = new EditProfile(driver);
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
    public void i_tap_on_the_Sign_In_button()  {
        loginAsExistingUser.clickLoginButton();
    }

    @Then("I enter otp as {string}")
    public void i_enter_otp(String otpInput) {
        loginAsExistingUser.enterOTP(otpInput);
    }

    @And("I tap on the Verify button")
    public void i_tap_on_the_Verify_button() {
        loginAsExistingUser.tapVerify();
    }

    @Then("I land on the dashboard")
    public void i_land_on_the_dashboard() {
        loginAsExistingUser.dashboardLanding();
        System.out.println("I land on the dashboard");
    }

    @Given("I tap on My accounts icon from bottom navigation bar")
    public void i_tap_on_My_accounts_icon_from_bottom_navigation_bar() {
        editProfile.TapOnMyAccount();
        System.out.println("I tap on My accounts icon from bottom navigation bar");
    }

    @And("I land on My account page")
    public void i_land_on_My_account_page() {
        editProfile.MyAccountPageLanding();
        System.out.println("I land on My account page");
    }

    @And("I tap on My profile option")
    public void i_tap_on_My_profile_option() {
        editProfile.TapOnMyProfile();
        System.out.println("I tap on My profile option");
    }

    @And("I land on the edit profile page")
    public void i_land_on_the_edit_profile_page() {
        editProfile.ProfilePageLanding();
        System.out.println("I land on the edit profile page");
    }

    @When("I tap on Date of birth field")
    public void i_tap_on_Date_of_birth_field() {
        editProfile.TapOnDatePicker();
        System.out.println("I tap on Date of birth field");
    }

    @Then("the calendar picker opens")
    public void the_calendar_picker_opens() {
        editProfile.yearPickerClick();
        editProfile.yearPickerDisplay();
        System.out.println("The calendar picker opens");
    }

    @When("I choose the date {string} May {string} and confirms the date")
    public void user_selects_date_of_birth(String day, String year) {
        editProfile.UpdateDOB(day, year);
        System.out.println("Date of birth selected");
    }
//
//    @When("I tap on profile icon it opens a drop down to to edit photo")
//    public void i_tap_on_profile_icon(){
//        editProfile.UpdateProfile();
//    }
//
//    @Then("I updated my profile picture")
//    public void i_updated_my_profile_picture() {
//
//    }

    @When("I update the state as {string}")
    public void i_update_the_state_as(String state) {
        editProfile.tapOnStateDropDown();
        editProfile.selectStateFromDropDown(state);
    }

}