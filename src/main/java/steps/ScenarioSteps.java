package steps;

import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


public class ScenarioSteps {

    MainPage mainPage = new MainPage();
    SendAppPage sendAppPage = new SendAppPage();
    InsuranceProgramPage insuranceProgramPage = new InsuranceProgramPage();
    PolicyPage policyPage = new PolicyPage();
    TravelPage travelPage = new TravelPage();


    @When("^Закрываем куки$")
    public void closeCookies() {
        mainPage.closeCookies();
    }


    @When("^выбран пункт главного меню \"(.+)\"$")
    public void selectMenuItem(String menuItem) {
        mainPage.selectMainMenu(menuItem);
    }

    @When("^выбран подпункт меню \"(.+)\"$")
    public void selectAllTypes(String menuItem) {

        mainPage.selectSubMenu(menuItem);
    }

    @When("Выбран вид страхования: страхование путешественников")
    public void selectKindOfInsurance() {
        insuranceProgramPage.stepTravelInsurance();
    }

    @When("Нажимаем на кнопку Оформить онлайн")
    public void selectButtonIssueOnline() {
        travelPage.issueOnline();
    }

    @When("Нажать на кнопку Оформить на сайте")
    public void selectButtonIssueOnWeb() {
        BaseSteps.getDriver().findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']")).click();
    }

    @When("Переключаемся на новую страницу")
    public void switchToOtherPage() {
        Object[] array = BaseSteps.getDriver().getWindowHandles().toArray();
        String mywindow = BaseSteps.getDriver().getWindowHandle();
        for (Object item : array) {
            if (!mywindow.equals(item.toString())) {
                BaseSteps.getDriver().switchTo().window(item.toString());
                break;
            }
        }
    }

    @When("Проверяем заголовок страницы. Должен быть: \"(.+)\"$")
    public void checkingPageName(String name) {
        policyPage.checkPageName(name);
    }

    @When("Выбираем сумму страхового покрытия")
    public void selectSum() {
        policyPage.amount.click();
    }

    @When("Нажимаем на кнопку Оформить")
    public void sendBtn() {
        policyPage.sendBtn.click();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.<String, String>asMap(String.class, String.class)
                .forEach((field, value) -> sendAppPage.fillField(field, value));

    }

    @When("Отправить заявку$")
    public void checkOutBtn() {
        sendAppPage.checkOutBtn();
    }
}
