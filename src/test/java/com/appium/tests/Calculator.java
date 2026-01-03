package com.appium.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Calculator {
	
	AndroidDriver driver;
	
    
    @BeforeClass
    void setup() throws MalformedURLException
    {
    	MutableCapabilities dc = new MutableCapabilities();
    	dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "Android Emulator");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformVersion", "10");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        
        URL url=new URL("http://127.0.0.1:4723");
        
        driver=new AndroidDriver(url,dc);
    }
    
    @Test
    void basic()
    {
    	WebElement seven=driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
    	seven.click();
    	WebElement plus=driver.findElement(By.id("com.google.android.calculator:id/op_add"));
    	plus.click();
    	WebElement four=driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
    	four.click();
    	WebElement equals=driver.findElement(By.id("com.google.android.calculator:id/eq"));
    	equals.click();
    	
    	boolean value=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']")).isDisplayed();
    	System.out.println(value+" addition is working fine");
    }
    
    @AfterClass
    void teardown() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.quit();
    }
}
