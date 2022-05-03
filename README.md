**Introduction**

This framework is based on Appium, Cucumber-JVM, TestNG, Allure and log4j

1. Appium is an open-source tool for automating native, mobile web, and hybrid applications on iOS mobile, Android mobile, and Windows desktop platforms.
2. Cucumber is used for its simplicity in writing and automating testcases using its english like gherkin syntax
3. TestNG is used for running tests
4. Allure is used for reporting
5. log4j for logging

**Prerequisites**

1. java
2. Appium
3. Maven
4. Xcode
5. Android Studio

**Running the project**

1. Clone the Repo
2. Run mvn clean install to install all the dependencies
3. Edit the src/test/resources/Runner.json Device parameter to either Android or iOS to choose the platform for triggering the tests. 
  e.g To run on an iOS device change the value as below 
  "Device" : "iOS"
5. Device Capabilities can be found under src/test/resources/DeviceSetupList.json.
6. mvn test to trigger the testcases

**Generating Allure Result**

1. Open Terminal and Navigate to the project path
2. type allure serve allure-results

**Execution Results**

Android
![Appium Meraki Android](https://user-images.githubusercontent.com/40816320/166116662-5d234596-b334-4939-8206-c68975e88c9e.png)

iOS 
![Appium Meraki iOS](https://user-images.githubusercontent.com/40816320/166116669-4cc836af-a978-4e68-b071-66786f5258d6.png)
