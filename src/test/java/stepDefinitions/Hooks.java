package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URL;


public class Hooks {

    public static AppiumDriver driver;

    //capabilities to start an appium session
    @Before
    public void setUpDriver() {
        try{
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("Kirthi");
            options.setPlatformVersion("15.0");
            options.setApp("C:/Users/ASUS/Downloads/biovault-dev-release (1).apk");
            options.setAutomationName("UiAutomator2");
            options.setAutoGrantPermissions(true);
            options.setCapability("noReset", true);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    @After
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
