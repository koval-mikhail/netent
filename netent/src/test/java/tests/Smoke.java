package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import net.ent.webpages.*;

public class Smoke extends GeneralClass {

    @Test
    public void firstTest() throws InterruptedException {

        Page page = new Page();

        page.init(driver);
        page.clickOnSpinBtn(driver)
            .waitWhileSpinBtnDisabled(driver);

    }

    @Test
    public void secondTest() throws InterruptedException {

        Page page = new Page();

        page.init(driver);

        System.out.println("Total spins before a game: " + page.getTotalSpins(driver));

        page.clickOnBetSpinUpBtn(driver,2)
            .clickOnSpinBtn(driver)
            .waitWhileSpinBtnDisabled(driver);

        System.out.println("Total spins after the game: " + page.getTotalSpins(driver));
    }

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
