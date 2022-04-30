package com.AppiumMeraki.pages;

import java.util.ArrayList;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;



public class WirelessLAN extends BasePage{
	
	String platformName =  driver.getCapabilities().getCapability("platformName").toString();
	Logger logger = LogManager.getLogger(WirelessLAN.class);
	
	public void launchApp(){
	driver.launchApp();
		
	}
	
	public void enterAPIKey(){
		logger.info("Entering API Key");
		if(platformName.equals("Android"))
		driver.findElement(By.id("com.meraki.mapidemo:id/apiKeyTxt")).sendKeys("5da1735a6a6b1360986bb2c8c10ae2817e476244");
		
		else
			driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeTextField[`name == 'apiKeyTxt'`]")).sendKeys("5da1735a6a6b1360986bb2c8c10ae2817e476244");
	}
	
	public void hitGoButton(){
		logger.info("Hitting Go Button");
		if(platformName.equals("Android"))
			driver.findElement(By.id("com.meraki.mapidemo:id/goButton")).click();
		
		else
			driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Go'`]")).click();
			
	}
	
	public void verifyNetworkList(){
		logger.info("Verifying Count of Networks Displayed");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		List<MobileElement> li = new ArrayList<>();
		if(platformName.equals("Android")){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.meraki.mapidemo:id/user_list_item")));      
		li = driver.findElements(By.id("com.meraki.mapidemo:id/user_list_item"));
		}
		else{
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSClassChain("**/XCUIElementTypeTable/XCUIElementTypeCell")));      
			li = driver.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeTable/XCUIElementTypeCell"));
		}
		if(li.size() <= 4)
			assert true;
		else
			assert false;
	}
	
	public void clickWirelessLAN(String string){
		String x = "";
		logger.info("Clicking on "+string+" network");
		if(platformName.equals("Android")){
		x = "//*[@text="+"'"+string+"'"+"]";
		driver.findElement(By.xpath(x)).click();
		}
		else
		{
			x = "**/XCUIElementTypeTable/XCUIElementTypeCell[`name CONTAINS "+"'"+string+"'"+"`]";
			driver.findElement(MobileBy.iOSClassChain(x)).click();
		}
	}
	
	public void verifyNetworkDetails(){
		logger.info("Verifying network details:");
		if(platformName.equals("Android")){
		assert driver.findElement(By.id("com.meraki.mapidemo:id/modelLabel")).isDisplayed();
		assert driver.findElement(By.id("com.meraki.mapidemo:id/modelValue")).isDisplayed();
		assert driver.findElement(By.id("com.meraki.mapidemo:id/serialLabel")).isDisplayed();
		assert driver.findElement(By.id("com.meraki.mapidemo:id/serialValue")).isDisplayed();
		assert driver.findElement(By.id("com.meraki.mapidemo:id/usageLabel")).isDisplayed();
		assert driver.findElement(By.id("com.meraki.mapidemo:id/usageValue")).isDisplayed();
		assert driver.findElement(By.id("com.meraki.mapidemo:id/numClientsLabel")).isDisplayed();
		assert driver.findElement(By.id("com.meraki.mapidemo:id/numClientsValue")).isDisplayed();
		}
		else{
			assert driver.findElement(MobileBy.iOSNsPredicateString("label == 'Model'")).isDisplayed();
			assert driver.findElement(MobileBy.iOSNsPredicateString("label == 'Serial'")).isDisplayed();
			assert driver.findElement(MobileBy.iOSNsPredicateString("label == 'Usage'")).isDisplayed();
			assert driver.findElement(MobileBy.iOSNsPredicateString("label == 'Number of clients'")).isDisplayed();
		}
	}
	
}
