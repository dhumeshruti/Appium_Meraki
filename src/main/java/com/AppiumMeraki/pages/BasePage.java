package com.AppiumMeraki.pages;




import com.AppiumMeraki.stepdefinitions.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
	
	public AppiumDriver<MobileElement> driver = Hooks.driver;
	
}
