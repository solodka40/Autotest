package Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceProgramPage {

    @FindBy(xpath = "//div[@data-product='Страхование путешественников']")

    public WebElement travelInsurance;


    public InsuranceProgramPage(WebDriver driver) {


        PageFactory.initElements(driver, this);

    }
@Step("Выбран вид страхования: страхование путешественников")
    public void stepTravelInsurance(){
        travelInsurance.click();
}
}
