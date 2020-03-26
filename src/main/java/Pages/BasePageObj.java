package Pages;

import Conditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObj
{
    public static WebDriver driver;
    Actions bobDoSomething;
    WebDriverWait waitForLoad;

    String mainMenuXPath ="//span[@class='lg-menu__text']";

    @FindBy(xpath="//span[@class='lg-menu__text']")
    WebElement mainMenu;

    String subMenuOptionXPath = "//a[@class='lg-menu__sub-link']";

    @FindBy(xpath = "//div[@id='submenu-1']")
    WebElement subMenu;

    public BasePageObj()
    {
        this.driver = Initialization.getDriver();
        waitForLoad = new WebDriverWait(driver, 5);
        bobDoSomething = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForLoadElement(WebElement element)
    {
        return waitForLoad.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForTextApproved(WebElement element, String text)
    {
        while(!waitForLoad.until(new textApproved(text, element))) waitForTextApproved(element, text);
        return element;
    }

    public void searchInSubMenu(String menuTab, String entry)
    {
        waitForLoadElement(mainMenu);

        waitForLoadElement(driver.findElement(By.xpath(mainMenuXPath.substring(0, mainMenuXPath.length() - 1) + " and contains(text(), '" + menuTab + "')]"))).click();

        //Actions hover = bobDoSomething.moveToElement(waitForLoadElement(driver.findElement(By.xpath(mainMenuXPath.substring(0, mainMenuXPath.length() - 1) + " and contains(text(), '" + menuTab + "')]"))));
        //hover.perform();

        waitForLoadElement(subMenu);

        waitForLoadElement(driver.findElement(By.xpath(subMenuOptionXPath.substring(0, subMenuOptionXPath.length() - 1) + " and contains(text(), '" + entry +"')]"))).click();
    }
}
