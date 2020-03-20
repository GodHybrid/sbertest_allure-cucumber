package Steps;

import Pages.MortgageFrame;
import Pages.MortgagePage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

public class MortgagePageSteps extends BaseSteps
{
    @Step("Переключились на вложенный iframe")
    public void prepareForEntry()
    {
        new MortgagePage().prepareForEntry();
    }
}
