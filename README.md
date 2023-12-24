# Cucumber_Selenide

## About
Here is my attempt to combine Cucumber-JVM with Selenide to the best of my knowledge at the moment

## Tech Stack
* Java 17
* Gradle 8.4
* JUnit 5.10
* Cucumber 7.14
* Selenide 7.02
* Allure 2.24

## How to run
**Local run:**

Pre-requisites: to run the project you will need Java 17 or higher, Gradle installation is not necessary since the project utilizes a Gradle wrapper.

To run the project without specifying a desired browser (Chrome will be used as a default one) just execute the following command in the command line from the project's root folder:
```
./gradlew clean test 
```
To run the project with the specific browser execute the following command:
```
./gradlew clean test -Dselenide.browser={browser} 
```
where the {browser} is either 'chrome', or 'firefox', or 'edge', or 'safari', e.g.:
```
./gradlew firefox 
```

You can also define to run the tests in the headless mode as:
```
./gradlew clean test -Dselenide.headless=true 
```

**GitHub Actions:**
You can execute the tests on GitHub Actions using one of the manual workflows


## Test results

After the test execution is completed, you can check the results in the Allure Report. 
To get the report locally, you will need to [install Allure CMD](https://docs.qameta.io/allure/#_installing_a_commandline) on your system and add the Allure to your $PATH environment variable to call it from the project folder.

run the Allure report dashboard from the project folder by executing the following command:
```
allure serve
```
On GitHub Actions you can see the Allure report for the latest execution via this [link](https://mrc81.github.io/Cucumber_Selenide).

## Known Problems and Notes
The _manual-run-selenoid.yml_ workflow currently fails to run the tests because of some issues on the Solenoid step side. Use _manual-run-standalone-browser.yml_ instead.  
