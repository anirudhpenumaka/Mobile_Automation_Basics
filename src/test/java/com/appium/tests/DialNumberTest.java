package com.appium.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class DialNumberTest {

    public static void main(String[] args) throws Exception {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.android.dialer");
        dc.setCapability("appActivity", "com.android.dialer.main.impl.MainActivity");

        AndroidDriver driver =
                new AndroidDriver(new URL("http://127.0.0.1:4723"), dc);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open keypad (locator may vary slightly)
        driver.findElement(AppiumBy.accessibilityId("key pad")).click();

        String number = "9876543210";
        driver.findElement(By.id("com.android.dialer:id/empty_list_view_message")).sendKeys("9876543210");
        
        for (char digit : number.toCharArray()) {
            driver.findElement(
                AppiumBy.accessibilityId(String.valueOf(digit))
            ).click();
        }
        
        System.out.println("Number dialed successfully");

        driver.quit();
    }
}
