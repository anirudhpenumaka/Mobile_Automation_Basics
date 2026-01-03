package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class WifiSwitchTest {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("automationName", "UiAutomator2");

        dc.setCapability("appPackage", "com.android.settings");
        dc.setCapability("appActivity", "com.android.settings.Settings");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), dc);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void enableWifiIfDisabled() {

        // Open Network & Internet
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Network & internet']")).click();
        //driver.findElement(By.xpath("")).click();
        // Locate Wi-Fi switch
        WebElement wifiSwitch =
                driver.findElement(By.xpath("//android.widget.Switch[@content-desc='Wi‑Fi']"));

        String state = wifiSwitch.getAttribute("checked");

        if (state.equals("false")) {
            wifiSwitch.click();
            System.out.println("Wi-Fi turned ON");
        } else {
            System.out.println("Wi-Fi already ON");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
