package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelPage extends BasePage {


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
