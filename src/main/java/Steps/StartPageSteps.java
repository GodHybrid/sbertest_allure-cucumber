package Steps;

import Pages.StartPage;
import io.qameta.allure.Step;

public class StartPageSteps extends BaseSteps
{
    @Step("Навели на меню, вкладка {0}, выбрали {1} в подменю")
    public StartPageSteps searchInMenu(String x, String u)
    {
        new StartPage().searchInSubMenu(x, u);
        return this;
    }
}
