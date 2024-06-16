package tst.investing.Infrastructure.BrowserOptions;

import org.openqa.selenium.remote.AbstractDriverOptions;
import tst.investing.Infrastructure.enums.Browsers;
import tst.investing.Infrastructure.enums.Mode;

public class OptionsProviderFactory {
    public static AbstractDriverOptions<?> getOptionsProvider(Browsers browser, String version, Mode mode) {
        return switch (browser) {
            case FIREFOX -> new FireFoxCloudOptionsProvider(version, mode).getOptions();
            case CHROME -> new ChromeCloudOptionsProvider(version, mode).getOptions();
            case EDGE -> new EdgeCloudOptionsProvider(version, mode).getOptions();
            default -> throw new IllegalArgumentException("[ERROR] Invalid browser: " + browser);
        };
    }

}
