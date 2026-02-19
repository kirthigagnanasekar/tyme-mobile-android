package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='First Name']")
    private WebElement FirstNameTextBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Last Name']")
    private WebElement LastNameTextBox;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'\uEB33')]")
    private WebElement GenderDropDown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Male\"]")
    private WebElement MaleFromDropDown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Female\"]")
    private WebElement FemaleFromDropDown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uDB83\uDE18\"]")
    private WebElement datePickerIcon;

    @AndroidFindBy(id = "android:id/date_picker_header_year")
    private WebElement YearPickerHeader;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement dobOkButton;

    /* Profile picture updation */
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"\uE412\"]")
    private WebElement profileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add photo']")
    private WebElement addPhotoButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove photo']")
    private WebElement removePhotoButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Media grid\"]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View")
    private WebElement mediaGrid;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.view.View[3]/android.widget.Button")
    private WebElement doneButtonFromGPhotos;

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

    public void enterFirstName(String firstName) {
        FirstNameTextBox.clear();
        FirstNameTextBox.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        LastNameTextBox.clear();
        LastNameTextBox.sendKeys(lastName);
    }

    public void chooseGender() {

        if (GenderDropDown.getText().equals("female")) {
            GenderDropDown.click();
            MaleFromDropDown.click();
        } else {
            GenderDropDown.click();
            FemaleFromDropDown.click();
        }
    }

    public void dobOkButton() {

        dobOkButton.click();
    }


    public void datePickerIcon() {

        datePickerIcon.click();
    }

    public void selectYear(String year) {
        //YearPickerHeader.click();
        String currentYear = YearPickerHeader.getText();
        if (!currentYear.equals(year)) {
            driver.findElement(
                    By.xpath("//android.widget.TextView[@text='" + year + "']")
            ).click();
        } else {
            String updateYear = String.valueOf(Integer.parseInt(currentYear) - 1);
            driver.findElement(
                    By.xpath("//android.widget.TextView[@text='" + updateYear + "']")
            ).click();
        }
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
        if (updateButton.isEnabled()) {
            updateButton.click();
            updateButton_PopUp.click();
        } else {
            backButton.click();
        }
    }

    //image upload
    private void handlePermissions() {
        String[] permissionTexts = {"Allow", "Allow all", "Grant"};
        for (String text : permissionTexts) {
            try {
                driver.findElement(AppiumBy.xpath("//*[@text='" + text + "']")).click();
                break;
            } catch (Exception e) {
                // Continue if no permission dialog
            }
        }
    }

    public boolean visibilityOfAddButton(){
        return addPhotoButton.isDisplayed();
    }

    private void scrollToMediaItem() {
        String uiAutomator = "new UiScrollable(new UiSelector().description(\"Media grid\"))."
                + "scrollIntoView(new UiSelector().className(\"android.view.View\").instance(1))";
        driver.findElement(AppiumBy.androidUIAutomator(uiAutomator));
    }

    public void uploadProfileImageFromResources(String imageName) throws IOException, InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(profileIcon));
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();

        // 1. Push image from resources to device
        File resourceDir = new File("src/test/resources/images");
        File imageFile = new File(resourceDir, imageName);
        ((AndroidDriver) driver).pushFile("/sdcard/Pictures/" + imageName, imageFile);

        try {
            // If profile exists, Add & Remove buttons will be visible
            wait.until(ExpectedConditions.visibilityOf(addPhotoButton));

            // 1. Push image from resources to device
//            File resourceDir = new File("src/test/resources/images");
//            File imageFile = new File(resourceDir, imageName);
//            ((AndroidDriver) driver).pushFile("/sdcard/Pictures/" + imageName, imageFile);

            // 2. Click Add Photo -> opens gallery
            addPhotoButton.click();

            // 3. Handle permission dialogs (if any)
            handlePermissions();

            // 4. Scroll and select media item
            scrollToMediaItem();
            wait.until(ExpectedConditions.visibilityOf(mediaGrid)).click();

            // 5. Click Done from Google Photos
            wait.until(ExpectedConditions.visibilityOf(doneButtonFromGPhotos)).click();

            // 6. Again click profile icon to remove photo
            wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
            wait.until(ExpectedConditions.elementToBeClickable(removePhotoButton)).click();

        } catch (Exception e) {
            // If Add button is not visible, gallery is opened directly

            // 1. Push image from resources to device
//            File resourceDir = new File("src/test/resources/images");
//            File imageFile = new File(resourceDir, imageName);
//            ((AndroidDriver) driver).pushFile("/sdcard/Pictures/" + imageName, imageFile);

            // 2. Handle permission dialogs (if any)
            handlePermissions();

            // 3. Scroll and select media item
            scrollToMediaItem();
            wait.until(ExpectedConditions.visibilityOf(mediaGrid));
            wait.until(ExpectedConditions.elementToBeClickable(mediaGrid)).click();

            // 4. Click Done from Google Photos
            wait.until(ExpectedConditions.visibilityOf(doneButtonFromGPhotos)).click();
        }
    }



}
