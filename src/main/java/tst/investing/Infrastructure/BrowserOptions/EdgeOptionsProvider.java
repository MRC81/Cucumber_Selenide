package tst.investing.Infrastructure.BrowserOptions;

import org.openqa.selenium.Platform;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import tst.investing.Infrastructure.enums.Browsers;
import tst.investing.Infrastructure.enums.Mode;

public class EdgeOptionsProvider extends OptionsProvider {
    private final String version;
    private final Mode mode;
    public EdgeOptionsProvider(String version, Mode mode) {
       this.version = version;
       this.mode = mode;
    }

    @Override
    public AbstractDriverOptions<?> getOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
        edgeOptions.setCapability("browserName", Browsers.EDGE.getStringValue());
        edgeOptions.setCapability("browserVersion", version);
        edgeOptions.setAcceptInsecureCerts(true);

        switch (mode) {
            case LOCAL -> {
                return edgeOptions;
            }
            case CLOUD -> {
                edgeOptions.setCapability("selenoid:options", selenoidOptions);
                return edgeOptions;
            }
            default -> throw new IllegalArgumentException("[ERROR] Invalid mode: " + mode);
        }
    }

}
