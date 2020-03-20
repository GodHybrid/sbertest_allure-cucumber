package Steps;

import Pages.BasePageObj;
import Pages.Initialization;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseSteps
{
    @Before
    public static void preparation()
    {
        Initialization.initializeDriver();
    }

    @After
    public static void quitAfter()
    {
        Initialization.getDriver().quit();
    }
}
