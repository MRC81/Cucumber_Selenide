package tst.investing.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tst.investing.PageObjects.NavBarPage;

public class NavBarSteps {
    NavBarPage navBarPage = new NavBarPage();

    @When("user hovers over Edition button on the Top Navigation bar")
    public void userHoversOverEditionBtnOnTheTopNavigationBar() {
        navBarPage.hoverOverEditionBtn();
    }

    @Then("the Edition popup is displayed")
    public void theEditionPopupIsDisplayed() {
        navBarPage.checkIfEditionPopUpIsDisplayed();
    }

    @And("the Edition popup contains the following values:")
    public void theEditionPopupContainsTheFollowingValues(DataTable table) {
        navBarPage.checkEditions(table.asList());
    }
}
