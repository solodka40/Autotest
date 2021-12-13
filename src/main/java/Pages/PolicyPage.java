package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolicyPage extends BasePage {


    @FindBy(xpath = "//*[contains(text(),'Минимальная')]")
    public WebElement amount;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']")
    public WebElement sendBtn;

    @FindBy(xpath = "//div[@class='header__text']")
    public WebElement title;

    public void checkPageName(String name) {
        Assert.assertEquals("Заголовок страницы не равен: " + name + ".", name, title.getText());
    }

}
