package tst.investing.Infrastructure.BrowserOptions;

import org.openqa.selenium.remote.AbstractDriverOptions;
import tst.investing.Infrastructure.enums.Mode;

import java.util.HashMap;

public abstract class OptionsProvider {
    protected HashMap<String, Object> selenoidOptions;

    public OptionsProvider() {
        selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("enableVNC", true);
    }

    public abstract AbstractDriverOptions<?> getOptions();
}
