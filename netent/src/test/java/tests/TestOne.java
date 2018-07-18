package tests;

import net.ent.webpages.Page;
import org.testng.annotations.Test;

public class TestOne extends GeneralClass {

    @Test
    public void firstTest() throws InterruptedException {

        Page page = new Page();

        page.init(driver);
        page.clickOnSpinBtn(driver)
                .waitWhileSpinBtnDisabled(driver);

    }
}
