package com.AppiumMeraki.stepdefinitions;


import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.AppiumMeraki.commonFunctions.CapabilitiesReaderSimple;
import com.AppiumMeraki.driverInstance.DriverInstance;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;

public class Hooks {
	public static AppiumDriver<MobileElement> driver;
	String deviceListLocation = "src/test/resources/DeviceSetupList.json";
	String runner = "src/test/resources/Runner.json";
	
	
	@Before
	public void InitializeTest(Scenario scenario) throws Exception{
	//Read the Runner.json file and get the device name. 
	JSONParser jsonParser = new JSONParser();
	JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(System.getProperty("user.dir") + "/"+runner));
	//Fetch the device capabilities based on device name
	driver = DriverInstance.initatiateDriver(CapabilitiesReaderSimple.getDesiredCapabilities(jsonObject.get("Device").toString(), deviceListLocation));
			
		
	}

	@After
	public void TearDown(Scenario scenario){
		try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
	}
}
