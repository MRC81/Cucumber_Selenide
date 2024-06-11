package tst.investing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import tst.investing.Infrastructure.Utilities;
import tst.investing.Infrastructure.enums.Browsers;
import tst.investing.Infrastructure.enums.Mode;

import static java.lang.Boolean.parseBoolean;
import static tst.investing.Infrastructure.BrowserOptions.OptionsProviderFactory.getOptionsProvider;
import static tst.investing.Infrastructure.Utilities.*;
import static tst.investing.Infrastructure.enums.Mode.CLOUD;


public class SelenideConfiguration {

    public void getBrowser() {
        Mode mode = Utilities.getRunMode();

        Configuration.baseUrl = "https://www.investing.com";
        Configuration.browserCapabilities = getOptionsProvider(getBrowserType(), getBrowserVersion(), mode);
        Configuration.remote = mode.equals(CLOUD) ? "http://localhost:4444/wd/hub" : null;

        setSelenideProperties();
    }

    public void closeSession(){
        WebDriverRunner.closeWebDriver();
    }
}
