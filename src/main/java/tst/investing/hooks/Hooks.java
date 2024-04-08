package tst.investing.hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.util.Base64;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static tst.investing.Infrastructure.Utilities.attachScreenshot;


public class Hooks {

    private final tst.investing.SelenideConfiguration selenideConfiguration;

    public Hooks(tst.investing.SelenideConfiguration selenideConfiguration) {
        this.selenideConfiguration = selenideConfiguration;
    }

    @Before
    public void BeforeScenario() {
       selenideConfiguration.getBrowser();
    }

    @After
    public void AfterScenario(Scenario scenario) {
        if (scenario.isFailed())
            attachScreenshot("Failure screenshot");

       selenideConfiguration.closeSession();
    }

}
