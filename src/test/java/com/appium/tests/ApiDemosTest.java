package com.appium.tests;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ApiDemosTest {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

    	MutableCapabilities dc = new MutableCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "Android Emulator");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformVersion", "10");
        dc.setCapability("appPackage", "io.appium.android.apis");
        dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        driver = new AndroidDriver(
        		new URL("http://127.0.0.1:4723"),
                dc
        );
    }
    
    @Test
    void basic()
    {
    	
    }
    
    
    @AfterClass
    public void justLaunchApp() throws InterruptedException {
    	Thread.sleep(3000);
        System.out.println("ApiDemos launched");
    }
}
