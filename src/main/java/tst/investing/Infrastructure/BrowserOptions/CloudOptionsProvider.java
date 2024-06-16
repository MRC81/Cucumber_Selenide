package tst.investing.Infrastructure.BrowserOptions;

import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.HashMap;

public abstract class CloudOptionsProvider {
    protected HashMap<String, Object> selenoidOptions;

    public CloudOptionsProvider() {
        selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("enableVNC", true);
    }

    public abstract AbstractDriverOptions<?> getOptions();
}
