package com.AppiumMeraki.driverInstance;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverInstance {
	public static AppiumDriver<MobileElement> driver;
	public static String APPIUM = "http://localhost:4723/wd/hub";
	public static DesiredCapabilities caps = new DesiredCapabilities();
	
	
	public static AppiumDriver<MobileElement> initatiateDriver(DesiredCapabilities caps) throws Exception{
		
		if(caps.getCapability("platformName") == "Android"){
			
			driver = new AndroidDriver<MobileElement>(new URL(APPIUM),caps);
		}
		else{
			driver = new IOSDriver<MobileElement>(new URL(APPIUM),caps);
		
	}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

}
}
