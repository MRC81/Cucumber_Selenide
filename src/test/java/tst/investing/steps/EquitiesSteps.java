package tst.investing.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tst.investing.PageObjects.EquityPage;
import tst.investing.Infrastructure.TestContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class EquitiesSteps {
    private final TestContext testContext;

    public EquitiesSteps(TestContext testContext) {
        this.testContext = testContext;
    }
    EquityPage equityPage = new EquityPage();

    @When("^get the current Stock value from the page$")
    public void getCurrentStockValue() {
        testContext.scenarioData.put("openValue", equityPage.getEquityOpenValue());
    }

    @And("^get the 52 week range values$")
    public void get52weekRange() {
        Map<String, Double> fiftyTwoWeekRangeValues = equityPage.getEquity52WeekRangeValues();

        testContext.scenarioData.put("startWeekValue", fiftyTwoWeekRangeValues.get("startWeekValue"));
        testContext.scenarioData.put("endWeekValue", fiftyTwoWeekRangeValues.get("endWeekValue"));
    }

    @Then("^verify that the current value is within the 52 week range values$")
    public void verifyValueWithinRange() {
        double openValue = (Double) testContext.scenarioData.get("openValue"),
                startWeekValue = (Double) testContext.scenarioData.get("startWeekValue"),
                endWeekValue = (Double) testContext.scenarioData.get("endWeekValue");

        assertTrue(startWeekValue < openValue && openValue  < endWeekValue,
                "The lastPrice value: " + openValue + " is not within the expected range: "
                        + startWeekValue + " - " + endWeekValue);
    }

}
