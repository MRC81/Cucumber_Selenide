package tst.investing.steps;

import io.cucumber.java.en.Given;
import tst.investing.PageObjects.CommonPage;

public class CommonSteps {

    CommonPage commonPage = new CommonPage();

    @Given("{string} page")
    public void openPage(String page) {
        commonPage.navigateTo(page);
    }

}
