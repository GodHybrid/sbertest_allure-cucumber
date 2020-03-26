package Pages;

import Conditions.fieldChanged;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MortgageFrame extends BasePageObj
{
    String costInfo;
    String feeInfo;
    String termInfo;

    String creditSum;
    String monthlyPay;
    String necInc;
    String percent;

    @FindBy(xpath="//input[@id='estateCost']")
    WebElement estateCost;

    @FindBy(xpath="//input[@id='initialFee']")
    WebElement fee;

    @FindBy(xpath="//input[@id='creditTerm']")
    WebElement term;

    @FindBy(xpath="//input[@data-test-id='paidToCard']/parent::label")
    WebElement sberCard;
    
    @FindBy(xpath = "//input[@data-test-id='canConfirmIncome']/parent::label")
    WebElement incomeConfirmation;
    
    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount']/parent::label")
    WebElement youngFamily;

    @FindBy(xpath="//span[@data-test-id='amountOfCredit']")
    WebElement creditSumElement;

    @FindBy(xpath="//span[@data-test-id='monthlyPayment']")
    WebElement monthlyPayElement;

    @FindBy(xpath="//span[@data-test-id='requiredIncome']")
    WebElement necIncElement;

    @FindBy(xpath="//span[@data-test-id='rate']")
    WebElement percentElement;

    public void setCost(String i)
    {
        waitForLoad.until(ExpectedConditions.elementToBeClickable(waitForLoadElement(estateCost))).click();
        while(!estateCost.getAttribute("value").isEmpty()) estateCost.clear();
        waitForTextApproved(estateCost, i + " ₽");
        costInfo = i;
    }

    public void setInitialFee(String i)
    {
        String currentPercent = driver.findElement(By.xpath("//span[@class='dcCalc_input-row-tablet__inputPercents']")).getText();
        waitForLoad.until(new fieldChanged("//input[@id='initialFee']", currentPercent));
        waitForLoadElement(fee).click();
        while(!fee.getAttribute("value").isEmpty()) fee.clear();
        waitForTextApproved(fee, i + " ₽");
        feeInfo = i;
    }

    public void setCreditTerm(Integer i)
    {
        waitForLoadElement(term).click();
        while(!term.getAttribute("value").isEmpty()) term.clear();
        //estateCost.sendKeys(i);
        waitForTextApproved(term, i.toString() + " лет");
        termInfo = i.toString();
    }

    public void setData()
    {
        waitForLoad.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-test-id='youngFamilyDiscount']/parent::label[@class='dcCalc_switch dcCalc_switch_size_medium dcCalc_switch_checked']"))));
        creditSum = creditSumElement.getText();
        monthlyPay = monthlyPayElement.getText();
        necInc = necIncElement.getText();
        percent = percentElement.getText();
    }

    public void doubleCheck()
    {
        waitForTextApproved(estateCost, costInfo + " ₽");
        waitForTextApproved(fee, feeInfo + " ₽");
        waitForTextApproved(term, termInfo + " лет");
    }

    public void switchFamily()
    {
        waitForLoad.until(ExpectedConditions.elementToBeClickable(waitForLoadElement(youngFamily))).click();
    }

    public void switchIncome()
    {
        String checkIncomeSwitchXPath = "//div[contains(text(),'возможность подтвердить доход')]/parent::div/parent::div";
        waitForLoad.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkIncomeSwitchXPath)));
        waitForLoadElement(incomeConfirmation).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchCard()
    {
        waitForLoadElement(sberCard).click();
    }

    public void checkChanges() 
    {
        waitForLoad.until(new fieldChanged("//span[@data-test-id='monthlyPayment']", monthlyPay));
        waitForLoad.until(new fieldChanged("//span[@data-test-id='requiredIncome']", necInc));
        waitForLoad.until(new fieldChanged("//span[@data-test-id='rate']", percent));
    }

    public void finalTest()
    {
        Assert.assertEquals("2 122 000 ₽", creditSum);
        Assert.assertEquals("17 535 ₽", monthlyPay);
        Assert.assertEquals("29 224 ₽", necInc);
        Assert.assertEquals("9,4 %", percent);
    }
}
