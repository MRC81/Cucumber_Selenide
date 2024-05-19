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
### Local run:

Pre-requisites: to run the project you will need Java 17 or higher, Gradle installation is not necessary since the project utilizes a Gradle wrapper.

To run the project without specifying a desired browser (Chrome will be used as a default one) just execute the following command in the command line from the project's root folder:
```
./gradlew clean test 
```
To run the project with the specific browser (assuming, you have it in on your system) execute the following command:
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
### Test results

After the test execution is completed, you can check the results in the Allure Report.
To get the report locally, you will need to [install Allure CMD](https://docs.qameta.io/allure/#_installing_a_commandline) on your system and add the Allure to your $PATH environment variable to call it from the project folder.

run the Allure report dashboard from the project folder by executing the following command:
```
allure serve
```
___

### GitHub Actions:
You can execute one of the pipelines for the manual run:

* [manual-run-standalone-browser.yml](https://github.com/MRC81/Cucumber_Selenide/actions/workflows/manual-run-standalone-browser.yml)
  - This pipeline installs the latest version of the specified browser on the GitHub Action runner system and execute tests in there   

* [manual-run-selenoid.yml](https://github.com/MRC81/Cucumber_Selenide/actions/workflows/manual-run-selenoid.yml)
  - This pipeline uses [Selenoid service](https://aerokube.com/selenoid) to get the specified browser

### Test results
You can test results on the summary dashboard after the execution is complete. The Allure report will be available for the latest execution via this [link](https://mrc81.github.io/Cucumber_Selenide).

## Known Problems and Notes
* On [manual-run-standalone-browser.yml](https://github.com/MRC81/Cucumber_Selenide/actions/workflows/manual-run-standalone-browser.yml) the Edge browser installation/launch might fail due to lack of the related step support;
* On [manual-run-selenoid.yml](https://github.com/MRC81/Cucumber_Selenide/actions/workflows/manual-run-selenoid.yml) the Selenoid service might fail to start or deliver a specified browser due to outdated Selenoid step;
* All the pipelines use public _`ubuntu-latest`_ runner, so it's not guaranteed that this runner delivers enough resources to execute tests without timeouts, hence, the appearance of the   _`org.openqa.selenium.TimeoutException`_ is unfortunately expectable
