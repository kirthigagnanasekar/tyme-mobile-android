package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.Dashboard_Page;
import pages.EditProfile_Page;
import pages.MyAccount_Page;

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

    //Uploading profile picture
    public void UpdateProfile(){
        editProfilePage.profileIcon();
        editProfilePage.tapAddPhotoIfAvailable();
        editProfilePage.selectImageFromGallery();
    }

    public void tapOnStateDropDown(){
        editProfilePage.stateDropDown();
    }

    public void selectStateFromDropDown(String state){
        editProfilePage.searchState(state);
    }

    public void cityZipCodeClearance(){
        editProfilePage.cityZipCodeClearance();
    }


}