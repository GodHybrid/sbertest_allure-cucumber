package Steps;

import Pages.MortgageFrame;
import io.qameta.allure.Step;

public class MortgageFrameSteps extends BaseSteps
{
    private MortgageFrame frame = new MortgageFrame();

    @Step("Установили цену: {0}")
    public MortgageFrameSteps setCost(String i)
    {
        frame.setCost(i);
        return this;
    }

    @Step("Установили взнос: {0}")
    public MortgageFrameSteps setInitialFee(String i)
    {
        frame.setInitialFee(i);
        return this;
    }

    @Step("Установили года: {0}")
    public MortgageFrameSteps setCreditTerm(Integer i)
    {
        frame.setCreditTerm(i);
        return this;
    }

    @Step("Сохранили данные")
    public MortgageFrameSteps setData()
    {
        frame.setData();
        return this;
    }

    @Step("Проверка правильности введённых значений...")
    public MortgageFrameSteps doubleCheck()
    {
        frame.doubleCheck();
        return this;
    }

    @Step("Нажали на переключатель <Молодая Семья>")
    public MortgageFrameSteps switchFamily()
    {
        frame.switchFamily();
        return this;
    }

    @Step("Нажали на переключатель <Подтверждение дохода>")
    public MortgageFrameSteps switchIncome()
    {
        frame.switchIncome();
        return this;
    }

    @Step("Нажали на переключатель <Карта Сбербанка>")
    public MortgageFrameSteps switchCard()
    {
        frame.switchCard();
        return this;
    }

    @Step("Ожидаем изменения данных...")
    public MortgageFrameSteps checkChanges()
    {
        frame.checkChanges();
        return this;
    }

    @Step("Финальная проверка: должно упасть")
    public MortgageFrameSteps finalTest()
    {
        frame.finalTest();
        return this;
    }

    public void totalSet(String cost, String fee, String term)
    {
        setCost(cost);
        setInitialFee(fee);
        setCreditTerm(Integer.parseInt(term));
    }
}
