package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelPage {

    @FindBy(xpath = "//h1[contains(text(),'Страхование путешественников')]")
    public WebElement tytle;

    @FindBy(xpath = "//span[contains(text(),'Оформить онлайн')]")
    public WebElement issueOnlineBtn;

    public TravelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 80, 1000);
        wait.until(ExpectedConditions.visibilityOf(tytle));
    }
}
