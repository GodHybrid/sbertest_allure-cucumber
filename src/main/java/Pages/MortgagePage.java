package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgagePage extends BasePageObj
{
    JavascriptExecutor je;

    @FindBy(xpath="//div[contains(@data-pid, 'Iframe')]/parent::div")
    WebElement mortgageFrame;

    public MortgageFrame prepareForEntry()
    {
        je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView();", mortgageFrame);
        waitForLoadElement(mortgageFrame).click();
        driver.switchTo().frame(0);
        return new MortgageFrame();
    }
}
