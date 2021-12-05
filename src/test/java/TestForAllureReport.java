import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import steps.BaseSteps;
import steps.SendAppSteps;

import java.util.HashMap;

public class TestForAllureReport extends BaseSteps {
    private Actions actions;

    @Test
    @DisplayName("Страхование путешественников")
    public void testInsurance() {

        driver.get(baseUrl);
        actions = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 80, 1000);

        WebElement cookies = driver.findElement(By.xpath("//BUTTON[@class='kitt-cookie-warning__close'][text()='Закрыть']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookies);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Все страховые программы");

        InsuranceProgramPage insuranceProgramPage = new InsuranceProgramPage(driver);
        insuranceProgramPage.stepTravelInsurance();

        TravelPage travelPage = new TravelPage(driver);
        travelPage.tytle.isDisplayed();
        travelPage.checkPageTitle("Страхование путешественников");
        travelPage.issueOnline();
        driver.findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']")).click();
        Object[] array = driver.getWindowHandles().toArray();
        String mywindow = driver.getWindowHandle();
        for (Object item : array) {
            if (!mywindow.equals(item.toString())) {
                driver.switchTo().window(item.toString());
                break;
            }
        }
        PolicyPage policyPage = new PolicyPage(driver);
        policyPage.issueSum();
        actions.click(policyPage.sendBtn).build().perform();
        SendAppPage sendAppPage = new SendAppPage(driver);
        SendAppSteps sendAppSteps = new SendAppSteps();
        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия", "Андреева");
        testData.put("Имя", "Алена");
        testData.put("Дата рождения", "02.11.1987");
        sendAppPage.person.click();
        testData.put("Фамилия страхователя", "Уу");
        testData.put("Имя страхователя", "Ии");
        testData.put("Отчество страхователя", "Аа");
        testData.put("Дата рождения страхователя", "18.07.1961");
        testData.put("Номер паспорта", "765567");
        testData.put("Дата выдачи паспорта", "06.12.2013");
        sendAppPage.passportSeries.click();
        testData.put("Серия паспорта", "3245");
        sendAppPage.sex.click();
        testData.put("Кем выдан", "ОВД г.Москвы");

        sendAppSteps.fillFields(testData);
        testData.put("Кем выдан", "+7 (919) 111-11-11");
        actions.click(sendAppPage.finalBtn).build().perform();
        sendAppSteps.checkFillFields(testData);

  }
}
