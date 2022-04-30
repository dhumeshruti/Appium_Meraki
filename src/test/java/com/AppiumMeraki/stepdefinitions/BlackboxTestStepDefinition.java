package com.AppiumMeraki.stepdefinitions;


import io.cucumber.java.en.*;

import com.AppiumMeraki.pages.WirelessLAN;


public class BlackboxTestStepDefinition {
	WirelessLAN wlan = new WirelessLAN();
	
	@Given("Application is installed and launched")
	public void application_is_installed_and_launched() {
		wlan.launchApp();
	}
	

	@Given("User enters API Key")
	public void user_enters_api_key() {
		wlan.enterAPIKey();
	}
	
	
	@And("User hits Go Button")
	public void user_enters_go_button() {
		wlan.hitGoButton();
	}

	
	@Then("user should be displayed a list of client networks that are connected to Meraki Wireless LAN")
	public void user_should_be_displayed_a_list_of_client_networks_that_are_connected_to_meraki_wireless_lan() {
		wlan.verifyNetworkList();
	}

	
	@Then("user clicks on {string}")
	public void user_clicks_on(String string) {
		wlan.clickWirelessLAN(string);
	}
	
	
	@Then("user should be displayed details about the LAN")
	public void user_should_be_displayed_details_about_the_lan() {
		wlan.verifyNetworkDetails();
	   
	}
	

}
