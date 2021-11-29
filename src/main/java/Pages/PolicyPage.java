package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyPage {

    @FindBy(xpath = "//*[contains(text(),'Минимальная')]")
    public WebElement amount;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']")
    public WebElement sendBtn;

    public PolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
