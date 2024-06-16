package tst.investing.PageObjects;

import static com.codeborne.selenide.Selenide.open;
import static tst.investing.Infrastructure.Utilities.logAndGetString;
import static tst.investing.Infrastructure.LogLevel.ERROR;

public class CommonPage {

    public void navigateTo(String uri) {
        try {
            open(uri);
        } catch (Exception e) {
            throw new IllegalStateException(logAndGetString(ERROR, "Unable to open '" + uri + "' page," +
                    " see the traces: \n" + e));
        }
    }


}
