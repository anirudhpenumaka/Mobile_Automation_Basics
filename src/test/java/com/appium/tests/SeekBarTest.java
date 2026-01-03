package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class SeekBarTest {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        // -------- Appium basic configuration --------
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");      // OS type
        dc.setCapability("deviceName", "emulator-5554"); // Emulator name
        dc.setCapability("automationName", "UiAutomator2");

        // API Demos app details
        dc.setCapability("appPackage", "io.appium.android.apis");
        dc.setCapability("appActivity", ".ApiDemos");

        // Start Appium session
        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), dc);

        // Small wait so elements load properly
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void moveSeekBarTo70Percent() {

        // ---------- Step 1: Open "Views" ----------
        // We need to go inside Views to find Seek Bar
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // ---------- Step 2: Scroll until "Seek Bar" ----------
        // Seek Bar is not visible immediately, so we scroll
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Seek Bar\"))"
        )).click();

        // ---------- Step 3: Locate the SeekBar ----------
        // Only one SeekBar exists on this screen
        WebElement seekBar =
                driver.findElement(AppiumBy.className("android.widget.SeekBar"));

        // ---------- Step 4: Get SeekBar position & size ----------
        int startX = seekBar.getLocation().getX();        // Starting X position
        int startY = seekBar.getLocation().getY();        // Starting Y position
        int width  = seekBar.getSize().getWidth();        // Total width
        int centerY = startY + (seekBar.getSize().getHeight() / 2); // Middle height

        // We want to move SeekBar to 70% of its width
        int moveToX = startX + (int) (width * 0.7);

        // ---------- Step 5: Create W3C touch action ----------
        // Finger represents a real finger touching the screen
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(finger, 1);

        // Move finger to the start of SeekBar (without touching)
        drag.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX, centerY));

        // Touch the SeekBar thumb
        drag.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        // Drag finger to 70% position
        drag.addAction(finger.createPointerMove(
                Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                moveToX, centerY));

        // Release finger
        drag.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        // Perform the complete drag action
        driver.perform(Collections.singletonList(drag));
    }

    @AfterClass
    public void tearDown() {
        // Close Appium session
        if (driver != null) {
            driver.quit();
        }
    }
}
