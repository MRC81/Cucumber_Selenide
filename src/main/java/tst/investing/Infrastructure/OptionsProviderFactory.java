package tst.investing.Infrastructure;

import org.openqa.selenium.remote.AbstractDriverOptions;
import tst.investing.Infrastructure.BrowserOptions.ChromeOptionsProvider;
import tst.investing.Infrastructure.BrowserOptions.EdgeOptionsProvider;
import tst.investing.Infrastructure.BrowserOptions.FireFoxOptionsProvider;
import tst.investing.Infrastructure.enums.Browsers;
import tst.investing.Infrastructure.enums.Mode;

public class OptionsProviderFactory {
    public static AbstractDriverOptions<?> getOptionsProvider(Browsers browser, String version, Mode mode) {
        return switch (browser) {
            case FIREFOX -> new FireFoxOptionsProvider(version, mode).getOptions();
            case CHROME -> new ChromeOptionsProvider(version, mode).getOptions();
            case EDGE -> new EdgeOptionsProvider(version, mode).getOptions();
            default -> throw new IllegalArgumentException("[ERROR] Invalid browser: " + browser);
        };
    }

}
