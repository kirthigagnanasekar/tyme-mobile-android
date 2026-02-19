package stepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ed;
import pages.EditProfile_Page;
import testcases.EditProfile;
import testcases.LoginAsExistingUser;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class UserLoginProfileUpdateFlow {

    AppiumDriver driver;
    LoginAsExistingUser loginAsExistingUser;
    EditProfile editProfile;
    EditProfile_Page editProfile_page;

    public UserLoginProfileUpdateFlow() {
        this.driver = Hooks.getDriver();
        loginAsExistingUser = new LoginAsExistingUser(driver);
        editProfile = new EditProfile(driver);
        editProfile_page = new EditProfile_Page(driver);
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

    @Then("I change the First Name as {string}")
    public void iChangeTheFirstNameAs(String firstName) {
        editProfile.enterFirstName(firstName);
    }

    @And("I change the Last Name as {string}")
    public void iChangeTheLastNameAs(String lastName) {
        editProfile.enterLastName(lastName);
    }

    @Then("I updated the gender")
    public void iUpdatedTheGender() {
        editProfile.UpdateGender();
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

    @When("I update the state as {string}")
    public void i_update_the_state(String state)  {
        editProfile.clickOnStateDropDown(state);
        System.out.println("I update the state");
    }


    @Then("I update the city as {string}")
    public void iUpdateTheCityAs(String city) {
        editProfile.enterCity(city);
        System.out.println("I update the city");
    }

    @And("I update the zipcode as {string}")
    public void iUpdateTheZipcodeAs(String zipCode) {
        editProfile.enterZipCode(zipCode);
        System.out.println("I update the zipcode");
    }

    @Then("I tap on Update button")
    public void iTapOnUpdateButton() {
        editProfile.tapOnUpdate();
        System.out.println("I tap on Update button");
    }

    @When("I upload image from gallery")
    public void iUploadImageFromGallery() throws IOException, InterruptedException {
        editProfile.uploadImage();
        System.out.println("Element is Clicked");
    }

    @Then("I update the email address as {string}")
    public void iUpdateTheEmailAddressAs(String emailAddress) {

    }

    @Then("I update a phone number as {string}")
    public void iUpdateAPhoneNumberAs(String phoneNumber) {

    }
}