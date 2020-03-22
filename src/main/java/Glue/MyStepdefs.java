package Glue;

import Steps.BaseSteps;
import Steps.MortgageFrameSteps;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import Steps.MortgagePageSteps;
import Steps.StartPageSteps;

import java.util.List;

public class MyStepdefs {

    private StartPageSteps startSteps;
    private MortgagePageSteps mortgageSteps;
    private MortgageFrameSteps frameSteps;

    @Before
    public void before()
    {
        BaseSteps.preparation();
        startSteps = new StartPageSteps();
        mortgageSteps = new MortgagePageSteps();
        frameSteps = new MortgageFrameSteps();
    }

    @Когда("^Выбрана ипотека на готовое жильё$")
    public void выбрано_меню_Ипотека(){
        startSteps.searchInMenu("Ипотека","готовое жильё");
    }

    @Когда("^Открыта и подготовлена страница ипотеки$")
    public void подготовка(){
        mortgageSteps.prepareForEntry();
    }

    @Когда("^Заполнены поля:$")
    public void заполнение(DataTable fields)
    {
        List<String> dummy;// = new ArrayList<>();
        dummy = fields.asList(String.class);
        frameSteps.totalSet(dummy.get(0), dummy.get(1), dummy.get(2));
    }

    @Тогда("^Выполнена проверка$")
    public void выполненаПроверка()
    {
        frameSteps.doubleCheck();
    }

    @Когда("^Нажат переключатель Карты Сбербанка$")
    public void нажатПереключательКартыСбербанка()
    {
        frameSteps.switchCard();
    }

    @Тогда("^Нажат переключатель подтверждения дохода$")
    public void нажатПереключательПодтвержденияДохода()
    {
        frameSteps.switchIncome();
    }

    @И("^Сохранены данные$")
    public void сохраненыДанные()
    {
        frameSteps.setData();
    }

    @Когда("^Нажат переключатель Молодой Семьи$")
    public void нажатПереключательМолодойСемьи()
    {
        frameSteps.switchFamily();
    }

    @И("^Выполнен финальный тест$")
    public void выполненФинальныйТест()
    {
        frameSteps.finalTest();
    }

    @Когда("^Убедились в изменении боковых данных$")
    public void убедилисьВИзмененииБоковыхДанных()
    {
        frameSteps.checkChanges();
    }

    @After
    public void after() throws Exception
    {
        BaseSteps.quitAfter();
    }
}
