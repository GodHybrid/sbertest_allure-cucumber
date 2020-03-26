import Steps.*;
import io.qameta.allure.junit4.Tag;
import io.qameta.allure.junit4.Tags;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AllureTest
{
    private StartPageSteps startSteps;
    private MortgagePageSteps mortgageSteps;
    private MortgageFrameSteps frameSteps;

    @Before
    public void setUp()
    {
        BaseSteps.preparation();
        startSteps = new StartPageSteps();
        mortgageSteps = new MortgagePageSteps();
        frameSteps = new MortgageFrameSteps();
    }

    @Test
    public void queryTest()
    {
        startSteps.searchInMenu("Ипотека","готовое жильё");

        mortgageSteps.prepareForEntry();

        frameSteps.setCost("5 180 000")
                    .setInitialFee("3 058 000")
                    .setCreditTerm(30);
        frameSteps.doubleCheck()
                    .switchCard()
                    .switchIncome()
                    .switchFamily();
        frameSteps.doubleCheck()
                    .setData()
                    .checkChanges()
                    .switchIncome()
                    .setData()
                    .finalTest();
    }

    @After
    public void dispose()
    {
        BaseSteps.quitAfter();
    }
}
