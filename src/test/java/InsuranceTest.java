import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceTest extends BaseTest {

    private Actions actions;
    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @Test
    @Ignore
        public void testInsurance() {
        driver.get(baseUrl);
        actions = new Actions(driver);
        WebElement cookies = driver.findElement(By.xpath("//BUTTON[@class='kitt-cookie-warning__close'][text()='Закрыть']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookies);

        driver.findElement(By.xpath("//a[@aria-label='Страхование']")).click();
        driver.findElement(By.xpath("//A[@class='kitt-top-menu__link kitt-top-menu__link_second'][text()='Все страховые программы']")).click();


        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//H3[@class='product-catalog__miniheader'][text()='ОСАГО']")));

        driver.findElement(By.xpath("//div[@data-product='Страхование путешественников']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 80, 1000);

        WebElement tytle = driver.findElement(By.xpath("//H1[@class='kitt-heading  page-teaser-dict__header kitt-heading_size_l'][text()='Страхование путешественников']/self::H1"));
        wait.until(ExpectedConditions.visibilityOf(tytle));

        Assert.assertEquals("Страхование путешественников", tytle.getText());
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//LI[@class='kitt-list-item kitt-list-item_ul'][text()='Покрывает риск заболевания ковидом']")));
        driver.findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить онлайн']")).click();
        driver.findElement(By.xpath("//SPAN[@class='kitt-button__text'][text()='Оформить на сайте']")).click();

        Object[] array = driver.getWindowHandles().toArray();
        String mywindow = driver.getWindowHandle();
        for (Object item : array) {
            if (!mywindow.equals(item.toString())) {
                driver.switchTo().window(item.toString());
                break;
            }
        }
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[contains(text(),'Выберите сумму страховой защиты')]")));
        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
        ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[contains(text(),'Стоимость и срок действия')]")));
        actions.click(driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large']"))).build().perform();


        WebElement tytle1 = driver.findElement(By.xpath("//a[contains(text(),'Оформление')]"));
        wait.until(ExpectedConditions.visibilityOf(tytle1));
        Assert.assertEquals("Оформление", tytle1.getText());

        fillField(By.id("surname_vzr_ins_0"), "Андреева");
        fillField(By.id("name_vzr_ins_0"), "Алена");
        fillField(By.id("birthDate_vzr_ins_0"), "02.11.1987");

        driver.findElement(By.xpath("//legend[contains(text(),'Страхователь')]")).click();

        fillField(By.id("person_lastName"), "Уу");
        fillField(By.id("person_firstName"), "Ии");
        fillField(By.id("person_middleName"), "Аа");
        fillField(By.id("person_birthDate"), "18.07.1961");


        fillField(By.id("passportNumber"), "234567");
        fillField(By.id("documentDate"), "06.12.2013");
        driver.findElement(By.id("passportSeries")).click();
        fillField(By.id("passportSeries"), "4502");
        driver.findElement(By.xpath("//label[contains(text(),'Мужской')]")).click();
        fillField(By.id("documentIssue"), "ОВД г.Москвы");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("person_lastName"))));

        actions.click(driver.findElement(By.xpath("//button[@class='btn btn-primary page__btn']"))).build().perform();

        Assert.assertEquals("Уу", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Ии", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Аа", driver.findElement(By.id("person_middleName")).getAttribute("value"));

        Assert.assertEquals("Андреева", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Алена", driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        Assert.assertEquals("Андреева", driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));


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
