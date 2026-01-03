package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class RadioButtonTest {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "io.appium.android.apis");
        dc.setCapability("appActivity", ".ApiDemos");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), dc);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void handleRadioButton() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Controls")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Light Theme")).click();

        // Locate Radio Button
        WebElement radioButton =
                driver.findElement(AppiumBy.id("io.appium.android.apis:id/radio1"));

        // Select if not already selected
        if (radioButton.getAttribute("checked").equals("false")) {
            radioButton.click();
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
        driver.quit();
    }
}
