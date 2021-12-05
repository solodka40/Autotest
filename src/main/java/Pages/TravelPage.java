package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelPage {
    public TravelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 80, 1000);
        wait.until(ExpectedConditions.visibilityOf(tytle));
    }

    @FindBy(xpath = "//h1[contains(text(),'Страхование путешественников')]")
    public WebElement tytle;
    @Step("заголовок страницы - Отправить заявку равен {0}")
    public void checkPageTitle(String expTitle) {
        String actualTitle = this.tytle.getText();
        Assert.assertEquals("Не тот заголовок! ", expTitle, actualTitle);
    }

    @FindBy(xpath = "//span[contains(text(),'Оформить онлайн')]")
    public WebElement issueOnlineBtn;


    @Step("выполнено нажатие на 'Оформить онлайн'")
    public void issueOnline() {
        issueOnlineBtn.click();
    }
}
