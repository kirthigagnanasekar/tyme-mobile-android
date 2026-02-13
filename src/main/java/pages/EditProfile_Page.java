package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uDB83\uDE18\"]")
    private WebElement datePickerIcon;

    @AndroidFindBy(id = "android:id/date_picker_header_year")
    private WebElement YearPickerHeader;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement dobOkButton;

    /* Profile picture updation */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uE412\"]")
    private WebElement profileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add photo']")
    private WebElement addPhotoButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove photo']")
    private WebElement removePhotoButton;

    //State Drop down Handling
    @AndroidFindBy(xpath = "(//android.view.ViewGroup//android.widget.TextView[@text='\uEB33'])")
    private WebElement stateDropdown;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search State\"]")
    public WebElement searchStateInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Select City\"]")
    public WebElement cityTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter your zip code\"]")
    public WebElement zipCodeTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uE314\"]")
    public WebElement backButton;

    @AndroidFindBy(accessibility = "Update")
    private WebElement updateButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Update']")
    private WebElement updateButton_PopUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tyme member updated successfully\"]")
    private WebElement UpdateSuccessToaster;

    public void profilePageHeading() {

        profilePageHeading.isDisplayed();
    }

    public void dobOkButton() {

        dobOkButton.click();
    }


    public void datePickerIcon() {

        datePickerIcon.click();
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

    public void yearPickerHeaderClick() {
        YearPickerHeader.click();
    }

    public void YearPickerHeader() {

        YearPickerHeader.isDisplayed();
    }

    public void updateState(String stateName) {
        // 1. Scroll to State field (Fixed syntax)
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().textContains(\"State*\"))"
        ));

        // 2. Click Dropdown (Fixed indexing)
        String stateDropdownXpath = "(//android.view.ViewGroup[contains(@content-desc, '\uEB33')])[1]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(stateDropdownXpath))).click();

        // 3. Search and Select
        wait.until(ExpectedConditions.visibilityOf(searchStateInput)).sendKeys(stateName);
        String resultXpath = "//android.view.ViewGroup[contains(@content-desc, '" + stateName + "')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(resultXpath))).click();

    }

    public void cityTextBox(String cityName) {
        cityTextBox.clear();
        cityTextBox.sendKeys(cityName);
    }

    public void zipCodeTextBox(String zipCodeInput) {
       zipCodeTextBox.clear();
       zipCodeTextBox.sendKeys(zipCodeInput);
    }

    public void updateButton() {
        if(updateButton.isEnabled()){
            updateButton.click();
            updateButton_PopUp.click();
        }
        else{
            backButton.click();
        }
    }
}