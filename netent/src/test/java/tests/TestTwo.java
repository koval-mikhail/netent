package tests;

import net.ent.webpages.Page;
import org.testng.annotations.Test;

public class TestTwo extends GeneralClass {

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
}
