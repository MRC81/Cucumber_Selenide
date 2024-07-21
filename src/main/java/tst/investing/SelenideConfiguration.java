package tst.investing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import tst.investing.Infrastructure.Utilities;
import tst.investing.Infrastructure.enums.Mode;

import static tst.investing.Infrastructure.OptionsProviderFactory.getOptionsProvider;
import static tst.investing.Infrastructure.Utilities.*;
import static tst.investing.Infrastructure.enums.Mode.CLOUD_BROWSERSTACK;
import static tst.investing.Infrastructure.enums.Mode.CLOUD_SELENOID;


public class SelenideConfiguration {

    public void getBrowser() {
        Mode mode = Utilities.getRunMode();

        Configuration.baseUrl = "https://www.investing.com";
        Configuration.browserCapabilities = getOptionsProvider(getBrowserType(), getBrowserVersion(), mode);
        Configuration.remote = mode.equals(CLOUD_SELENOID)
                ? "http://localhost:4444/wd/hub"
                : mode.equals(CLOUD_BROWSERSTACK)
                ? String.format("https://%s:%s@hub.browserstack.com/wd/hub", getBrowserStackUsername(), getBrowserStackKey())
                : null;

        setSelenideProperties();
    }

    public void closeSession(){
        WebDriverRunner.closeWebDriver();
    }
}
