package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class MessagesTest {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("automationName", "UiAutomator2");

        // Google Messages
        dc.setCapability("appPackage", "com.google.android.apps.messaging");
        dc.setCapability("appActivity",
                "com.google.android.apps.messaging.ui.ConversationListActivity");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), dc);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void sendSMS() {

        // Click "Start chat"
        driver.findElement(
                AppiumBy.accessibilityId("Start chat")
        ).click();

        // Enter phone number
        driver.findElement(
                AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")
        ).sendKeys("9876543210");

        // Click Next
        driver.findElement(
                AppiumBy.id("com.google.android.apps.messaging:id/contact_picker_create_group")
        ).click();

        // Type message
        driver.findElement(
                AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")
        ).sendKeys("Hello from Appium TestNG");

        // Click Send
        driver.findElement(
                AppiumBy.accessibilityId("Send SMS")
        ).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
