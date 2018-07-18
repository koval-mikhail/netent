package tests;

import net.ent.webpages.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestThree extends GeneralClass {

    @Test
    public void thirdTest() throws InterruptedException {

        int totalSpinsBeforeWin;
        int totalSpinsExpected;
        int totalSpinsActual;

        Page page = new Page();

        page.init(driver);
        totalSpinsBeforeWin = page.waitWhileWin(driver);
        page.waitWhileSpinBtnDisabled(driver);
        totalSpinsExpected = totalSpinsBeforeWin + page.getLastWinCount(driver);
        totalSpinsActual = page.getTotalSpins(driver);

        Assert.assertEquals(totalSpinsActual, totalSpinsExpected);
    }
}
