package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EditProfile_Page {

    AppiumDriver driver;
    private WebDriverWait wait;

    public EditProfile_Page(AppiumDriver driver) {
        this.driver = (AppiumDriver) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']")
    private WebElement profilePageHeading;

    public void profilePageHeading() {
        profilePageHeading.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uDB83\uDE18\"]")
    private WebElement datePickerIcon;

    public void datePickerIcon() {
        datePickerIcon.click();
    }

    @AndroidFindBy(id = "android:id/date_picker_header_year")
    private WebElement YearPickerHeader;

    public void yearPickerHeaderClick() {
        YearPickerHeader.click();
    }

    public void YearPickerHeader() {
        YearPickerHeader.isDisplayed();
    }

    @AndroidFindBy(id = "android:id/button1")
    private WebElement dobOkButton;

    public void dobOkButton() {
        dobOkButton.click();
    }


    public void selectYear(String year) {
        //YearPickerHeader.click();
        driver.findElement(
                By.xpath("//android.widget.TextView[@text='" + year + "']")
        ).click();
    }

    // Select day dynamically
    public void selectDay(String day) {
        driver.findElement(
                By.xpath("//android.view.View[@content-desc[contains(.,'" + day + " ')]]")
        ).click();
    }

    // Complete DOB selection
    public void selectDOB(String day, String year) {
        selectYear(year);
        selectDay(day);
    }

    /* Profile picture updation */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uE412\"]")
    private WebElement profileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add photo']")
    private WebElement addPhotoButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove photo']")
    private WebElement removePhotoButton;

    public void profileIcon() {
        profileIcon.click();
    }

    public void choosePhotoFromGoogleImage(){

    }

     public void uploadImage(){
         if (wait.until(ExpectedConditions.visibilityOf(addPhotoButton)).isDisplayed()
                 && wait.until(ExpectedConditions.visibilityOf(removePhotoButton)).isDisplayed()) {

             wait.until(ExpectedConditions.elementToBeClickable(removePhotoButton)).click();
         } else {

         }
   }








    // Step 3: Select image from system gallery
    public void selectImageFromGallery() {

        // Handle permission popup (if appears)
        try {
            driver.findElement(
                    By.id("com.android.permissioncontroller:id/permission_allow_button")
            ).click();
        } catch (Exception ignored) {
        }

        // Select FIRST image thumbnail from gallery
        driver.findElement(
                By.xpath("(//android.widget.ImageView)[1]")
        ).click();
    }

    //State Drop down Handling
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uEB33\"][1]")
    private WebElement stateDropDown;

    public void stateDropDown() {
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().textContains(\"State\"))"
                )
        );
        stateDropDown.click();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search State']")
    private WebElement searchState;


    public void searchState(String state) {
        searchState.sendKeys(state);
        driver.findElement(By.xpath("//android.widget.TextView[@text= ' + state + ']")).click();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Select City']")
    private WebElement cityTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your zip code']")
    private WebElement zipCodeTextBox;

    public void cityZipCodeClearance(){
        String cityFieldValue = cityTextBox.getText();
        cityFieldValue.isEmpty();
        String zipCodeFieldValue = zipCodeTextBox.getText();
        zipCodeFieldValue.isEmpty();
    }

    public void cityTextBox(String city){
        cityTextBox.sendKeys(city);
    }

    public void zipCodeTextBox(String zipCode){
        zipCodeTextBox.sendKeys(zipCode);
    }


    }

