import Conditions.*;
import Pages.*;

import Pages.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SberIpoteka_Test
{
    @Before
    public void preparation()
    {
        Initialization.initializeDriver();
    }

    @Test
    public void execute() {
        StartPage main = new StartPage();
        main.searchInSubMenu("Ипотека", "готовое жильё");

        MortgagePage mortgage = new MortgagePage();

        MortgageFrame mainFrame = mortgage.prepareForEntry();

        mainFrame.setCost("5 180 000");
        mainFrame.setInitialFee("3 058 000");
        mainFrame.setCreditTerm(30);
        mainFrame.doubleCheck();
        mainFrame.switchCard();
        mainFrame.switchIncome();
        mainFrame.switchFamily();
        mainFrame.doubleCheck();
        mainFrame.setData();
        mainFrame.checkChanges();
        mainFrame.switchIncome();
        mainFrame.setData();
        mainFrame.finalTest();
    }

    @After
    public void finisher()
    {
        Initialization.getDriver().quit();
    }
}
