@BlackBox
Feature: Black Box Test for Meraki dashboard

  Background: 
    Given Application is installed and launched
    
	
  Scenario: To verify if the app shows the Organisation network connected to Meraki Wireless LAN
    Given User enters API Key
    And User hits Go Button
    Then user should be displayed a list of client networks that are connected to Meraki Wireless LAN

  
  Scenario Outline: To verify if the app shows network details for individual Wireless LAN
    Given User enters API Key
    And User hits Go Button
    Then user should be displayed a list of client networks that are connected to Meraki Wireless LAN
    And user clicks on "<Wireless LAN>"
    Then user should be displayed details about the LAN
    
    Examples:
    | Wireless LAN           |
    | Wireless New Stadium   |
    | AP                     |
    | Wireless AP 1          |
    | Wireless other desk    |