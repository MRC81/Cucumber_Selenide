package tst.investing.PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static tst.investing.Infrastructure.Utilities.logAndGetString;
import static tst.investing.hooks.Infrastructure.LogLevel.ERROR;

public class NavBarPage {
    private final By editionButton = By.cssSelector("[class*='EditionSelector_button']");
    private final By editionPopUp = By.cssSelector("[class*='EditionSelector_editions__popup']");
    private final By editionPopUpContent = new ByChained(editionPopUp, By.cssSelector("li a span[class*='text']"));


    public void hoverOverEditionBtn() {
        try {
            $(editionButton).hover();
        } catch (Error e) {
            throw new IllegalStateException(logAndGetString(ERROR, "Unable to hover over Edition button," +
                    " see the traces: \n" + e));
        }
    }

    public void checkIfEditionPopUpIsDisplayed() {
        $(editionPopUp)
                .shouldBe(Condition.visible
                        .because(logAndGetString(ERROR, "The Edition popup is not displayed")),
                        Duration.ofSeconds(5));
    }

    public void checkEditions(List<String> listOfExpectedEditions) {

        $$(editionPopUpContent)
               .shouldHave(textsInAnyOrder(listOfExpectedEditions)
                       .because(logAndGetString(ERROR,
                "The Edition popup content is not as expected")));
    }

}
