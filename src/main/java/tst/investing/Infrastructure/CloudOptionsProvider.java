package tst.investing.Infrastructure;

import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.HashMap;

public abstract class CloudOptionsProvider {
    protected HashMap<String, Object> selenoidOptions;
    protected HashMap<String, Object> browserStackOptions;

    public CloudOptionsProvider() {
        selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("enableVNC", true);

        browserStackOptions=new HashMap<>();
        browserStackOptions.putIfAbsent("source", "cucumber-java:sample-master:v1.2");
    }

    public abstract AbstractDriverOptions<?> getOptions();
}
