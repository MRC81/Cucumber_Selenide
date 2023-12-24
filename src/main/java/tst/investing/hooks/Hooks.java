package tst.investing.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;


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
    public void AfterScenario() {
       selenideConfiguration.closeSession();
    }

}
