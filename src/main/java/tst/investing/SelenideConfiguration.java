package tst.investing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import static java.lang.Boolean.parseBoolean;
import static tst.investing.Infrastructure.CapabilitiesProvider.getCapability;
import static tst.investing.Infrastructure.Utilities.setSelenideProperties;


public class SelenideConfiguration {

    public void getBrowser() {
        String browser = System.getProperty("selenide.browser", "chrome");
        boolean headless = parseBoolean(System.getProperty("selenide.headless", "false"));

        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.baseUrl = "https://www.investing.com";
        Configuration.browserCapabilities = getCapability(browser, "latest", "local");
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "http://localhost:4444/wd/hub";

        setSelenideProperties();
    }

    public void closeSession(){
        WebDriverRunner.closeWebDriver();
    }
}
