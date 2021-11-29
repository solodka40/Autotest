import Pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyRefactoringTest extends BaseTest {
private Actions actions;

    @Test
    public void newInsuranceTest() {
        driver.get(baseUrl);
        actions = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 80, 1000);

        WebElement cookies = driver.findElement(By.xpath("//BUTTON[@class='kitt-cookie-warning__close'][text()='Закрыть']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookies);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Все страховые программы");
        new InsuranceProgramPage(driver).travelInsurance.click();
        TravelPage travelPage = new TravelPage(driver);
        travelPage.tytle.isDisplayed();
        Assert.assertEquals("Не тот заголовок! ", "Страхование путешественников", travelPage.tytle.getText());
        travelPage.issueOnlineBtn.click();
        driver.findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']")).click();
        Object[] array = driver.getWindowHandles().toArray();
        String mywindow = driver.getWindowHandle();
        for (Object item : array) {
            if (!mywindow.equals(item.toString())) {
                driver.switchTo().window(item.toString());
                break;
            }
        }
        PolicyPage policyPage=new PolicyPage(driver);
        policyPage.amount.click();
        actions.click(policyPage.sendBtn).build().perform();
        SendAppPage sendAppPage=new SendAppPage(driver);
        sendAppPage.fillField("Фамилия", "Андреева");
        sendAppPage.fillField("Имя", "Алена");
        sendAppPage.fillField("Дата рождения", "02.11.1987");
        sendAppPage.person.click();
        sendAppPage.fillField("Фамилия страхователя", "Уу");
        sendAppPage.fillField("Имя страхователя", "Ии");
        sendAppPage.fillField("Отчество страхователя", "Аа");
        sendAppPage.fillField("Дата рождения страхователя", "18.07.1961");
        sendAppPage.fillField("Номер паспорта", "765567");
        sendAppPage.fillField("Дата выдачи паспорта", "06.12.2013");
        sendAppPage.passportSeries.click();
        sendAppPage.fillField("Серия паспорта", "3245");
        sendAppPage.sex.click();
        sendAppPage.fillField("Кем выдан", "ОВД г.Москвы");
        wait.until(ExpectedConditions.visibilityOf(sendAppPage.person_lastName));
        actions.click(sendAppPage.finalBtn).build().perform();
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//legend[contains(text(),'Контакты')]")));
        driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).click();
        WebElement error = driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']"));
        wait.until(ExpectedConditions.visibilityOf(error));
        String s = driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText();
        Assert.assertTrue(s.contains("При заполнении данных произошла ошибка"));
        String k = driver.findElement(By.xpath("//input-phone2/span/validation-message/span[contains(text(),'Поле не заполнено.')]")).getText();
        Assert.assertTrue(k.contains("Поле не заполнено"));

    }
}
