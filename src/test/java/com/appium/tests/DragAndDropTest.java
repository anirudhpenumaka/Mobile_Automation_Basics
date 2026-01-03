package com.appium.tests;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDropTest {

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
    public void dragAndDropTest() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Drag and Drop\"))"
        )).click();

        WebElement source =
                driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        WebElement destination =
                driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

        // W3C drag & drop
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger, 1);

        dragAndDrop.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.fromElement(source),
                0, 0));

        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        dragAndDrop.addAction(finger.createPointerMove(
                Duration.ofSeconds(1),
                PointerInput.Origin.fromElement(destination),
                0, 0));

        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(dragAndDrop));
    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
        	Thread.sleep(3000);
            driver.quit();
        }
    }
}
