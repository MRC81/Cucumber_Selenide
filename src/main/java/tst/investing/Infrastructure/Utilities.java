package tst.investing.Infrastructure;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import tst.investing.Infrastructure.enums.Browsers;
import tst.investing.Infrastructure.enums.Mode;
import tst.investing.SelenideConfiguration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import java.util.Arrays;

import static java.lang.Boolean.parseBoolean;
import static tst.investing.hooks.Infrastructure.Log.*;

public class Utilities {

    public static String logAndGetString(tst.investing.hooks.Infrastructure.LogLevel logLevel, String logMessage) {
        switch (logLevel) {
            case ERROR -> error(logMessage);
            case WARN -> warn(logMessage);
            case DEBUG -> debug(logMessage);
            default -> info(logMessage);
        }
        return logMessage;
    }

    public static void setSelenideProperties() {
        Properties props = new Properties();
        InputStream inputStream = SelenideConfiguration.class
                .getClassLoader()
                .getResourceAsStream("selenide.properties");
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!props.isEmpty()) {
            for (Object propObj : props.keySet()) {
                String prop = String.valueOf(propObj);

                if (!System.getProperties().containsKey(prop))
                    System.setProperty(prop, props.getProperty(prop));
            }
        }
    }

    public static void attachScreenshot(String attachmentName) {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        Allure.addAttachment(attachmentName, new ByteArrayInputStream(decoded));
    }

    public static Mode getRunMode() {
        String modeStr = System.getProperty("mode", "LOCAL").toUpperCase();

        try {
            return Mode.valueOf(modeStr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid 'mode' value: " + modeStr
                    + ". Expected one of: " + Arrays.toString(Mode.values()), e);
        }
    }

    public static Browsers getBrowserType() {
        String browserStr = System.getProperty("selenide.browser", "CHROME").toUpperCase();

        try {
            return Browsers.valueOf(browserStr);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid 'browser' value: " + browserStr
                    + ". Expected one of: " + Arrays.toString(Browsers.values()), e);
        }
    }

    public static boolean getHeadlessMode() {
        return parseBoolean(System.getProperty("selenide.headless", "false"));
    }

    public static String getBrowserVersion() {
        return System.getProperty("version", "latest");
    }


}
