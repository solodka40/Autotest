package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyPage {

    @FindBy(xpath = "//*[contains(text(),'Минимальная')]")
    public WebElement amount;

    @Step ("Выбрана сумма страхового покрытия")
    public void issueSum (){
        amount.click();
    }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']")
    public WebElement sendBtn;

    public PolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
