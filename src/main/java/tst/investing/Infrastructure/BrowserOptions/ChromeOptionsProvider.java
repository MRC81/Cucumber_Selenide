package tst.investing.Infrastructure.BrowserOptions;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import tst.investing.Infrastructure.CloudOptionsProvider;
import tst.investing.Infrastructure.enums.Mode;

public class ChromeOptionsProvider extends CloudOptionsProvider {
    private final String version;
    private final Mode mode;

    public ChromeOptionsProvider(String version, Mode mode) {
       this.version = version;
       this.mode = mode;
    }

    @Override
    public AbstractDriverOptions<?> getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
        chromeOptions.setBrowserVersion(version);
        chromeOptions.setAcceptInsecureCerts(true);

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--verbose");

        switch (mode) {
            case LOCAL -> {
                chromeOptions.addArguments(
                        "--disable-gpu",
                        "--ignore-certificate-errors");
                return chromeOptions;
            }
            case CLOUD_SELENOID -> {
                chromeOptions.setCapability("selenoid:options", selenoidOptions);
                return chromeOptions;
            }
            case CLOUD_BROWSERSTACK -> {
                chromeOptions.setCapability("bstack:options", browserStackOptions);
                return chromeOptions;
            }
            default -> throw new IllegalArgumentException("[ERROR] Invalid mode: " + mode);
        }
    }

}
