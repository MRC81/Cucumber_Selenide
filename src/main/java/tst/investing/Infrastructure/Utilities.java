package tst.investing.Infrastructure;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import tst.investing.SelenideConfiguration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

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
        Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(decoded));
    }


}
