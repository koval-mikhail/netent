package net.ent.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Page {

    @FindBy (id = "spinButton")
    private WebElement spinBtn;

    @FindBy (id = "betSpinUp")
    private WebElement betSpinUp;

    @FindBy (id = "betSpinDown")
    private WebElement betSpinDown;

    @FindBy (id = "bet")
    private WebElement bet;

    @FindBy (id = "credits")
    private WebElement credits;

    @FindBy (id = "lastWin")
    private WebElement lastWin;

    @FindBy (id = "SlotsOuterContainer")
    private WebElement slotsOuterContainer;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Page clickOnSpinBtn(WebDriver driver){
        spinBtn.click();
        Assert.assertEquals("disabled", spinBtn.getAttribute("class"));

        return this;
    }

    public Page clickOnBetSpinUpBtn(WebDriver driver, int count){
        String betPointsStringBefore = bet.getText();
        String betPointsStringAfter;
        int betPointsBefore = Integer.parseInt(betPointsStringBefore);
        int betPointsAfter;
        for (int i = 0; i < count; i++){
            betSpinUp.click();
        }

        betPointsStringAfter = bet.getText();
        betPointsAfter = Integer.parseInt(betPointsStringAfter);
        Assert.assertEquals((betPointsBefore + count), betPointsAfter);

        return this;
    }

    public Integer getTotalSpins(WebDriver driver){
        String countOfTotalSpinsString = credits.getText();
        int countOfTotalSpins = Integer.parseInt(countOfTotalSpinsString);
        Assert.assertNotNull(countOfTotalSpins);

        return countOfTotalSpins;
    }

    public Integer getLastWinCount(WebDriver driver){
        String countOfLastWinString = lastWin.getText();
        int countOfLastWin = Integer.parseInt(countOfLastWinString);
        Assert.assertNotNull(countOfLastWin);

        return countOfLastWin;
    }

    public Page waitWhileSpinBtnDisabled(WebDriver driver) throws InterruptedException {
        while (spinBtn.getAttribute("class").equals("disabled")){
        Thread.sleep(1000);
        }
        Assert.assertNotEquals("disabled", spinBtn.getAttribute("class"));

        return this;
    }

    public int waitWhileWin(WebDriver driver) throws InterruptedException {

        String countOfTotalSpinsString;
        int countOfTotalSpins;

        do{
            countOfTotalSpinsString = credits.getText();
            countOfTotalSpins = Integer.parseInt(countOfTotalSpinsString);

            spinBtn.click();
            Thread.sleep(1000);
        }while (!slotsOuterContainer.getAttribute("class").equals("won"));
        Assert.assertNotEquals("won", spinBtn.getAttribute("class"));

        return countOfTotalSpins;
    }
}
