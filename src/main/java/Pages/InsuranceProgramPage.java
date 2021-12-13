package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsuranceProgramPage extends BasePage {

    @FindBy(xpath = "//div[@data-product='Страхование путешественников']")

    public WebElement travelInsurance;

    public InsuranceProgramPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void stepTravelInsurance() {
        travelInsurance.click();
    }
}
