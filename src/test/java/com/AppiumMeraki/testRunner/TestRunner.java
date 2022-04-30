package com.AppiumMeraki.testRunner;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		          plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "json:target/cucumber.json"},
				 features = {"Features"},
				 glue = {"com.AppiumMeraki.stepdefinitions"},
				 dryRun = false
				)


@Test
public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}
