package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.Dashboard_Page;
import pages.EditProfile_Page;
import pages.MyAccount_Page;

import java.io.IOException;

public class EditProfile {

    AppiumDriver driver;
    Dashboard_Page dashboard_page;
    MyAccount_Page myAccount_page;
    EditProfile_Page editProfilePage;

    public EditProfile(AppiumDriver driver) {
        this.driver = driver;
        dashboard_page = new Dashboard_Page(driver);
        myAccount_page = new MyAccount_Page(driver);
        editProfilePage = new EditProfile_Page(driver);
    }

    public void TapOnMyAccount() {
        dashboard_page.clickMyAccountsIcon();
    }

    public void MyAccountPageLanding() {
        myAccount_page.myAccountPageHeading();
    }

    public void TapOnMyProfile() {
        myAccount_page.clickProfileOption();
    }

    public void ProfilePageLanding() {
        editProfilePage.profilePageHeading();
    }

    public void enterFirstName(String firstName) {
        editProfilePage.enterFirstName(firstName);
    }

    public void enterLastName(String lastName) {
        editProfilePage.enterLastName(lastName);
    }

    public void UpdateGender() {
        editProfilePage.chooseGender();
    }

    public void TapOnDatePicker(){
        editProfilePage.datePickerIcon();
    }

    public void yearPickerDisplay() {
        editProfilePage.YearPickerHeader();
    }

    public void yearPickerClick(){
        editProfilePage.yearPickerHeaderClick();
    }

    public void UpdateDOB(String day, String year){
        editProfilePage.selectDOB(day,year);
        editProfilePage.dobOkButton();
    }

    public void clickOnStateDropDown(String stateName)  {
        editProfilePage.updateState(stateName);
    }

    public void enterCity(String city) {
        editProfilePage.cityTextBox(city);
    }

    public void enterZipCode(String zipCode) {
        editProfilePage.zipCodeTextBox(zipCode);
    }

    public void tapOnUpdate(){
        editProfilePage.updateButton();
    }

    public void uploadImage() throws IOException, InterruptedException {
      editProfilePage.uploadProfileImageFromResources("profile.png");

    }

}