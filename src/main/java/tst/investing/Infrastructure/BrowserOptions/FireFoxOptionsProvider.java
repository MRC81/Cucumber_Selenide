package tst.investing.Infrastructure.BrowserOptions;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import tst.investing.Infrastructure.enums.Browsers;
import tst.investing.Infrastructure.enums.Mode;

public class FireFoxOptionsProvider extends OptionsProvider {
    private final String version;
    private final Mode mode;
    public FireFoxOptionsProvider(String version, Mode mode) {
        this.version = version;
        this.mode = mode;
    }

    @Override
    public AbstractDriverOptions<?> getOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
        firefoxOptions.setCapability("browserName", Browsers.FIREFOX.getStringValue());
        firefoxOptions.setCapability("browserVersion", version);
        firefoxOptions.setAcceptInsecureCerts(true);

        switch (mode) {
            case LOCAL -> {
                return firefoxOptions;
            }
            case CLOUD -> {
                firefoxOptions.setCapability("selenoid:options", selenoidOptions);
                return firefoxOptions;
            }
            default -> throw new IllegalArgumentException("[ERROR] Invalid mode: " + mode);
        }
    }

}
